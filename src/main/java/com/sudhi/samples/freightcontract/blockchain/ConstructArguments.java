package com.sudhi.samples.freightcontract.blockchain;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sudhi.samples.freightcontract.dto.FreightContractHeader;

public class ConstructArguments {
	
	static Logger log = LoggerFactory.getLogger(ConstructArguments.class);
	
	public static String prepareCreateParameters(FreightContractHeader contractObj){
		String parameters = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			parameters = mapper.writeValueAsString(contractObj);
			log.info(parameters);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return parameters;
	}
	
	public static String prepareUpdateParameters(FreightContractHeader contractObj){
		String parameters = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			parameters = mapper.writeValueAsString(contractObj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return parameters;
	}
	
	public static String prepareQueryParameters(String externalContractId){
		String parameters = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			parameters = mapper.writeValueAsString(externalContractId);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return parameters;
	}
	
	public static FreightContractHeader mapQueryResult(String contractValue){
		ObjectMapper mapper = new ObjectMapper();
		FreightContractHeader contract = null;
		try {
			contract = mapper.readValue(contractValue, FreightContractHeader.class);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return contract;
	}
}
