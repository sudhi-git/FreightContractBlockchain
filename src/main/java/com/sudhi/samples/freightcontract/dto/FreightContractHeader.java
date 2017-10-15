package com.sudhi.samples.freightcontract.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class FreightContractHeader {
	@JsonProperty("FreightContractUUID")
	private String freightContractUUID;
	@JsonProperty("FreightContractID")
	private String freightContractID;
	@JsonProperty("ExternalFreightContractID")
	private String extFreightContractID;
	@JsonProperty("OriginSystem")
	private String originSystem;
	@JsonProperty("ChangeSystem")
	private String changeSystem;
	@JsonProperty("ContractDescription")
	private String contractDescription;
	@JsonProperty("ValidityStart")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date validityStart;
	@JsonProperty("ValidityEnd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date validityEnd;
	@JsonProperty("BP1Id")
	private String bp1Id;
	@JsonProperty("BP1Role")
	private String bp1Role;	
	@JsonProperty("BP1Desc")
	private String bp1Desc;	
	@JsonProperty("BP2Id")
	private String bp2Id;
	@JsonProperty("BP2Role")
	private String bp2Role;
	@JsonProperty("BP2Desc")
	private String bp2Desc;	
	@JsonProperty("Currency")
	private String currency;
	@JsonProperty("ShippingType")
	private String shippingType;
	@JsonProperty("ModeOfTransport")
	private String modeOfTransport;
	@JsonProperty("CreatedBy")
	private String createdBy;
	@JsonProperty("CreatedOn")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date createdOn;
	@JsonProperty("ChangedBy")
	private String changedBy;
	@JsonProperty("ChangedOn")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date changedOn;
	@JsonProperty("CalculationSheet")
	private List<ContractItems> items;
	@ApiModelProperty(value = "Freight Contract UUID", example = "fe6fe96b-05c3-4370-8d3f-ca36416a78e1")
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
	@ApiModelProperty(value = "Freight Contract ID", example="Contract123")
	public String getFreightContractID() {
		return freightContractID;
	}
	public void setFreightContractID(String freightContractID) {
		this.freightContractID = freightContractID;
	}
	@ApiModelProperty(value = "Description of the Freight Contract", example="Freight Contract for testing")
	public String getContractDescription() {
		return contractDescription;
	}
	public void setContractDescription(String contractDescription) {
		this.contractDescription = contractDescription;
	}
	@ApiModelProperty(value = "Validity start date of the contract", example="2017-09-17T19:42:00Z")
	public Date getValidityStart() {
		return validityStart;
	}
	public void setValidityStart(Date validityStart) {
		this.validityStart = validityStart;
	}
	@ApiModelProperty(value = "Validity end date of the contract", example="2018-09-17T19:42:00Z")
	public Date getValidityEnd() {
		return validityEnd;
	}
	public void setValidityEnd(Date validityEnd) {
		this.validityEnd = validityEnd;
	}
	@ApiModelProperty(value = "Originator of the contract", example="BP1")
	public String getBp1Id() {
		return bp1Id;
	}
	public void setBp1Id(String bp1Id) {
		this.bp1Id = bp1Id;
	}
	@ApiModelProperty(value = "Business partner with whom the contract is negotiated", example="BP2")
	public String getBp2Id() {
		return bp2Id;
	}
	public void setBp2Id(String bp2Id) {
		this.bp2Id = bp2Id;
	}
	@ApiModelProperty(value = "Currency of the contract", example="INR")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@ApiModelProperty(value = "Shipping type of the contract", allowableValues="LCL, FCL", example="FCL")
	public String getShippingType() {
		return shippingType;
	}
	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}
	@ApiModelProperty(value = "Mode of transport of the contract", allowableValues="Sea, Land, Air", example="Sea")
	public String getModeOfTransport() {
		return modeOfTransport;
	}
	public void setModeOfTransport(String mot) {
		modeOfTransport = mot;
	}
	@ApiModelProperty(value = "Role of contract originator business partner", example="OrderingParty")
	public String getBp1Role() {
		return bp1Role;
	}
	public void setBp1Role(String bp1Role) {
		this.bp1Role = bp1Role;
	}
	@ApiModelProperty(value = "Business partner description", example="BP1Description")
	public String getBp1Desc() {
		return bp1Desc;
	}
	public void setBp1Desc(String bp1Desc) {
		this.bp1Desc = bp1Desc;
	}
	@ApiModelProperty(value = "Role of business partner with whom the contract is negotiated", example="Carrier")
	public String getBp2Role() {
		return bp2Role;
	}
	public void setBp2Role(String bp2Role) {
		this.bp2Role = bp2Role;
	}
	@ApiModelProperty(value = "Business Partner description", example="BP2Desc")
	public String getBp2Desc() {
		return bp2Desc;
	}
	public void setBp2Desc(String bp2Desc) {
		this.bp2Desc = bp2Desc;
	}
	@ApiModelProperty(value = "External Freight Agreement ID that both parties recognize", example="ExtFreightAgreement")
	public String getExtFreightContractID() {
		return extFreightContractID;
	}
	public void setExtFreightContractID(String extFreightContractID) {
		this.extFreightContractID = extFreightContractID;
	}
	@ApiModelProperty(value = "Origin System of the agreement", example="C2TCLNT001")
	public String getOriginSystem() {
		return originSystem;
	}
	public void setOriginSystem(String sourceSystem) {
		this.originSystem = sourceSystem;
	}
	@ApiModelProperty(value = "Admin Data: Created By User", example="CHANDRASHEKS")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@ApiModelProperty(value = "Admin Data: Contract creation date", example="2017-09-02T19:42:00Z")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	@ApiModelProperty(value = "Admin Data: Changed By User", example="CHANDRASHEKS")
	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	@ApiModelProperty(value = "Admin Data: Contract change date", example="2017-09-14T19:42:00Z")
	public Date getChangedOn() {
		return changedOn;
	}
	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}
	@ApiModelProperty(value = "System where the contract was last changed", example="C3TCLNT001")
	public String getChangeSystem() {
		return changeSystem;
	}
	public void setChangeSystem(String changeSystem) {
		this.changeSystem = changeSystem;
	}
	public FreightContractHeader() {
		super();
	}
	public List<ContractItems> getItems() {
		return items;
	}
	public void setItems(List<ContractItems> items) {
		this.items = items;
	}	
}
