package com.sudhi.samples.freightcontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudhi.samples.freightcontract.dto.FreightContractHeader;
import com.sudhi.samples.freightcontract.service.FreightContractService;

@Controller
public class FreightContractController {
	
	@Autowired
	private FreightContractService contractService;
	
	
	public FreightContractService getContractService() {
		return contractService;
	}

	public void setContractService(FreightContractService contractService) {
		this.contractService = contractService;
	}

	@RequestMapping(method=RequestMethod.POST, value="/saveContractInChain", headers="Accept=application/json")
	public ResponseEntity<Void> saveContractInChain(@RequestBody FreightContractHeader contract){
		String contractUUID = contractService.saveInChain(contract);
		HttpHeaders HttpHeader = new HttpHeaders();
		HttpHeader.add("FreightContractUUID", contractUUID);
		return new ResponseEntity<Void>(HttpHeader, HttpStatus.OK);
	}
}
