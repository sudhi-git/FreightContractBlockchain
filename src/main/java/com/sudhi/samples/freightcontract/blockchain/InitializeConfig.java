package com.sudhi.samples.freightcontract.blockchain;

public class InitializeConfig {
	
	public static void Init() {
		Config configObject = Config.getConfig();
		
		// Set the Orderer Org configuration
		OrgObject ordererOrg = new OrgObject();
		String[] ordererConfig = configObject.getOrdererConfig().split("[ \t]*,[ \t]*");
		ordererOrg.setOrdererLocation(ordererConfig[0]);
		ordererOrg.setName(ordererConfig[1]);
		ordererOrg.setMspid(ordererConfig[2]);
		
		// Set the Shipper Org configuration
		OrgObject shipperOrg = new OrgObject();
		String[] shipperConfig = configObject.getShipperConfig().split("[ \t]*,[ \t]*");
		shipperOrg.setOrdererLocation(ordererConfig[0]);
		shipperOrg.setPeerLocation(shipperConfig[0]);
		shipperOrg.setName(shipperConfig[1]);
		shipperOrg.setMspid(shipperConfig[2]);
		
		// Set the Carrier Org configuration
		OrgObject carrierOrg = new OrgObject();
		String[] carrierConfig = configObject.getCarrierConfig().split("[ \t]*,[ \t]*");
		carrierOrg.setOrdererLocation(ordererConfig[0]);
		carrierOrg.setPeerLocation(carrierConfig[0]);
		carrierOrg.setName(carrierConfig[1]);
		carrierOrg.setMspid(carrierConfig[2]);
		
		// Set the LSP Org configuration
		OrgObject LSPOrg = new OrgObject();
		String[] LSPConfig = configObject.getLSPConfig().split("[ \t]*,[ \t]*");
		LSPOrg.setOrdererLocation(ordererConfig[0]);
		LSPOrg.setPeerLocation(LSPConfig[0]);
		LSPOrg.setName(LSPConfig[1]);
		LSPOrg.setMspid(LSPConfig[2]);
	}


}
