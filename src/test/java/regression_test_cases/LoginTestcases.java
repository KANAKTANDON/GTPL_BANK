package regression_test_cases;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

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
System.out.println("Starting TC_Add_New_Customer...");
		
		   JSONObject testData = jsonReader.getTestData("TC_Add_New_Customer");
		
		commonMethods cm = new commonMethods(driver);
		addNewCustomer nc = new addNewCustomer(driver);
		loginPage login = new loginPage(driver);
		newAccount newacc = new newAccount(driver);
		
		  String username = testData.getString("userid");
		  String password = testData.getString("password");
		  String emailAddress = cm.generateRandomEmailAddress();
		  String initialDeposit = "10000";
		
		
		
		
	try {
		
		
		login.enterUserID_and_password(username,password);
		logInfo("userId passoword entered", "userName_password");
		login.clickLoginButton();
		logInfo("login sucessfully", "login sucessfully");
		nc.clickAddCustomer();
		logInfo("addNewCustomerForm", "addNewCustomerForm");
		nc.addCustomerDetails(testData);
		nc.enterDOB("15", "08", "2000");
		nc.enterEmail(emailAddress);
		nc.enterPasswordCustomer(password);
		
		
		logInfo("newCustomerDetailsEntered", "newCustomerDetailsEntered");
		nc.submitCustomerDetails();
		logInfo("CustomerID", "CustomerID");
		String customerID = nc.getCustomerID();
		logInfo("CustomerID is: "+customerID, "CustomerID");
		
		newacc.clickNewAccount();
		logInfo("createAccount", "createAccount");
		newacc.validateAddNewAccFormText();
		newacc.enterCustomerID(customerID);
		newacc.enterInitialDepositAmount(initialDeposit);
		newacc.clickSubmitButton_newAccCreation();
		logInfo("AccountID", "AccountID");
		String accountID = newacc.getAccountNumber();
		logInfo("AccountID is: "+accountID, "AccountID");
		newacc.validateCustomerid(customerID);
		
	}catch (Exception e) {
		 test.log(LogStatus.FAIL, "TC_Add_New_Customer_Failure");
		 test.log(LogStatus.FAIL,test.addScreenCapture(takeScreenShot("failStep")));
	}
		
		
		
	}
	
		
		
		
		
	
}
