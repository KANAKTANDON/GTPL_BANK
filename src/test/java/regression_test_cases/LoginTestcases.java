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
	
	 
	@Test(priority = 1, enabled = true)
    public void TC_Login_and_Logout() throws Exception {
        test = reports.startTest("TC_Login_and_Logout");
        String userid = "mngr571354";
        String password = "rupumej";
        loginPage login = new loginPage(driver);
        commonMethods cm = new commonMethods(driver);

        try {
            login.enterUserID_and_password(userid, password);
            logInfo(test,"userId passoword entered", "userName_password");
            login.clickLoginButton();
//            logInfo(test, "Login successfully", "login_successfully");
            logInfo(test,"userId passoword entered", "userName_password");
            login.validateGTPLBANKlogo();
            login.clickLogoutButton();
            test.log(LogStatus.PASS, "TC_Login_and_Logout passed");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "TC_Login_and_Logout failed");
            test.log(LogStatus.FAIL, test.addScreenCapture(takeScreenShot("failStep")));
        } finally {
            reports.endTest(test);
        }
    }
	
	@Test(priority=2 , enabled=true)
	public void TC_Add_New_Customer() throws Exception {
<<<<<<< HEAD
		test = reports.startTest("TC_Add_New_Customer");
=======
System.out.println("Starting TC_Add_New_Customer...");
>>>>>>> 19b51db8ec7ff4c6cee4d09a7ebe61b4fb78f7cb
		
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
		logInfo(test,"userId passoword entered", "userName_password");
		login.clickLoginButton();
		logInfo(test,"login sucessfully", "login sucessfully");
		nc.clickAddCustomer();
		logInfo(test,"addNewCustomerForm", "addNewCustomerForm");
		nc.addCustomerDetails(testData);
		nc.enterDOB("15", "08", "2000");
		nc.enterEmail(emailAddress);
		nc.enterPasswordCustomer(password);
		
		
		logInfo(test,"newCustomerDetailsEntered", "newCustomerDetailsEntered");
		nc.submitCustomerDetails();
		logInfo(test,"CustomerID", "CustomerID");
		String customerID = nc.getCustomerID();
		logInfo(test,"CustomerID is: "+customerID, "CustomerID");
		
		newacc.clickNewAccount();
		logInfo(test,"createAccount", "createAccount");
		newacc.validateAddNewAccFormText();
		newacc.enterCustomerID(customerID);
		newacc.enterInitialDepositAmount(initialDeposit);
		newacc.clickSubmitButton_newAccCreation();
		logInfo(test,"AccountID", "AccountID");
		String accountID = newacc.getAccountNumber();
		logInfo(test,"AccountID is: "+accountID, "AccountID");
		newacc.validateCustomerid(customerID);
		 test.log(LogStatus.PASS, "TC_Add_New_Customer passed");
		
	}catch (Exception e) {
		 test.log(LogStatus.FAIL, "TC_Add_New_Customer_Failure");
		 test.log(LogStatus.FAIL,test.addScreenCapture(takeScreenShot("failStep")));
	}
	finally {
		reports.endTest(test);
	}
		
		
		
	}
	
		
		
		
		
	
}
