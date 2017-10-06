package com.sudhi.samples.freightcontract.blockchain;

import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric.sdk.EventHub;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class BlockchainHelper {
	
    public BlockchainHelper() {
    	
    	try{
        	HFClient client = HFClient.createNewInstance();
        	client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
        	
    	}catch (Exception e){
    		e.printStackTrace();
    		fail(e.getMessage());
    	}

	}
    
    
}
