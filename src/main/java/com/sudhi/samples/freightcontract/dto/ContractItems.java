package com.sudhi.samples.freightcontract.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	public String getFreightContractId() {
		return freightContractId;
	}
	public void setFreightContractId(String freightContractId) {
		this.freightContractId = freightContractId;
	}
	public String getFreightContractUUID() {
		return freightContractUUID;
	}
	public void setFreightContractUUID(String freightContractUUID) {
		this.freightContractUUID = freightContractUUID;
	}
	public String getItemUUID() {
		return itemUUID;
	}
	public void setItemUUID(String itemUUID) {
		this.itemUUID = itemUUID;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getStageType() {
		return stageType;
	}
	public void setStageType(String stageType) {
		this.stageType = stageType;
	}
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
