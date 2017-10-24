package com.sudhi.samples.freightcontract.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class ContractItems {
	@JsonProperty("freightContractId")
	private String freightContractId;
	@JsonProperty("freightContractUUID")
	private String freightContractUUID;
	@JsonProperty("itemUUID")
	private String itemUUID;
	@JsonProperty("itemId")
	private String itemId;
	@JsonProperty("stageType")
	private String stageType;
	@JsonProperty("shippingType")
	private String shippingType;
	@JsonProperty("calcSheetItems")
	private List<CalculationSheetItems> items;
	@ApiModelProperty(value = "Contract ID to which the contract item belongs to", example="Contract123")
	public String getFreightContractId() {
		return freightContractId;
	}
	public void setFreightContractId(String freightContractId) {
		this.freightContractId = freightContractId;
	}
	@ApiModelProperty(value = "Contract UUID to which the contract item belongs to", example = "fe6fe96b-05c3-4370-8d3f-ca36416a78e1")
	public String getFreightContractUUID() {
		return freightContractUUID;
	}
	public void setFreightContractUUID(String freightContractUUID) {
		this.freightContractUUID = freightContractUUID;
	}
	@ApiModelProperty(value = "UUID of the contract Item", example = "36c504e4-20a0-4de9-9705-2d66cb75c6bd")
	public String getItemUUID() {
		return itemUUID;
	}
	public void setItemUUID(String itemUUID) {
		this.itemUUID = itemUUID;
	}
	@ApiModelProperty(value = "Human readable format of the contract Item", example = "10")
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	@ApiModelProperty(value = "Stage type of the contract Item", allowableValues="Pre, Main, On", example = "On")
	public String getStageType() {
		return stageType;
	}
	public void setStageType(String stageType) {
		this.stageType = stageType;
	}
	@ApiModelProperty(value = "Shipping type of the contract Item", allowableValues="LCL, FCL", example = "FCL")
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
