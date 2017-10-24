package main

import (
	"encoding/json"
	"fmt"
	"time"

	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
)

// Define the Smart Contract structure
type SmartContract struct {
}

// Define Calculation sheet Items
type CalculationSheetItems struct{
	ItemUUID string `json:"itemUUID"`
	ItemID string `json:"itemID"`
	ChargeType string `json:"chargeType"`
	InstructionCode	string `json:"instructionCode"`
	OperationCode	string `json:"operationCode"`
	ParentItemUUID string `json:"parentItemUUID"`
	RateAmount float32 `json:"rateAmount"`
	RateCurrency string `json:"rateCurrency"`
	MinAmount	float32 `json:"minAmount"`
	MinCurrency	string `json:"minCurrency"`
	MaxAmount	float32 `json:"maxAmount"`
	MaxCurrency	string `json:"maxCurrency"`
	CalculationBase string `json:"calculationBase"`
	PriceUnit	string `json:"priceUnit"`
	PriceUnitUoM	string `json:"priceUnitUoM"`
	ResolutionBase string `json:"resolutionBase"`
	CalculationMethod	string `json:"calculationMethod"`
}

// Define agreement items
type B2BContractItems struct{
	FreightContractId string `json:"freightContractId"`
	FreightContractUUID	string `json:"freightContractUUID"`
	ItemUUID string `json:"itemUUID"`
	ItemId string `json:"itemId"`
	StageType	string `json:"stageType"`
	ShippingType string `json:"shippingType"`
	Items []CalculationSheetItems `json:"calcSheetItems"`
}

// Define the SAP TM B2B Contract structure
type B2BContract struct{
	FreightContractUUID	string `json:"freightContractUUID"`
	FreightContractID	string `json:"freightContractID"`
	ExternalFreightContractID	string `json:"externalFreightContractID"`
	OriginSystem string `json:"originSystem"`
	ChangeSystem string `json:"changeSystem"`
	ContractDescription	string `json:"contractDescription"`
	ValidityStart	time.Time `json:"validityStart"`
	ValidityEnd	time.Time `json:"validityEnd"`
	BP1Id	string `json:"bP1Id"`
	BP1Role	string `json:"bP1Role"`
	BP1Desc	string `json:"bP1Desc"`
	BP2Id	string `json:"bP2Id"`
	BP2Role string `json:"bP2Role"`
	BP2Desc	string `json:"bP2Desc"`
	Currency string `json:"currency"`
	ShippingType string `json:"shippingType"`
	ModeOfTransport	string `json:"modeOfTransport"`
	CreatedBy string `json:"createdBy"`
	CreatedAt time.Time `json:"createdOn"`
	ChangedBy string `json:"changedBy"`
	ChangedOn time.Time `json:"changedOn"`
	CalculationSheet []B2BContractItems `json:"calculationSheet"`
}

/*
 * The Init method is called when the Smart Contract "B2BContract" is instantiated by the blockchain network
 * Best practice is to have any Ledger initialization in separate function -- see initLedger()
 */
func (s *SmartContract) Init(APIstub shim.ChaincodeStubInterface) pb.Response {
	return shim.Success(nil)
}

/*
 * The Invoke method is called as a result of an application request to run the Smart Contract B2BContract
 * The calling application program should specify the particular smart contract function to be called, with arguments
 */
func (s *SmartContract) Invoke(APIstub shim.ChaincodeStubInterface) pb.Response {

	// Retrieve the requested Smart Contract function and arguments
	function, args := APIstub.GetFunctionAndParameters()
	var queryResult []string
	var result string
	var err error
	fmt.Println(function)
	fmt.Println(args)
	// Route to the appropriate handler function to interact with the ledger appropriately
	if function == "queryContract" {
		return s.queryContract(APIstub, args)
	} else if function == "updateContract" {
		return s.updateContract(APIstub, args)
	} else if function == "createContract" {
		return s.createContract(APIstub, args)
	}
	// If called with different function name
	fmt.Println("Received unknown invoke function name - " + function)
	return shim.Error("Received unknown invoke function name - '" + function + "'")
}

func createContract(APIstub shim.ChaincodeStubInterface, args []string) pb.Response {
	if len(args) != 1 {
		fmt.Println("Incorrect number of arguments. Expecting 1")
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}
	contract := B2BContract{}
	json.Unmarshal([]byte(args[0]), &contract)
	result, err := APIstub.GetState(contract.ExternalFreightContractID)
	if err != nil{
		return shim.Error("Failed to get state of the ledger. Try after some time")
	}
	if result != nil{
		return shim.Error("Contract %s already exists", contract.ExternalFreightContractID)
	}
	contractValue, _ := json.Marshal(contract)
	createError := APIstub.PutState(contract.ExternalFreightContractID, contractValue)
	if createError != nil {
		fmt.Println("Failed to create contract: %s", contract.ExternalFreightContractID)
		return shim.Error("Failed to create contract: %s", contract.ExternalFreightContractID)
	}
	fmt.Println(contract.ExternalFreightContractID, "saved successfully")
	return shim.Success(contract)
}

func queryContract(APIstub shim.ChaincodeStubInterface, args []string) pb.Response {

	if len(args) != 1 {
		fmt.Println("Incorrect arguments. Enter the external freight agreement ID")
		return shim.Error("Incorrect arguments. Enter the external freight agreement ID")
	}

	contractValue, err := APIstub.GetState(args[0])
	if err != nil {
		fmt.Println("Failed to get contract: %s", args[0])
		return shim.Error("Failed to get contract: %s. Error: %s", args[0], err)
	}
	if contractValue == nil {
		fmt.Println("Failed to get contract: %s", args[0])
		return shim.Error("Contract not found: %s", args[0])
	}
	return shim.Success(contractValue)
}

func updateContract(APIstub shim.ChaincodeStubInterface, args []string) pb.Response {

	if len(args) != 1 {
		fmt.Println("Incorrect number of arguments. Expecting 1")
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}

	var contract B2BContract
	json.Unmarshal([]byte(args[0]), &contract)
	contractValue, err := APIstub.GetState(contract.ExternalFreightContractID)
	if err != nil {
		fmt.Println("Contract %s does not exist", contract.ExternalFreightContractID)
		return shim.Error("Contract %s does not exist", contract.ExternalFreightContractID)
	}
	if contractValue == nil{
		return shim.Error("Contract %s does not exist", contract.ExternalFreightContractID)
	}

	var contractOld B2BContract

	json.Unmarshal(contractValue, &contractOld)
	contractOld.ContractDescription = contract.ContractDescription
	contractOld.ValidityStart = contract.ValidityStart
	contractOld.ValidityEnd = contract.ValidityEnd
	contractOld.BP1Id = contract.BP1Id
	contractOld.BP1Role = contract.BP1Role
	contractOld.BP1Desc = contract.BP1Desc
	contractOld.BP2Id = contract.BP2Id
	contractOld.BP2Role = contract.BP2Role
	contractOld.BP2Desc = contract.BP2Desc
	contractOld.Currency = contract.Currency
	contractOld.ShippingType = contract.ShippingType
	contractOld.ModeOfTransport = contract.ModeOfTransport
	contractOld.ChangedBy = contract.ChangedBy
	contractOld.ChangedOn = contract.ChangedOn
	contractOld.ChangeSystem = contract.ChangeSystem
	contractOld.CalculationSheet = contract.CalculationSheet
	contractValueUpd, _ := json.Marshal(contractOld)
	err = APIstub.PutState(contract.ExternalFreightContractID, contractValueUpd)

	if err != nil {
		fmt.Println("Update of contract %s failed", contract.ExternalFreightContractID)
		return shim.Error("Update of contract %s failed", contract.ExternalFreightContractID)
	}
	return shim.Success(contract.ExternalFreightContractID + "updated")
}

// main function starts up the chaincode in the container during instantiate
func main() {
    err := shim.Start(new(SmartContract))
		if err != nil {
            fmt.Printf("Error starting B2BContract chaincode: %s", err)
    }
}
