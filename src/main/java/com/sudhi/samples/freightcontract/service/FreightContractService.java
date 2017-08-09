package com.sudhi.samples.freightcontract.service;

import org.springframework.stereotype.Service;

import com.sudhi.samples.freightcontract.dto.FreightContractHeader;

@Service
public class FreightContractService {
	public String saveInChain(FreightContractHeader contract){
		return contract.getFreightContractUUID();
	}
}
