package com.sudhi.samples.freightcontract.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class CalculationSheetItems {
	@JsonProperty("ItemUUID")
	private String ItemUUID;
	@JsonProperty("ItemID")
	private String itemId;
	@JsonProperty("ChargeType")
	private String chargeType;
	@JsonProperty("InstructionCode")
	private String insCode;
	@JsonProperty("OperationCode")
	private String opCode;
	@JsonProperty("ParentItemUUID")
	private String parentItemUUID;
	@JsonProperty("RateAmount")
	private double rateAmount;
	@JsonProperty("RateCurrency")
	private String rateCurrency;
	@JsonProperty("MinAmount")
	private double minAmount;
	@JsonProperty("MinCurrency")
	private String minCurrency;	
	@JsonProperty("MaxAmount")
	private double maxAmount;
	@JsonProperty("MaxCurrency")
	private String maxCurrency;
	@JsonProperty("CalculationBase")
	private String calcBase;
	@JsonProperty("PriceUnit")
	private double priceUnit;
	@JsonProperty("PriceUnitUoM")
	private String priceUnitUom;
	@JsonProperty("ResolutionBase")
	private String resBase;
	@JsonProperty("CalculationMethod")
	private String calcMethod;
	@ApiModelProperty(value = "Item UUID of the contract item")
	public String getItemUUID() {
		return ItemUUID;
	}
	public void setItemUUID(String itemUUID) {
		ItemUUID = itemUUID;
	}
	@ApiModelProperty(value = "Human readable format of the Item UUID of the contract item")
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	@ApiModelProperty(value = "Charge type of the contract item")
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	@ApiModelProperty(value = "Instruction code of the contract item", allowableValues="STND, SUM, EVAL")
	public String getInsCode() {
		return insCode;
	}
	public void setInsCode(String insCode) {
		this.insCode = insCode;
	}
	@ApiModelProperty(value = "Operation Code of the contract item in case of Line Item Selection (EVAL) lines", allowableValues="High, Low, AccessSequence")
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	@ApiModelProperty(value = "Parent Item UUID of the contract item")
	public String getParentItemUUID() {
		return parentItemUUID;
	}
	public void setParentItemUUID(String parentItemUUID) {
		this.parentItemUUID = parentItemUUID;
	}
	@ApiModelProperty(value = "Rate Amount of the contract item")
	public double getRateAmount() {
		return rateAmount;
	}
	public void setRateAmount(double rateAmount) {
		this.rateAmount = rateAmount;
	}
	@ApiModelProperty(value = "Rate Currency of the contract item")
	public String getRateCurrency() {
		return rateCurrency;
	}
	public void setRateCurrency(String rateCurrency) {
		this.rateCurrency = rateCurrency;
	}
	@ApiModelProperty(value = "Minimum amount of the contract item")
	public double getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}
	@ApiModelProperty(value = "Minimum amount currency of the contract item")
	public String getMinCurrency() {
		return minCurrency;
	}
	public void setMinCurrency(String minCurrency) {
		this.minCurrency = minCurrency;
	}
	@ApiModelProperty(value = "Maximum amount of the contract item")
	public double getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}
	@ApiModelProperty(value = "Maximum amount currency of the contract item")
	public String getMaxCurrency() {
		return maxCurrency;
	}
	public void setMaxCurrency(String maxCurrency) {
		this.maxCurrency = maxCurrency;
	}
	@ApiModelProperty(value = "Calculation base of the calculation rule")
	public String getCalcBase() {
		return calcBase;
	}
	public void setCalcBase(String calcBase) {
		this.calcBase = calcBase;
	}
	@ApiModelProperty(value = "Quantity of the calculation base in the calculation rule")
	public double getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(double priceUnit) {
		this.priceUnit = priceUnit;
	}
	@ApiModelProperty(value = "Quantity Unit of Measure of the calculation base in the calculation rule")
	public String getPriceUnitUom() {
		return priceUnitUom;
	}
	public void setPriceUnitUom(String priceUnitUom) {
		this.priceUnitUom = priceUnitUom;
	}
	@ApiModelProperty(value = "Resolution base of the contract item")
	public String getResBase() {
		return resBase;
	}
	public void setResBase(String resBase) {
		this.resBase = resBase;
	}
	@ApiModelProperty(value = "Calculation method of the contract item", allowableValues="Standard, Breakweight, Clipping")
	public String getCalcMethod() {
		return calcMethod;
	}
	public void setCalcMethod(String calcMethod) {
		this.calcMethod = calcMethod;
	}
	public CalculationSheetItems() {
		super();
	}
}
