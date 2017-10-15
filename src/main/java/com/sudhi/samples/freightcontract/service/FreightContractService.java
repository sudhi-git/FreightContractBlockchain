package com.sudhi.samples.freightcontract.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sudhi.samples.freightcontract.blockchain.BlockchainHelper;
import com.sudhi.samples.freightcontract.dto.FreightContractHeader;

@Service
public class FreightContractService {
	private final String SHIPPER_ORG = "ShipperOrg";
	private final String CARRIER_ORG = "CarrierOrg";
	private final String LSP_ORG = "LSPOrg";
	private final String USER = "CHANDRASHEKS";
	private final String SHIPPER_SYS = "C2TCLNT001";
	private final String CARRIER_SYS = "C3TCLNT001";
	private final String LSP_SYS = "C4VCLNT001";
	public ResponseEntity<?> createInChain(FreightContractHeader contract){
		BlockchainHelper hfHelper = new BlockchainHelper();
		String invokeOrg = null;
		switch (contract.getOriginSystem()) {
		case LSP_SYS:
			invokeOrg = this.LSP_ORG;
			break;
		case SHIPPER_SYS:
			invokeOrg = this.SHIPPER_ORG;
			break;
		case CARRIER_SYS:
			invokeOrg = this.CARRIER_ORG;
		default:
			break;
		}
		ResponseEntity<?> response = hfHelper.createContract(this.USER, invokeOrg, contract);
		return response;
	}
	
	public ResponseEntity<?> updateInChain(FreightContractHeader contract){
		BlockchainHelper hfHelper = new BlockchainHelper();
		String invokeOrg = null;
		switch (contract.getChangeSystem()) {
		case LSP_SYS:
			invokeOrg = this.LSP_ORG;
			break;
		case SHIPPER_SYS:
			invokeOrg = this.SHIPPER_ORG;
			break;
		case CARRIER_SYS:
			invokeOrg = this.CARRIER_ORG;
		default:
			break;
		}
		ResponseEntity<?> response = hfHelper.updateContract(this.USER, invokeOrg, contract);
		return response;
	}
	
	public ResponseEntity<?> getContractFromChain(String system, String externalFreightAgreementId){
		BlockchainHelper hfHelper = new BlockchainHelper();
		String invokeOrg = null;
		switch (system) {
		case LSP_SYS:
			invokeOrg = this.LSP_ORG;
			break;
		case SHIPPER_SYS:
			invokeOrg = this.SHIPPER_ORG;
			break;
		case CARRIER_SYS:
			invokeOrg = this.CARRIER_ORG;
		default:
			break;
		}
		ResponseEntity<?> response = hfHelper.queryContract(this.USER, invokeOrg, externalFreightAgreementId);
		return response;
	}
}
