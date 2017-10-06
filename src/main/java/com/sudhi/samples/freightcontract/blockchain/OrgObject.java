package com.sudhi.samples.freightcontract.blockchain;

import org.hyperledger.fabric_ca.sdk.HFCAClient;

public class OrgObject {
	private String name;
	private String mspid;
	private String ordererLocation;
	private String peerLocation;
	private ContractUser admin;
	private ContractUser peerAdmin;
	private HFCAClient caClient;
	private String domainName;
	private String caName;
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
	public String getOrdererLocation() {
		return ordererLocation;
	}
	public void setOrdererLocation(String ordererLocation) {
		this.ordererLocation = ordererLocation;
	}
	public String getPeerLocation() {
		return peerLocation;
	}
	public void setPeerLocation(String peerLocation) {
		this.peerLocation = peerLocation;
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
	public HFCAClient getCaClient() {
		return caClient;
	}
	public void setCaClient(HFCAClient caClient) {
		this.caClient = caClient;
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
