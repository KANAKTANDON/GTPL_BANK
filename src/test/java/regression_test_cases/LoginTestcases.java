package regression_test_cases;

import org.json.JSONObject;
import org.testng.annotations.Test;

import utility.jsonReader;

import pages.addNewCustomer;
import pages.commonMethods;
import pages.loginPage;
import pages.newAccount;

public class LoginTestcases extends baseclass{
	
	 
	@Test(priority=1 , enabled=false)
	public void TC_Login_and_Logout() throws Exception {
		String userid = "mngr571354";
		String password = "rupumej";
		loginPage login = new loginPage(driver);
		commonMethods cm = new commonMethods(driver);
		
		
		login.enterUserID_and_password(userid,password);
		login.clickLoginButton();
		login.validateGTPLBANKlogo();
		login.clickLogoutButton();
	}
	
	@Test(priority=2 , enabled=true)
	public void TC_Add_New_Customer() throws Exception {
		
		   JSONObject testData = jsonReader.getTestData("TC_Add_New_Customer");
		
		commonMethods cm = new commonMethods(driver);
		addNewCustomer nc = new addNewCustomer(driver);
		loginPage login = new loginPage(driver);
		newAccount newacc = new newAccount(driver);
		
		  String username = testData.getString("userid");
		  String password = testData.getString("password");
		  String emailAddress = cm.generateRandomEmailAddress();
		  String initialDeposit = "10000";
		
		
		
		
		
		
		login.enterUserID_and_password(username,password);
		login.clickLoginButton();
		nc.clickAddCustomer();
		nc.addCustomerDetails(testData);
		nc.enterDOB("15", "08", "2000");
		nc.enterEmail(emailAddress);
		nc.enterPasswordCustomer(password);
		
//		nc.enterCustomerName(customerName);
//		nc.enterDOB("15", "08", "2000");
//		nc.enterAddress(address);
//		nc.enterCity(city);
//		nc.enterState(state);
//		nc.enterPIN(pin);
//		nc.enterMobile(phone);
		
		
		
		nc.submitCustomerDetails();
		String customerID = nc.getCustomerID();
		
		newacc.clickNewAccount();
		newacc.validateAddNewAccFormText();
		newacc.enterCustomerID(customerID);
		newacc.enterInitialDepositAmount(initialDeposit);
		newacc.clickSubmitButton_newAccCreation();
		String accountID = newacc.getAccountNumber();
		newacc.validateCustomerid(customerID);
		
	}
	
		
		
		
		
	
}
