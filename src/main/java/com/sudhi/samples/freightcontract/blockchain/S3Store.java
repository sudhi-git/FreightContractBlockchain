package com.sudhi.samples.freightcontract.blockchain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.S3Object;

public class S3Store {
	static final String BUCKET_NAME = "blockchainusers";
	public static void setUser(ContractUser user){
		Logger log = LoggerFactory.getLogger(S3Store.class);
		SystemPropertiesCredentialsProvider credsProvider = new SystemPropertiesCredentialsProvider();
		AmazonS3Client s3Client = new AmazonS3Client(credsProvider);
		try{
			File objOut = File.createTempFile(user.getName(), ".txt");
			FileOutputStream fileOut = new FileOutputStream(objOut);
			ObjectOutputStream obj = new ObjectOutputStream(fileOut);
			obj.writeObject(user);
			obj.close();
			s3Client.putObject(BUCKET_NAME, user.getName(), objOut);
		}catch(Exception e){
			log.error(e.getMessage());
		}		
	}
	
	public static ContractUser getUser(String userName, String org, HFCAClient caAuth){
		Logger log = LoggerFactory.getLogger(S3Store.class);
		ContractUser user = null;
		S3Object s3Object = null;
		SystemPropertiesCredentialsProvider credsProvider = new SystemPropertiesCredentialsProvider();
		AmazonS3Client s3Client = new AmazonS3Client(credsProvider);
		try{
			s3Object = s3Client.getObject(BUCKET_NAME, userName);
		}catch(AmazonS3Exception e){
			if(e.getStatusCode() == 404){ //Object not found
				user = new ContractUser(userName, org, caAuth);
			}
		}
		if(s3Object!=null){
			InputStream objIs = s3Object.getObjectContent();
			try{
				ObjectInputStream obj = new ObjectInputStream(objIs);
				user = (ContractUser) obj.readObject();
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}else{
			if(user == null){
				user = new ContractUser(userName, org, caAuth);
			}
		}
		return user;
	}

}
