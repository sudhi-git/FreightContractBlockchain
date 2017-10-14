package com.sudhi.samples.freightcontract.controller;

import com.sudhi.samples.freightcontract.dto.FreightContractHeader;

public class ContractResponse {
	
	private String ContractUUID;
	private String ContractID;
	private String Message;
	private String txId;
	private int HTTPStatus;
	private FreightContractHeader contract;
	public String getContractUUID() {
		return ContractUUID;
	}
	public void setContractUUID(String contractUUID) {
		ContractUUID = contractUUID;
	}
	public String getContractID() {
		return ContractID;
	}
	public void setContractID(String contractID) {
		ContractID = contractID;
	}
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public int getHTTPStatus() {
		return HTTPStatus;
	}
	public void setHTTPStatus(int hTTPStatus) {
		HTTPStatus = hTTPStatus;
	}
	public FreightContractHeader getContract() {
		return contract;
	}
	public void setContract(FreightContractHeader contract) {
		this.contract = contract;
	}
	public ContractResponse() {
		super();
	}
	
}
