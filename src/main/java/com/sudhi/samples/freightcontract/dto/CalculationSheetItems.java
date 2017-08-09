package com.sudhi.samples.freightcontract.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("RateTableUUID")
	private String rateTableUUID;
	@JsonProperty("Notes")
	private List<Notes> notes;
	public String getItemUUID() {
		return ItemUUID;
	}
	public void setItemUUID(String itemUUID) {
		ItemUUID = itemUUID;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getInsCode() {
		return insCode;
	}
	public void setInsCode(String insCode) {
		this.insCode = insCode;
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public String getParentItemUUID() {
		return parentItemUUID;
	}
	public void setParentItemUUID(String parentItemUUID) {
		this.parentItemUUID = parentItemUUID;
	}
	public double getRateAmount() {
		return rateAmount;
	}
	public void setRateAmount(double rateAmount) {
		this.rateAmount = rateAmount;
	}
	public String getRateCurrency() {
		return rateCurrency;
	}
	public void setRateCurrency(String rateCurrency) {
		this.rateCurrency = rateCurrency;
	}
	public double getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}
	public String getMaxCurrency() {
		return maxCurrency;
	}
	public void setMaxCurrency(String maxCurrency) {
		this.maxCurrency = maxCurrency;
	}
	public String getCalcBase() {
		return calcBase;
	}
	public void setCalcBase(String calcBase) {
		this.calcBase = calcBase;
	}
	public double getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(double priceUnit) {
		this.priceUnit = priceUnit;
	}
	public String getPriceUnitUom() {
		return priceUnitUom;
	}
	public void setPriceUnitUom(String priceUnitUom) {
		this.priceUnitUom = priceUnitUom;
	}
	public String getResBase() {
		return resBase;
	}
	public void setResBase(String resBase) {
		this.resBase = resBase;
	}
	public String getCalcMethod() {
		return calcMethod;
	}
	public void setCalcMethod(String calcMethod) {
		this.calcMethod = calcMethod;
	}
	public String getRateTableUUID() {
		return rateTableUUID;
	}
	public void setRateTableUUID(String rateTableUUID) {
		this.rateTableUUID = rateTableUUID;
	}
	public List<Notes> getNotes() {
		return notes;
	}
	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}
	public CalculationSheetItems() {
		super();
	}
	
	
}
