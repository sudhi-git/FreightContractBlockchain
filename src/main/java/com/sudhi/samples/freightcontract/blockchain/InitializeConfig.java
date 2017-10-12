package com.sudhi.samples.freightcontract.blockchain;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.hyperledger.fabric_ca.sdk.exception.InvalidArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitializeConfig {
	
	private HashMap<String, OrgObject> contractOrgs = new HashMap<>();
	private static InitializeConfig config;
	
	private InitializeConfig() {
		// Logging object
		Logger log = LoggerFactory.getLogger(InitializeConfig.class);
		Config configObject = Config.getConfig();
		
		// Set the Shipper Org configuration
		OrgObject shipperOrg = new OrgObject();
		String[] shipperConfig = configObject.getShipperConfig();
		shipperOrg.setOrdererLocation(configObject.getOrdererLocation());
		shipperOrg.setPeerLocation(shipperConfig[0].trim());
		shipperOrg.setName(shipperConfig[1].trim());
		shipperOrg.setMspid(shipperConfig[2].trim());
		shipperOrg.setCaName(shipperConfig[3].trim());
		shipperOrg.setCaLocation(shipperConfig[4].trim());
		shipperOrg.setDomainName(shipperConfig[5].trim());
		shipperOrg.setEventHubLocation(shipperConfig[6].trim());
		try {
			shipperOrg.setCaClient(HFCAClient.createNewInstance(shipperOrg.getCaName(), shipperOrg.getCaLocation(), shipperOrg.getCaProperties()));
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		} catch (InvalidArgumentException e) {
			log.error(e.getMessage());
		}
		contractOrgs.put("Shipper", shipperOrg);
		
		// Set the Carrier Org configuration
		OrgObject carrierOrg = new OrgObject();
		String[] carrierConfig = configObject.getCarrierConfig();
		carrierOrg.setOrdererLocation(configObject.getOrdererLocation());
		carrierOrg.setPeerLocation(carrierConfig[0].trim());
		carrierOrg.setName(carrierConfig[1].trim());
		carrierOrg.setMspid(carrierConfig[2].trim());
		carrierOrg.setCaName(carrierConfig[3].trim());
		carrierOrg.setCaLocation(carrierConfig[4].trim());
		carrierOrg.setDomainName(carrierConfig[5].trim());
		carrierOrg.setEventHubLocation(carrierConfig[6].trim());
		try {
			carrierOrg.setCaClient(HFCAClient.createNewInstance(carrierOrg.getCaName(), carrierOrg.getCaLocation(), carrierOrg.getCaProperties()));
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		} catch (InvalidArgumentException e) {
			log.error(e.getMessage());
		}
		contractOrgs.put("Carrier", carrierOrg);
		
		// Set the LSP Org configuration
		OrgObject LSPOrg = new OrgObject();
		String[] LSPConfig = configObject.getLSPConfig();
		LSPOrg.setOrdererLocation(configObject.getOrdererLocation());
		LSPOrg.setPeerLocation(LSPConfig[0].trim());
		LSPOrg.setName(LSPConfig[1].trim());
		LSPOrg.setMspid(LSPConfig[2].trim());
		LSPOrg.setCaName(LSPConfig[3].trim());
		LSPOrg.setCaLocation(LSPConfig[4].trim());
		LSPOrg.setDomainName(LSPConfig[5].trim());
		LSPOrg.setEventHubLocation(LSPConfig[6].trim());
		try {
			LSPOrg.setCaClient(HFCAClient.createNewInstance(LSPOrg.getCaName(), LSPOrg.getCaLocation(), LSPOrg.getCaProperties()));
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		} catch (InvalidArgumentException e) {
			log.error(e.getMessage());
		}
		contractOrgs.put("LSP", LSPOrg);
	}
	
	public static InitializeConfig getConfig(){
		if(config==null){
			config = new InitializeConfig();
		}
		return config;
	}

	public Collection<OrgObject> getContractOrgs() {
		return Collections.unmodifiableCollection(contractOrgs.values());
	}
}
