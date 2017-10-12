# Blockchain for SAP TM B2B Contracts
=================

## Background

In the ocean business it is pretty common to have "Uncontrolled Shipments" where the shipper instructs the LSP (Logistics Service Provider) to use the carrier of the shipper choice. In these cases for the LSP it becomes an uncontrolled shipment. The shipper chooses the LSP from an operations point of view only.

Here the LSP would have to use the contract that has been negotiated between the shipper and the carrier and charge the shipper.

## Problem Statement

In the traditional approach the shipper maintains a copy of the contract that exists between the shipper and carrier. This approach has the following limitations:
1. The contract in the LSP system is often out of sync due to the negotiations that happen between the shipper and the carrier
2. When the LSP, without the knowledge of the change in contract, bills the shipper with a outdated contract, causes disputes and dispute resolution here is a manual and time consuming effort

## Solution

The idea is to have a blockchain network comprising of the shipper, carrier and LSP and have the contracts stored in a distributed database so that all parties in the network have access to the updated contract.

## Project Details

This project has two main sections:
1. Blockchain network for SAP TM
2. B2B contract chaincode
3. Spring boot based REST endpoints to interact with the chaincode deployed on the blockchain network

## Blockchain network for SAP TM

We have the following organizations in the network:

| Organization name    | Node Type | Number of Peers |
|----------------------|-----------|-----------------|
| Orderer.saptm.com    | Orderer   | NA              |
| Shipperorg.saptm.com | Peer      | 1               |
| Carrierorg.saptm.com | Peer      | 1               |
| LSPorg.saptm.com     | Peer      | 1               |

In order to bring up the network you can use the delivered script file. You need to ensure that you have the following pre-requisites mentioned in the following [link](https://hyperledger-fabric.readthedocs.io/en/latest/prereqs.html)

Steps to follow to bring up the network:
1. Clone the project `git clone https://github.com/sudhi-git/contract-blockchain.git`
2. Navigate to the "network" folder `cd network`
3. If on Mac give the execute rights to the following files
  1. `chmod 755 saptmn.sh`
  2. `chmod 755 scripts/script.sh`
4. Now run `./saptmn.sh -m up`

## B2B Contract Chaincode

In the chaincode folder the chaincode for the above scenario is placed.

The chaincode implements the shim interface of hyperledger. With the implementation of the shim interface one can initialize the ledger and invoke the ledger with:

1. Put the state of an asset into the ledger (POST Operation)
2. Query the state of an asset in the ledger (GET Operation)
3. Update the state of an asset in the ledger (PUT Operation)

For the testing of the chaincode it is suggested to run the chaincode in the docker image of chaincode. This chaincode is installed and instantiated in the peers of the network mentioned above.

## REST Endpoints to interact with the chaincode

The Spring Boot application leverages the Blockchain SDK for Java. For details on the SDK refer to the following [link]https://github.com/hyperledger/fabric-sdk-java

The Spring Boot application provides a swagger enabled APIs for seamless testing. Once you clone the repository:
1. Build the project `mvn clean package`
2. Run the Spring Boot application `mvn spring-boot:run`
3. Access the Swagger UI by typing `http:localhost:8080/swagger-ui.html` in your favorite browser
