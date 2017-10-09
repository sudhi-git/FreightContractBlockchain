package com.sudhi.samples.freightcontract.blockchain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sudhi.samples.freightcontract.dto.FreightContractHeader;

public class ConstructArguments {
	
	public static String prepareCreateParameters(FreightContractHeader contractObj){
		Logger log = LoggerFactory.getLogger(ConstructArguments.class);
		String parameters = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			parameters = mapper.writeValueAsString(contractObj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return parameters;
		
	}

}
