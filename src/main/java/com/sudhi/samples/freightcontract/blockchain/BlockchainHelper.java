package com.sudhi.samples.freightcontract.blockchain;

import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.ProposalResponse;
import org.hyperledger.fabric.sdk.TransactionProposalRequest;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.hyperledger.fabric_ca.sdk.RegistrationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sudhi.samples.freightcontract.controller.ContractResponse;
import com.sudhi.samples.freightcontract.dto.FreightContractHeader;

import org.hyperledger.fabric.sdk.ChaincodeID;
import org.hyperledger.fabric.sdk.Channel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

public class BlockchainHelper {
	
    public ResponseEntity<?> createContract(String invokeUser, String invokeOrg, FreightContractHeader contractObject) {
    	// The SDK client tries to get the user.dir System property. In the case of Spring we are unsure about the same
    	ContractResponse ctrResponse = new ContractResponse();
    	Collection<OrgObject> contractOrgs;
    	OrgObject contractOrg = null;
        byte[] EXPECTED_EVENT_DATA = "!".getBytes(UTF_8);
        String EXPECTED_EVENT_NAME = "event";
    	String[] fcnArgs = new String[1];
    	String txId = null;
    	HttpStatus status = null;
		// Logging support
    	Logger log = LoggerFactory.getLogger(BlockchainHelper.class);
    	
    	// S3 defaults
    	@SuppressWarnings("unused")
		S3PropertyStore s3Prop = new S3PropertyStore();
    	
    	// Load configuration data
    	InitializeConfig contractConfig = InitializeConfig.getConfig();
    	Config chainConfig = Config.getConfig();
    	
    	try{
        	// HyperLedger SDK Client
        	HFClient client = HFClient.createNewInstance();
            client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
            
        	// Build chaincode
        	ChaincodeID chaincodeID = ChaincodeID.newBuilder().setName(chainConfig.getChainCodeName())
    				 .setVersion("1")
    				 .setPath(chainConfig.getChainCodePath()).build();
        	
        	contractOrgs = contractConfig.getContractOrgs();
        	for(OrgObject org : contractOrgs ){
        		if(org.getName().equals(invokeOrg)){
        			contractOrg = org;
        		}
        	}
    		// Setup CA Client
    		HFCAClient ca = contractOrg.getCaClient();
            String mspid = contractOrg.getMspid();
            ca.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
            
            // Try to set admin user
            //ContractUser admin = new ContractUser("admin", invokeOrg);
            //admin.setEnrollment(ca.enroll("admin", "adminpw"));
            //contractOrg.setAdmin(admin);
            
            // Enroll and set the user who has invoked the blockchain
            ContractUser user = S3Store.getUser("user1", invokeOrg);
            if(!user.isRegistered()){
                RegistrationRequest rr = new RegistrationRequest("user1", invokeOrg+".department1");
                rr.setMaxEnrollments(-1);
                user.setEnrollmentSecret(ca.register(rr, user));
                user.setEnrollment(ca.enroll(invokeUser, user.getEnrollmentSecret()));
                user.setMspid(mspid);
                }
            contractOrg.addUser(user);
            
            // Setup channel
            Channel channel = client.newChannel(chainConfig.getChannelName());
                	
            // Perform transaction proposal
            client.setUserContext(user);
            TransactionProposalRequest createContract = client.newTransactionProposalRequest();
            createContract.setChaincodeID(chaincodeID);
            createContract.setFcn("createContract");
            fcnArgs[0] = ConstructArguments.prepareCreateParameters(contractObject);
            Map<String, byte[]> tm2 = new HashMap<>();
            tm2.put("HyperLedgerFabric", "TransactionProposalRequest:JavaSDK".getBytes(UTF_8)); //Just some extra junk in transient map
            tm2.put("method", "TransactionProposalRequest".getBytes(UTF_8));
            tm2.put("result", ":)".getBytes(UTF_8));  
            tm2.put(EXPECTED_EVENT_NAME, EXPECTED_EVENT_DATA);

            createContract.setTransientMap(tm2);
            log.info("Sending create transaction proposal");
            Collection<ProposalResponse> responses = channel.sendTransactionProposal(createContract);

            for (ProposalResponse response : responses) {
                if (response.getStatus() == ProposalResponse.Status.SUCCESS) {
                    log.info("Successful transaction proposal response Txid: %s from peer %s", response.getTransactionID(), response.getPeer().getName());
                    txId = response.getTransactionID();
                    ctrResponse.setTxId(txId);
                    status = HttpStatus.OK;
                } else {
                    log.error(response.getMessage());
                }
            }
    	}catch(Exception e){
    		log.error(e.getMessage());
    		log.error("Error", e);
    		ctrResponse.setMessage(e.getMessage());
    		status = HttpStatus.INTERNAL_SERVER_ERROR;
    	}
    	return new ResponseEntity<>(ctrResponse, status);
	}
    
    
}
