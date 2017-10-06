package com.sudhi.samples.freightcontract.blockchain;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Config {

    private static final Log logger = LogFactory.getLog(Config.class);

    private static final String DEFAULT_CONFIG = "chainconfig.properties";
    private static final String CHAIN_ID = "com.sudhi.samples.freightcontract.chainid";
    private static final String CHAIN_CODE_NAME = "com.sudhi.samples.freightcontract.chaincodename";
    private static final String CHAIN_CODE_PATH = "com.sudhi.samples.freightcontract.chaincodepath";
    private static final String ORDERER_CONFIG = "com.sudhi.samples.freightcontract.ordererconfig";
    private static final String SHIPPER_CONFIG = "com.sudhi.samples.freightcontract.shipperconfig";
    private static final String CARRIER_CONFIG = "com.sudhi.samples.freightcontract.carrierconfig";
    private static final String LSP_CONFIG = "com.sudhi.samples.freightcontract.lspconfig";
    private static final String EVENT_ADDRESS = "com.sudhi.samples.freightcontract.eventhubaddress";
    private static final String CA_ADDRESS = "com.sudhi.samples.freightcontract.caaddress";
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
    
    private static Config config;
    private final static Properties properties = new Properties();
    private Config() {
        File loadFile = null;
        FileInputStream configProps;

        try {
            loadFile = new File(System.getProperty(DEFAULT_CONFIG))
                            .getAbsoluteFile();
            logger.debug(String.format("Loading configuration from %s and it is present: %b", loadFile.toString(),
                            loadFile.exists()));
            configProps = new FileInputStream(loadFile);
            properties.load(configProps);

        } catch (IOException e) {
            logger.error(String.format("Failed to load any configuration from: %s"));
        }
    }
    
    public static Config getConfig() {
        if (null == config) {
            config = new Config();
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
    
    public String getChainId() {
        return getProperty(CHAIN_ID);
    }
    
    public String getChainCodePath() {
        return getProperty(CHAIN_CODE_PATH);
    }

    public String getOrdererConfig() {
        return getProperty(ORDERER_CONFIG);
    }

    public String getShipperConfig() {
        return getProperty(SHIPPER_CONFIG);
    }
    
    public String getCarrierConfig() {
        return getProperty(CARRIER_CONFIG);
    }
    
    public String getLSPConfig() {
        return getProperty(LSP_CONFIG);
    }

    public String getEventAddress() {
        return getProperty(EVENT_ADDRESS);
    }

    public String getCaAddress() {
        return getProperty(CA_ADDRESS);
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
}
