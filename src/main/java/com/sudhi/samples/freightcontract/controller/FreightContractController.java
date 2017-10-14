package com.sudhi.samples.freightcontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(method=RequestMethod.POST, value="/contractInChain", headers="Accept=application/json")
	public ResponseEntity<?> createContractInChain(@RequestBody FreightContractHeader contract){
		ResponseEntity<?> response = contractService.createInChain(contract);
		return response;
	}  
		
	@RequestMapping(method=RequestMethod.PUT, value="/contractInChain", headers="Accept=application/json")
	public ResponseEntity<?> updateContractInChain(@RequestBody FreightContractHeader contract){
		ResponseEntity<?> response = contractService.updateInChain(contract);
		return response;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/contractInChain/{FreightAgreementID}", headers="Accept=application/json")
	public ResponseEntity<?> getContractInChain(@PathVariable("FreightAgreementID") String externalFreightAgreementID){
		ResponseEntity<?> response = contractService.getContractFromChain(externalFreightAgreementID);
		return response;
	}
	
}
