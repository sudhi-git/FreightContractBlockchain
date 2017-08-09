package com.sudhi.samples.freightcontract.dto;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FreightContractHeader {
	@JsonProperty("FreightContractUUID")
	private String freightContractUUID;
	@JsonProperty("FreightContractID")
	private String freightContractID;
	@JsonProperty("ContractDescription")
	private String contractDescription;
	@JsonProperty("ValidityStart")
	private DateTime validityStart;
	@JsonProperty("ValidityEnd")
	private DateTime validityEnd;
	@JsonProperty("BP1Id")
	private String bp1Id;
	@JsonProperty("BP2Id")
	private String bp2Id;
	@JsonProperty("Currency")
	private String currency;
	@JsonProperty("ShippingType")
	private String shippingType;
	@JsonProperty("ModeOfTransport")
	private String MoT;
	@JsonProperty("BP1")
	private List<BusinessPartner> bp1;
	@JsonProperty("BP2")
	private List<BusinessPartner> bp2;
	@JsonProperty("CalculationSheet")
	private List<ContractItems> items;
	public String getFreightContractUUID() {
		return freightContractUUID;
	}
	public void setFreightContractUUID(String freightContractUUID) {
		if(freightContractUUID==null || freightContractUUID.equals("")){
			this.freightContractUUID = UUID.randomUUID().toString();
		}else{
			this.freightContractUUID = freightContractUUID;
		}
	}
	public String getFreightContractID() {
		return freightContractID;
	}
	public void setFreightContractID(String freightContractID) {
		this.freightContractID = freightContractID;
	}
	public String getContractDescription() {
		return contractDescription;
	}
	public void setContractDescription(String contractDescription) {
		this.contractDescription = contractDescription;
	}
	public DateTime getValidityStart() {
		return validityStart;
	}
	public void setValidityStart(DateTime validityStart) {
		this.validityStart = validityStart;
	}
	public DateTime getValidityEnd() {
		return validityEnd;
	}
	public void setValidityEnd(DateTime validityEnd) {
		this.validityEnd = validityEnd;
	}
	public String getBp1Id() {
		return bp1Id;
	}
	public void setBp1Id(String bp1Id) {
		this.bp1Id = bp1Id;
	}
	public String getBp2Id() {
		return bp2Id;
	}
	public void setBp2Id(String bp2Id) {
		this.bp2Id = bp2Id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getShippingType() {
		return shippingType;
	}
	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}
	public String getMoT() {
		return MoT;
	}
	public void setMoT(String moT) {
		MoT = moT;
	}
	public List<BusinessPartner> getBp1() {
		return bp1;
	}
	public void setBp1(List<BusinessPartner> bp1) {
		this.bp1 = bp1;
	}
	public List<BusinessPartner> getBp2() {
		return bp2;
	}
	public void setBp2(List<BusinessPartner> bp2) {
		this.bp2 = bp2;
	}
	public List<ContractItems> getItems() {
		return items;
	}
	public void setItems(List<ContractItems> items) {
		this.items = items;
	}
	public FreightContractHeader() {
		super();
	}
	

}
