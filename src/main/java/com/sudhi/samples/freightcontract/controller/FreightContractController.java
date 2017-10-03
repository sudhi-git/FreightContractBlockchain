package com.sudhi.samples.freightcontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudhi.samples.freightcontract.dto.FreightContractHeader;
import com.sudhi.samples.freightcontract.service.FreightContractService;

@RestController
@EnableAutoConfiguration
@RequestMapping("api/v1/")
public class FreightContractController {
	
	@Autowired
	private FreightContractService contractService;
	
	
	public FreightContractService getContractService() {
		return contractService;
	}

	public void setContractService(FreightContractService contractService) {
		this.contractService = contractService;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="saveContractInChain", headers="Accept=application/json")
	public ResponseEntity<?> saveContractInChain(@RequestBody FreightContractHeader contract){
		String contractUUID = contractService.saveInChain(contract);
		ContractResponse ctrResponse = new ContractResponse();
		ctrResponse.setContractUUID(contractUUID);
		return new ResponseEntity<>(ctrResponse, HttpStatus.OK);
	}  
		
	@RequestMapping(method=RequestMethod.PUT, value="updateContractInChain", headers="Accept=application/json")
	public @ResponseBody ContractResponse updateContractInChain(@RequestBody FreightContractHeader contract){
		String contractUUID = contractService.updateInChain(contract);
		ContractResponse ctrResponse = new ContractResponse();
		ctrResponse.setContractUUID(contractUUID);
		return ctrResponse;
	}
	
}
