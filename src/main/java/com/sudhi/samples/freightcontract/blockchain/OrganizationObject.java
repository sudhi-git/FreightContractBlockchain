package com.sudhi.samples.freightcontract.blockchain;

import org.hyperledger.fabric_ca.sdk.HFCAClient;

public class OrganizationObject {
	
	String name;
	String mspid;
	HFCAClient caClient;
	ContractUser admin;
	ContractUser peerAdmin;
	ContractUser user;
	String peerLocation;
	String ordererLocation;
	String domainName;
	String caName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMspid() {
		return mspid;
	}
	public void setMspid(String mspid) {
		this.mspid = mspid;
	}
	public HFCAClient getCaClient() {
		return caClient;
	}
	public void setCaClient(HFCAClient caClient) {
		this.caClient = caClient;
	}
	public ContractUser getAdmin() {
		return admin;
	}
	public void setAdmin(ContractUser admin) {
		this.admin = admin;
	}
	public ContractUser getPeerAdmin() {
		return peerAdmin;
	}
	public void setPeerAdmin(ContractUser peerAdmin) {
		this.peerAdmin = peerAdmin;
	}
	public ContractUser getUser() {
		return user;
	}
	public void setUser(ContractUser user) {
		this.user = user;
	}
	public String getPeerLocation() {
		return peerLocation;
	}
	public void setPeerLocation(String peerLocation) {
		this.peerLocation = peerLocation;
	}
	public String getOrdererLocation() {
		return ordererLocation;
	}
	public void setOrdererLocation(String ordererLocation) {
		this.ordererLocation = ordererLocation;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getCaName() {
		return caName;
	}
	public void setCaName(String caName) {
		this.caName = caName;
	}
}
