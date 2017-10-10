package com.sudhi.samples.freightcontract.blockchain;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.asn1.x509.V3TBSCertificateGenerator;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.crypto.tls.SignatureAlgorithm;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.x509.X509V3CertificateGenerator;
import org.hyperledger.fabric.sdk.Enrollment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserEnrollment implements Enrollment{
	
	Logger log = LoggerFactory.getLogger(UserEnrollment.class);
	private PrivateKey privateKey;
	private String certificate;
	public UserEnrollment(){
		try {
			X500Name certName = new X500Name("CN=SAPTM");
			Date startDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(startDate);
			c.add(Calendar.DATE, 10); //Set 10 day validity for the certificate
			Date endDate = c.getTime();
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA");
			SecureRandom random = new SecureRandom();
			keyGen.initialize(256, random);
			KeyPair keyPair = keyGen.generateKeyPair();
			this.privateKey = keyPair.getPrivate();
			X509v3CertificateBuilder certGen = new JcaX509v3CertificateBuilder(certName, BigInteger.valueOf(1), startDate, endDate, certName, keyPair.getPublic());
			X509CertificateHolder certHolder = certGen.build(new JcaContentSignerBuilder("SHA256withECDSA").setProvider("BC").build(privateKey));
			X509Certificate cert = new JcaX509CertificateConverter().setProvider("BC").getCertificate(certHolder);
			this.certificate = new String(cert.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage());
		} catch (OperatorCreationException e) {
			log.error(e.getMessage());
		} catch (CertificateException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public PrivateKey getKey() {
		return this.privateKey;
	}

	@Override
	public String getCert() {
		return this.certificate;
	}

}
