package com.sudhi.samples.freightcontract.dto;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class Address {
	@JsonProperty("AddressNumber")
	private Integer addrNumber;
	@JsonProperty("Street1")
	private String Street1;
	@JsonProperty("Street2")
	private String Street2;
	@JsonProperty("HouseNumber")
	private String houseNumber;
	@JsonProperty("PostalCode")
	private String postalCode;
	@JsonProperty("City")
	private String city;
	@JsonProperty("Country")
	private String country;
	@JsonProperty("CountryCode")
	private String countryCode;
	@JsonProperty("EmailAddress")
	private String emailAddress;
	@JsonProperty("PhoneNumber")
	private String phoneNumber;
	   /**
	   * Address number of the business partner
	   * @return addressNumber
	  **/
	  @ApiModelProperty(value = "Address number of the business partner")	
	public Integer getAddrNumber() {
		return addrNumber;
	}
	public void setAddrNumber(Integer addrNumber) {
		if(addrNumber==null){
			Random rnd = new Random();
			this.addrNumber = rnd.nextInt(); 
		}else{
			this.addrNumber = addrNumber;
		}
	}
	  @ApiModelProperty(value = "Street1 part of the address")
	public String getStreet1() {
		return Street1;
	}
	public void setStreet1(String street1) {
		Street1 = street1;
	}
	  @ApiModelProperty(value = "Street2 part of the address")
	public String getStreet2() {
		return Street2;
	}
	public void setStreet2(String street2) {
		Street2 = street2;
	}
	  @ApiModelProperty(value = "House Number of the address")
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	  @ApiModelProperty(value = "Postal Code of the address")
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	  @ApiModelProperty(value = "City of the address")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	  @ApiModelProperty(value = "Country of the address")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	  @ApiModelProperty(value = "Country Code of the address")
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	  @ApiModelProperty(value = "Email Address of the Business Partner")
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@ApiModelProperty(value = "Phone Number of the Business Partner")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address() {
		super();
	}
	
}
