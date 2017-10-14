package com.sudhi.samples.freightcontract.blockchain;

import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.Orderer;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.ProposalResponse;
import org.hyperledger.fabric.sdk.QueryByChaincodeRequest;
import org.hyperledger.fabric.sdk.TransactionProposalRequest;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sudhi.samples.freightcontract.controller.ContractResponse;
import com.sudhi.samples.freightcontract.dto.FreightContractHeader;

import org.hyperledger.fabric.sdk.BlockEvent.TransactionEvent;
import org.hyperledger.fabric.sdk.ChaincodeID;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.EventHub;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import static java.nio.charset.StandardCharsets.UTF_8;

public class BlockchainHelper {
	
	private HFClient fabricClient = null;
	private Channel fabricChannel = null;
	private ChaincodeID chaincodeID = null;
	private Collection<OrgObject> contractOrgs;
	private OrgObject contractOrg = null;
	private ContractResponse fabricResponse = new ContractResponse();
	private HttpStatus status = null;
	Logger log = LoggerFactory.getLogger(BlockchainHelper.class);
	Collection<ProposalResponse> successful = new LinkedList<>();
    Collection<ProposalResponse> failed = new LinkedList<>();
    Collection<ProposalResponse> responses = new LinkedList<>();
    TransactionEvent transEvent = null;
	
	public void initHFC(String invokeUser, String invokeOrg) throws InvalidArgumentException, CryptoException, TransactionException{
    	    	
    	// Load configuration data
    	InitializeConfig contractConfig = InitializeConfig.getConfig();
    	ContractConfig chainConfig = ContractConfig.getConfig();
    	
        	// HyperLedger SDK Client
        	fabricClient = HFClient.createNewInstance();
        	fabricClient.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
            
        	// Build chaincode
        	chaincodeID = ChaincodeID.newBuilder().setName(chainConfig.getChainCodeName())
    				 .setVersion("1.0")
    				 .setPath(chainConfig.getChainCodePath()).build();
        	
        	contractOrgs = contractConfig.getContractOrgs();
        	for(OrgObject org : contractOrgs ){
        		if(org.getName().equals(invokeOrg)){
        			contractOrg = org;
        		}
        	}
        	
        	// Get the Solo orderer org
        	OrgObject ordOrg = contractConfig.getOrderer();
        	
    		// Setup CA Client
    		HFCAClient ca = contractOrg.getCaClient();
            ca.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
                        
            // Set the peer admin for the channel reconstruction
            fabricClient.setUserContext(contractOrg.getPeerAdmin());
            
            //Reconstruct the channel
            fabricChannel = fabricClient.newChannel(chainConfig.getChannelName());
            Orderer ord = fabricClient.newOrderer(ordOrg.getName(), ordOrg.getOrdererLocation(), ordOrg.getOrgProperties());
            fabricChannel.addOrderer(ord);
            Peer peer = fabricClient.newPeer(contractOrg.getName(), contractOrg.getPeerLocation(), contractOrg.getOrgProperties());
            fabricChannel.addPeer(peer);
            Properties eHubProps = new Properties();
            eHubProps = contractOrg.getOrgProperties();
            EventHub eHub = fabricClient.newEventHub(contractOrg.getName(), contractOrg.getEventHubLocation(), eHubProps);
            fabricChannel.addEventHub(eHub);
            
            // Initialize the channel
            fabricChannel.initialize();
            
            // Defaults of the channel
            fabricChannel.setDeployWaitTime(contractConfig.getDEPLOYWAITTIME());
            fabricChannel.setTransactionWaitTime(contractConfig.getINVOKEWAITTIME());
            
            // Set the transaction user context for the transaction proposals
            fabricClient.setUserContext(contractOrg.getUser(contractOrg.getName()+"User"));
	}
	
    public ResponseEntity<?> createContract(String invokeUser, String invokeOrg, FreightContractHeader contractObject) {
        byte[] EXPECTED_EVENT_DATA = "!".getBytes(UTF_8);
        String EXPECTED_EVENT_NAME = "event";
    	String[] fcnArgs = new String[1];
    	// Initialize HF Client
        try {
        	initHFC(invokeUser, invokeOrg);
    	
        	// Perform "Create Contract" transaction proposal
        	fabricClient.setUserContext(contractOrg.getUser(contractOrg.getName()+"User"));

            TransactionProposalRequest createContract = fabricClient.newTransactionProposalRequest();
            createContract.setChaincodeID(chaincodeID);
            createContract.setFcn("createContract");
            fcnArgs[0] = ConstructArguments.prepareCreateParameters(contractObject);
            createContract.setArgs(fcnArgs);
            Map<String, byte[]> tm2 = new HashMap<>();
            tm2.put("HyperLedgerFabric", "TransactionProposalRequest:JavaSDK".getBytes(UTF_8)); //Just some extra junk in transient map
            tm2.put("method", "TransactionProposalRequest".getBytes(UTF_8));
            tm2.put("result", ":)".getBytes(UTF_8));  
            tm2.put(EXPECTED_EVENT_NAME, EXPECTED_EVENT_DATA);

			createContract.setTransientMap(tm2);
	        log.info("Sending create transaction proposal");
	        responses = fabricChannel.sendTransactionProposal(createContract, fabricChannel.getPeers());
	        for (ProposalResponse response : responses) {
	            if (response.getStatus() == ProposalResponse.Status.SUCCESS) {
	                log.info("Successful transaction proposal response Txid: %s from peer %s", response.getTransactionID(), response.getPeer().getName());
	                successful.add(response);
	            } else {
	                failed.add(response);
	            }
	        }
	        if(failed.size()>0){
	        	log.error("Creation of contract failed");
	        	for(ProposalResponse err:failed){
	        		fabricResponse.setMessage(err.getMessage());
	        		fabricResponse.setHTTPStatus(500);
	        		status = HttpStatus.INTERNAL_SERVER_ERROR;
	        	}
	        }else{
	        	transEvent = fabricChannel.sendTransaction(successful).get();
	        	fabricResponse.setTxId(transEvent.getTransactionID());
	        	fabricResponse.setMessage("Contract " + contractObject.getFreightContractID() + " Saved");
	        	fabricResponse.setContractUUID(contractObject.getFreightContractUUID());
	        	fabricResponse.setHTTPStatus(HttpStatus.CREATED.value());
	        	status = HttpStatus.CREATED;
	        }
        } catch (InvalidArgumentException e) {
			log.error(e.getMessage());
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (ProposalException e) {
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} catch (CryptoException e) {
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} catch (TransactionException e) {
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} catch (InterruptedException e) {
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} catch (ExecutionException e) {
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
    	return new ResponseEntity<>(fabricResponse, status);
	}
    
    public ResponseEntity<?> updateContract(String invokeUser, String invokeOrg, FreightContractHeader contractObject) {
        byte[] EXPECTED_EVENT_DATA = "!".getBytes(UTF_8);
        String EXPECTED_EVENT_NAME = "event";
    	String[] fcnArgs = new String[1];
    	String txId = null;
        // Initialize HF Client
        try {
        	initHFC(invokeUser, invokeOrg);
    	
        	// Perform "Update Contract" transaction proposal
        	fabricClient.setUserContext(contractOrg.getUser(contractOrg.getName()+"User"));

            TransactionProposalRequest updateContract = fabricClient.newTransactionProposalRequest();
            updateContract.setChaincodeID(chaincodeID);
            updateContract.setFcn("updateContract");
            fcnArgs[0] = ConstructArguments.prepareUpdateParameters(contractObject);
            updateContract.setArgs(fcnArgs);
            Map<String, byte[]> tm2 = new HashMap<>();
            tm2.put("HyperLedgerFabric", "TransactionProposalRequest:JavaSDK".getBytes(UTF_8)); //Just some extra junk in transient map
            tm2.put("method", "TransactionProposalRequest".getBytes(UTF_8));
            tm2.put("result", ":)".getBytes(UTF_8));  
            tm2.put(EXPECTED_EVENT_NAME, EXPECTED_EVENT_DATA);

            updateContract.setTransientMap(tm2);
	        log.info("Sending update transaction proposal");
	        Collection<ProposalResponse> responses = fabricChannel.sendTransactionProposal(updateContract, fabricChannel.getPeers());
	        for (ProposalResponse response : responses) {
	            if (response.getStatus() == ProposalResponse.Status.SUCCESS) {
	                log.info("Successful transaction proposal response Txid: %s from peer %s", response.getTransactionID(), response.getPeer().getName());
	                txId = response.getTransactionID();
	                fabricResponse.setTxId(txId);
	                status = HttpStatus.OK;
	            } else {
	                log.error(response.getMessage());
	                fabricResponse.setMessage(response.getMessage());
	                fabricResponse.setHTTPStatus(response.getStatus().getStatus());
	                status = HttpStatus.valueOf(response.getStatus().getStatus());
	            }
	        }
        } catch (InvalidArgumentException e) {
			log.error(e.getMessage());
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (ProposalException e) {
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} catch (CryptoException e) {
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} catch (TransactionException e) {
			fabricResponse.setMessage(e.getMessage());
			fabricResponse.setHTTPStatus(500);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
    	return new ResponseEntity<>(fabricResponse, status);
	}
    
    public ResponseEntity<?> queryContract(String invokeUser, String invokeOrg, String externalFreightContractId) {
        "!".getBytes(UTF_8);
        String[] fcnArgs = new String[1];
    	// Initialize HF Client
        try {
        	initHFC(invokeUser, invokeOrg);
    	
        	// Perform "Query Contract" transaction proposal
        	fabricClient.setUserContext(contractOrg.getUser(contractOrg.getName()+"User"));
            QueryByChaincodeRequest queryByChaincodeRequest = fabricClient.newQueryProposalRequest();
            fcnArgs[0] = ConstructArguments.prepareQueryParameters(externalFreightContractId);
            queryByChaincodeRequest.setArgs(new String[] {externalFreightContractId});
            queryByChaincodeRequest.setFcn("queryContract");
            queryByChaincodeRequest.setChaincodeID(chaincodeID);

            Map<String, byte[]> tm2 = new HashMap<>();
            tm2.put("HyperLedgerFabric", "QueryByChaincodeRequest:JavaSDK".getBytes(UTF_8));
            tm2.put("method", "QueryByChaincodeRequest".getBytes(UTF_8));
            queryByChaincodeRequest.setTransientMap(tm2);

            Collection<ProposalResponse> queryProposals = fabricChannel.queryByChaincode(queryByChaincodeRequest, fabricChannel.getPeers());
            for (ProposalResponse proposalResponse : queryProposals) {
                if (!proposalResponse.isVerified() || proposalResponse.getStatus() != ProposalResponse.Status.SUCCESS) {
                    log.error("Failed query proposal from peer " + proposalResponse.getPeer().getName() + " status: " + proposalResponse.getStatus() +
                            ". Messages: " + proposalResponse.getMessage()
                            + ". Was verified : " + proposalResponse.isVerified());
                } else {
                    String payload = proposalResponse.getProposalResponse().getResponse().getPayload().toStringUtf8();
                    log.info("Query payload of b from peer %s returned %s", proposalResponse.getPeer().getName(), payload);
                    fabricResponse.setContract(ConstructArguments.mapQueryResult(payload));
                    fabricResponse.setHTTPStatus(HttpStatus.OK.value());
                    status = HttpStatus.OK;
                }
            }
        } catch (Exception e) {
            log.error("Caught exception while running query");
        }
    	return new ResponseEntity<>(fabricResponse, status);
	}
}