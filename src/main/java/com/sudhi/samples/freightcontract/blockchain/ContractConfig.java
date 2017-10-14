package com.sudhi.samples.freightcontract.blockchain;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ContractConfig {

    private static final Log logger = LogFactory.getLog(ContractConfig.class);

    private static final String DEFAULT_CONFIG = "src/main/resources/chainconfig.properties";
    private static final String CHANNEL_NAME = "com.sudhi.samples.freightcontract.channel";
    private static final String CHAIN_CODE_NAME = "com.sudhi.samples.freightcontract.chaincodename";
    private static final String CHAIN_CODE_PATH = "com.sudhi.samples.freightcontract.chaincodepath";
    private static final String ORDERER_CONFIG = "com.sudhi.samples.freightcontract.ordererconfig";
    private static final String SHIPPER_CONFIG = "com.sudhi.samples.freightcontract.shipperconfig";
    private static final String CARRIER_CONFIG = "com.sudhi.samples.freightcontract.carrierconfig";
    private static final String LSP_CONFIG = "com.sudhi.samples.freightcontract.lspconfig";
    private static final String EVENT_ADDRESS = "com.sudhi.samples.freightcontract.eventhubaddress";
    private static final String USER_NAME = "com.sudhi.samples.freightcontract.username";
    private static final String USER_PWD = "com.sudhi.samples.freightcontract.userpwd";
    private static final String KEYSTORE_PROPERTIES = "com.sudhi.samples.freightcontract.keystore_properties";
    private static final String DEPLOY_FUNCTION = "com.sudhi.samples.freightcontract.deploy_function";
    private static final String DEPLOY_ARGS = "com.sudhi.samples.freightcontract.deploy_args";
    private static final String INVOKE_FUNCTION = "com.sudhi.samples.freightcontract.invoke_function";
    private static final String INVOKE_CREATE_ARGS = "com.sudhi.samples.freightcontract.create_args";
    private static final String INVOKE_UPDATE_ARGS = "com.sudhi.samples.freightcontract.update_args";
    private static final String INVOKE_QUERY_ARGS = "com.sudhi.samples.freightcontract.query_args";
    private static final String DEPLOY_WAITTIME = "com.sudhi.samples.freightcontract.deploy_waittime";
    private static final String INVOKE_WAITTIME = "com.sudhi.samples.freightcontract.invoke_waittime";
    
    private static ContractConfig config;
    private final static Properties properties = new Properties();
    private ContractConfig() {
        FileInputStream configProps;
        try {
            configProps = new FileInputStream(DEFAULT_CONFIG);
            properties.load(configProps);

        } catch (IOException e) {
            logger.error(String.format("Failed to load any configuration from: %s"));
        }
    }
    
    public static ContractConfig getConfig() {
        if (null == config) {
            config = new ContractConfig();
        }
        return config;
    }
    
    private String getProperty(String property) {

        String ret = properties.getProperty(property);

        if (null == ret) {
            logger.warn(String.format("No configuration value found for '%s'", property));
        }
        return ret;
    }

    @SuppressWarnings("unused")
	private String getProperty(String property, String defaultValue) {

        String ret = properties.getProperty(property, defaultValue);
        return ret;
    }

    private String[] getProperties(String property) {

        String[] ret = properties.getProperty(property).split(",");
        if (null == ret) {
            logger.warn(String.format("No configuration value found for '%s'", property));
        }
        return ret;
    }

    public String getChainCodeName() {
        return getProperty(CHAIN_CODE_NAME);
    }
    
    public String getChainCodePath() {
        return getProperty(CHAIN_CODE_PATH);
    }

    public String[] getOrdererConfig() {
        return getProperties(ORDERER_CONFIG);
    }

    public String[] getShipperConfig() {
        return getProperties(SHIPPER_CONFIG);
    }
    
    public String[] getCarrierConfig() {
        return getProperties(CARRIER_CONFIG);
    }
    
    public String[] getLSPConfig() {
        return getProperties(LSP_CONFIG);
    }

    public String getEventAddress() {
        return getProperty(EVENT_ADDRESS);
    }

    public int getDeployWaittime() {
        return Integer.parseInt(getProperty(DEPLOY_WAITTIME));
    }

    public int getInvokeWaittime() {
        return Integer.parseInt(getProperty(INVOKE_WAITTIME));
    }
    
    public String getUserName() {
        return getProperty(USER_NAME);
    }

    public String getUserPwd() {
        return getProperty(USER_PWD);
    }

    public String getKeystoreProperties() {
        return getProperty(KEYSTORE_PROPERTIES);
    }

    public String getDeployFunction() {
        return getProperty(DEPLOY_FUNCTION);
    }

    public String[] getDeployArgs() {
        return getProperties(DEPLOY_ARGS);
    }

    public String getInvokeFunction() {
        return getProperty(INVOKE_FUNCTION);
    }

    public String[] getInvokeCreateArgs() {
        return getProperties(INVOKE_CREATE_ARGS);
    }

    public String[] getInvokeQueryArgs() {
        return getProperties(INVOKE_QUERY_ARGS);
    }
    
    public String[] getInvokeUpdateArgs() {
    	return getProperties(INVOKE_UPDATE_ARGS);
    }

	public String getChannelName() {
		return getProperty(CHANNEL_NAME);
	}
    
}
