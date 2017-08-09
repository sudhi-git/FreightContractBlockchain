package com.sudhi.samples.freightcontract.dto;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	public String getStreet1() {
		return Street1;
	}
	public void setStreet1(String street1) {
		Street1 = street1;
	}
	public String getStreet2() {
		return Street2;
	}
	public void setStreet2(String street2) {
		Street2 = street2;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
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
