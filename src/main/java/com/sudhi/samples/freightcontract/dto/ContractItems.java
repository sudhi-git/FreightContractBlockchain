package com.sudhi.samples.freightcontract.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class ContractItems {
	@JsonProperty("FreightContractId")
	private String freightContractId;
	@JsonProperty("FreightContractUUID")
	private String freightContractUUID;
	@JsonProperty("ItemUUID")
	private String itemUUID;
	@JsonProperty("ItemId")
	private String itemId;
	@JsonProperty("StageType")
	private String stageType;
	@JsonProperty("ShippingType")
	private String shippingType;
	@JsonProperty("CalcSheetItems")
	private List<CalculationSheetItems> items;
	@ApiModelProperty(value = "Contract ID to which the contract item belongs to")
	public String getFreightContractId() {
		return freightContractId;
	}
	public void setFreightContractId(String freightContractId) {
		this.freightContractId = freightContractId;
	}
	@ApiModelProperty(value = "Contract UUID to which the contract item belongs to")
	public String getFreightContractUUID() {
		return freightContractUUID;
	}
	public void setFreightContractUUID(String freightContractUUID) {
		this.freightContractUUID = freightContractUUID;
	}
	@ApiModelProperty(value = "UUID of the contract Item")
	public String getItemUUID() {
		return itemUUID;
	}
	public void setItemUUID(String itemUUID) {
		this.itemUUID = itemUUID;
	}
	@ApiModelProperty(value = "Human readable format of the contract Item")
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	@ApiModelProperty(value = "Stage type of the contract Item", allowableValues="Pre, Main, On")
	public String getStageType() {
		return stageType;
	}
	public void setStageType(String stageType) {
		this.stageType = stageType;
	}
	@ApiModelProperty(value = "Shipping type of the contract Item", allowableValues="LCL, FCL")
	public String getShippingType() {
		return shippingType;
	}
	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}
	public List<CalculationSheetItems> getItems() {
		return items;
	}
	public void setItems(List<CalculationSheetItems> items) {
		this.items = items;
	}
	public ContractItems() {
		super();
	}
}
