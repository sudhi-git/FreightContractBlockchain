package com.sudhi.samples.freightcontract.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sudhi.samples.freightcontract.blockchain.BlockchainHelper;
import com.sudhi.samples.freightcontract.dto.FreightContractHeader;

@Service
public class FreightContractService {
	public ResponseEntity<?> createInChain(FreightContractHeader contract){
		BlockchainHelper hfHelper = new BlockchainHelper();
		ResponseEntity<?> response = hfHelper.createContract("CHANDRASHEKS", "ShipperOrg", contract);
		return response;
	}
	
	public ResponseEntity<?> updateInChain(FreightContractHeader contract){
		BlockchainHelper hfHelper = new BlockchainHelper();
		ResponseEntity<?> response = hfHelper.updateContract("CHANDRASHEKS", "CarrierOrg", contract);
		return response;
	}
	
	public ResponseEntity<?> getContractFromChain(String externalFreightAgreementId){
		BlockchainHelper hfHelper = new BlockchainHelper();
		ResponseEntity<?> response = hfHelper.queryContract("CHANDRASHEKS", "LSPOrg", externalFreightAgreementId);
		return response;
	}
}
