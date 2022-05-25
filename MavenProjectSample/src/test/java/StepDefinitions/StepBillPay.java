package StepDefinitions;

import PageObjects.BillPay;
import PageObjects.ParaBankAccountOverview;
import Utility.DriverManager;
import io.cucumber.java.en.*;

public class StepBillPay {
	
	ParaBankAccountOverview pbAccontOverView=new ParaBankAccountOverview(DriverManager.driver);
	BillPay bp=new BillPay(DriverManager.driver);
	
	@Given("User click on Bill Pay")
	public void user_click_on_bill_pay() {
	   
		pbAccontOverView.clickOnBillPayLink();
	}
	@When("User enters the Payee Name as {string}")
	public void user_enters_the_payee_name_as(String pNtext) {
	   bp.enterPayeeName(pNtext);
	}
	@When("User enters Address as {string} and city as {string}")
	public void user_enters_address_as_and_city_as(String pAtext, String pACtext) {
	   
		bp.enterPayeeAddress(pAtext);
		bp.enterPayeeAddCity(pACtext);
	}
	@Then("User enters state as {string} and Zip code as {string}")
	public void user_enters_state_as_and_zip_code_as(String pAStext, String pZipTxt) {
	   
		bp.enterPayeeAddState(pAStext);
		bp.enterPayeeZipCode(pZipTxt);
	}
	@Then("User enters the phone number as {string}")
	public void user_enters_the_phone_number_as(String pPhNtext) {
	   
		bp.enterPayeePhNumber(pPhNtext);
	}
	@Then("User enters the Account as {string}")
	public void user_enters_the_account_as(String pAccNumberTxt) {
	   
		bp.enterPayeeAccountNumber(pAccNumberTxt);
	}
	@Then("Verify the Account as {string}")
	public void verify_the_account_as(String pvefAccNumTxt) {
	 
		bp.enterPayeeVefANumber(pvefAccNumTxt);
	}
	@Then("User enters the amount as {string}")
	public void user_enters_the_amount_as(String pAmtTxt) {
	  
		bp.enterPayeeAmt(pAmtTxt);
	}
	@Then("User select the From account as {string}")
	public void user_select_the_from_account_as(String fromAccountTxt) {
	   
		bp.selectfromAccountId(fromAccountTxt);
	}
	@Then("Click on Send Payment")
	public void click_on_send_payment() {
		bp.clickOnSendPayment();
	   
	}
	@Then("User verify error Msg as {string} for empty PayeeName")
	public void user_verify_error_msg_as_for_empty_payee_name(String expectedPNErrorMsg) {
	    bp.verifyErrorMsg_PayeeName(expectedPNErrorMsg);
	}
	@Then("User verify error msg as {string} for empty payeeAddress")
	public void user_verify_error_msg_as_for_empty_payee_address(String expectedPAErrorMsg) {
	  
		bp.verifyErrorMsg_PayeeAddress(expectedPAErrorMsg);
	}
	@Then("User verify error msg as {string} for empty payeeAddressCity")
	public void user_verify_error_msg_as_for_empty_payee_address_city(String expectedPCErrorMsg) {
	   
		bp.verifyErrorMsg_PayeeCity(expectedPCErrorMsg);
	}
	@Then("User verify error msg as {string} for empty payeeAddressState")
	public void user_verify_error_msg_as_for_empty_payee_address_state(String expectedPSErrorMsg) {
	   bp.verifyErrorMsg_PayeeState(expectedPSErrorMsg);
	}
	@Then("User verify error msg as {string} for empty payeeAddressZip")
	public void user_verify_error_msg_as_for_empty_payee_address_zip(String expectedPZipCodeErrorMsg) {
	  bp.verifyErrorMsg_PayeeZipCode(expectedPZipCodeErrorMsg);  
	}
	@Then("User verify error msg as {string} for empty payeePhoneNumber")
	public void user_verify_error_msg_as_for_empty_payee_phone_number(String expectedPhErrorMsg) {
	  
		bp.verifyErrorMsg_PayeePhoneNumber(expectedPhErrorMsg);
	}
	@Then("User verify error msg as {string} for empty payeeAccountNumber")
	public void user_verify_error_msg_as_for_empty_payee_account_number(String expectedPAIdErrorMsg) {
	    
		bp.verifyErrorMsg_PayeeAccountId(expectedPAIdErrorMsg);
	}
	@Then("User verify error msg as {string} for empty payeeVerifyAccountNumber")
	public void user_verify_error_msg_as_for_empty_payee_verify_account_number(String expectedPVAIdErrorMsg) {
	    bp.verifyErrorMsg_PayeeVerifyAccountID(expectedPVAIdErrorMsg);
	}
	@Then("User verify error msg as {string}  for empty payeeAmount")
	public void user_verify_error_msg_as_for_empty_payee_amount(String expectedPAmtErrorMsg) {
       bp.verifyErrorMsg_PayeeAmount(expectedPAmtErrorMsg);
	}
	@When("Verify the invalid accout id error as {string}")
	public void verify_the_invalid_accout_id_error_as(String expectedPAcInvErrorMsg) {
		 bp.verifyInvalidAccountErrorMsg(expectedPAcInvErrorMsg);
	}
	@When("Verify the mismatch verify account id as {string}")
	public void verify_the_mismatch_verify_account_id_as(String expectedMismatchErrorMsg) {
	   
		bp.verifyMismatchVerifyAccountErrorMsg(expectedMismatchErrorMsg);
	}
	
	@Then("Verify the invalid verify account id as {string}")
	public void verify_the_invalid_verify_account_id_as(String expectedVeifyInvAccErrorMsg) {
	  
		bp.verifyInvalidVerifyAccountErrorMsg(expectedVeifyInvAccErrorMsg);
	}



}
