package com.sudhi.samples.freightcontract.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class CalculationSheetItems {
	@JsonProperty("itemUUID")
	private String itemUUID;
	@JsonProperty("itemID")
	private String itemId;
	@JsonProperty("chargeType")
	private String chargeType;
	@JsonProperty("instructionCode")
	private String insCode;
	@JsonProperty("operationCode")
	private String opCode;
	@JsonProperty("parentItemUUID")
	private String parentItemUUID;
	@JsonProperty("rateAmount")
	private String rateAmount;
	@JsonProperty("rateCurrency")
	private String rateCurrency;
	@JsonProperty("minAmount")
	private String minAmount;
	@JsonProperty("minCurrency")
	private String minCurrency;	
	@JsonProperty("maxAmount")
	private String maxAmount;
	@JsonProperty("maxCurrency")
	private String maxCurrency;
	@JsonProperty("calculationBase")
	private String calcBase;
	@JsonProperty("priceUnit")
	private double priceUnit;
	@JsonProperty("priceUnitUoM")
	private String priceUnitUom;
	@JsonProperty("resolutionBase")
	private String resBase;
	@JsonProperty("calculationMethod")
	private String calcMethod;
	@ApiModelProperty(value = "Item UUID of the contract item", example = "46c504e4-20a0-4de9-9705-2d66cb75c6bd")
	public String getItemUUID() {
		return itemUUID;
	}
	public void setItemUUID(String iUUID) {
		itemUUID = iUUID;
	}
	@ApiModelProperty(value = "Human readable format of the Item UUID of the contract item", example = "10")
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	@ApiModelProperty(value = "Charge type of the contract item", example = "FB00")
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	@ApiModelProperty(value = "Instruction code of the contract item", allowableValues="STND, SUM, EVAL", example = "STND")
	public String getInsCode() {
		return insCode;
	}
	public void setInsCode(String insCode) {
		this.insCode = insCode;
	}
	@ApiModelProperty(value = "Operation Code of the contract item in case of Line Item Selection (EVAL) lines", allowableValues="High, Low, AccessSequence", example = "")
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	@ApiModelProperty(value = "Parent Item UUID of the contract item", example = "")
	public String getParentItemUUID() {
		return parentItemUUID;
	}
	public void setParentItemUUID(String parentItemUUID) {
		this.parentItemUUID = parentItemUUID;
	}
	@ApiModelProperty(value = "Rate Amount of the contract item", example = "100.00")
	public String getRateAmount() {
		return rateAmount;
	}
	public void setRateAmount(String rateAmount) {
		this.rateAmount = rateAmount;
	}
	@ApiModelProperty(value = "Rate Currency of the contract item", example = "INR")
	public String getRateCurrency() {
		return rateCurrency;
	}
	public void setRateCurrency(String rateCurrency) {
		this.rateCurrency = rateCurrency;
	}
	@ApiModelProperty(value = "Minimum amount of the contract item", example = "")
	public String getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(String minAmount) {
		this.minAmount = minAmount;
	}
	@ApiModelProperty(value = "Minimum amount currency of the contract item", example = "")
	public String getMinCurrency() {
		return minCurrency;
	}
	public void setMinCurrency(String minCurrency) {
		this.minCurrency = minCurrency;
	}
	@ApiModelProperty(value = "Maximum amount of the contract item", example = "")
	public String getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(String maxAmount) {
		this.maxAmount = maxAmount;
	}
	@ApiModelProperty(value = "Maximum amount currency of the contract item", example = "")
	public String getMaxCurrency() {
		return maxCurrency;
	}
	public void setMaxCurrency(String maxCurrency) {
		this.maxCurrency = maxCurrency;
	}
	@ApiModelProperty(value = "Calculation base of the calculation rule", example = "GROSS_WEIGHT")
	public String getCalcBase() {
		return calcBase;
	}
	public void setCalcBase(String calcBase) {
		this.calcBase = calcBase;
	}
	@ApiModelProperty(value = "Quantity of the calculation base in the calculation rule", example = "100")
	public double getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(double priceUnit) {
		this.priceUnit = priceUnit;
	}
	@ApiModelProperty(value = "Quantity Unit of Measure of the calculation base in the calculation rule", example = "KG")
	public String getPriceUnitUom() {
		return priceUnitUom;
	}
	public void setPriceUnitUom(String priceUnitUom) {
		this.priceUnitUom = priceUnitUom;
	}
	@ApiModelProperty(value = "Resolution base of the contract item", example = "ROOT")
	public String getResBase() {
		return resBase;
	}
	public void setResBase(String resBase) {
		this.resBase = resBase;
	}
	@ApiModelProperty(value = "Calculation method of the contract item", allowableValues="Standard, Breakweight, Clipping", example = "Standard")
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
