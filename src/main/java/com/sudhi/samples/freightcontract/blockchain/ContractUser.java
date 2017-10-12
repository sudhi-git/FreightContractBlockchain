package com.sudhi.samples.freightcontract.blockchain;

import java.util.Set;

import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric_ca.sdk.HFCAClient;

import io.netty.util.internal.StringUtil;

import java.io.Serializable;


public class ContractUser implements User, Serializable{
	
	private static final long serialVersionUID = 1L;
	private Enrollment enrollment = null;
	private String name;
	private String enrollmentSecret;
	private String account;
	private String affiliation;
	private String mspid;
	private String org;
	private Set<String> roles;

	public ContractUser(String name, String org, HFCAClient caAuth){
		this.name = name;
		this.org = org;
		this.enrollment = null;
	}
	
	@Override
	public String getAccount() {
		return this.account;
	}

	@Override
	public String getAffiliation() {
		return this.affiliation;
	}

	@Override
	public Enrollment getEnrollment() {
		return this.enrollment;
	}

	@Override
	public String getMspId() {
		return this.mspid;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Set<String> getRoles() {
		return this.roles;
	}

	public String getOrg() {
		return this.org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
		S3Store.setUser(this);
	}
	
	public String getEnrollmentSecret() {
		return enrollmentSecret;
	}

	public void setEnrollmentSecret(String enrollmentSecret) {
		this.enrollmentSecret = enrollmentSecret;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMspid(String mspid) {
		this.mspid = mspid;
	}
	
	public boolean isRegistered(){
		return !StringUtil.isNullOrEmpty(enrollmentSecret);
	}

}
