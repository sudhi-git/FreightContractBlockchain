package com.sudhi.samples.freightcontract.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class BusinessPartner {
	@JsonProperty("BPUUID")
	private String bpUuid;
	@JsonProperty("BPId")
	private String bpId;
	@JsonProperty("BPDescription")
	private String bpDesc;
	@JsonProperty("BPRole")
	private String bpRole;
	@JsonProperty("Address")
	private List<Address> address;
	public String getBpUuid() {
		return bpUuid;
	}
	public void setBpUuid(String bpUuid) {
		this.bpUuid = bpUuid;
	}
	@ApiModelProperty(value = "Human Readable format for the BP UUID")
	public String getBpId() {
		return bpId;
	}
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}
	@ApiModelProperty(value = "Description of the Business Partner")
	public String getBpDesc() {
		return bpDesc;
	}
	public void setBpDesc(String bpDesc) {
		this.bpDesc = bpDesc;
	}
	@ApiModelProperty(value = "Role of the Business Partner")
	public String getBpRole() {
		return bpRole;
	}
	public void setBpRole(String bpRole) {
		this.bpRole = bpRole;
	}
	@ApiModelProperty(value = "Address of the Business Partner")
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public BusinessPartner() {
		super();
	}
	
}
