package pages;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addNewCustomer extends commonMethods{
	
	locators locators = new locators();
	
	public addNewCustomer(WebDriver d) {
		super(d);
	}
	
	public void clickAddCustomer() {
		clickByXpath(locators.addCustomerxpath());
		System.out.println("addNewCustomer clicked...");
		driver.navigate().refresh();
//		pageRefresh();
		System.out.println("page refresh...");
		clickByXpath(locators.addCustomerxpath());
	}
	
	public void validateAddNewCustomerText() {
		waitforPresence(locators.addnewCustomertextxpath());
		if (driver.findElement
				(By.xpath(locators.addnewCustomertextxpath())).getText().equals("Add New Customer")) {
			System.out.println("Add New Customer Text Displayed on screen....");
		}
		else {
			System.out.println("Add New Customer Text Not Displayed on screen....");
		}
	}
	public void enterCustomerName(String customerName) {
		EnterTextByXpath(locators.customerNamexpath(), customerName);
	}
	
	public void enterDOB(String dd , String mm , String yyyy) throws Exception {
		EnterTextByXpath(locators.dobxpath(), dd);
		EnterTextByXpath(locators.dobxpath(), mm);
		EnterTextByXpath(locators.dobxpath(), yyyy);
		takeScreenShot("date_of_birth");
	}
	 public void enterAddress(String address) {
		 EnterTextByXpath(locators.addressxpath(), address);
	 }
	 public void enterCity(String city) {
		 EnterTextByXpath(locators.cityxpath(), city);
	 }
	 public void enterState(String state) {
		 EnterTextByXpath(locators.statexpath(), state);
	 }
	 public void enterPIN(String pincode) {
		 EnterTextByXpath(locators.pinNumberxpath(), pincode);
		 scrollDown();
	 }
	 public void enterMobile(String mobile) {
		 EnterTextByXpath(locators.telephoneNumberxpath(), mobile);
	 }
	 public void enterEmail(String email) {
		 EnterTextByXpath(locators.emailxpath(),email);
	 }
	 public void enterPasswordCustomer(String password) {
		 EnterTextByXpath(locators.getpasswordNewCustomerxpath(), password);
	 }
	 public void submitCustomerDetails() throws Exception {
		 highLightText(locators.submitButton());
		 takeScreenShot("customerDetails");
		 clickByXpath(locators.submitButton());
		 Thread.sleep(5000);
	 }
	 
	 public String getCustomerID() throws Exception {
		 takeScreenShot("customerID");
		 String customerID= getTextValue(locators.getCustomerID());
		 System.out.println("customerID is: " + customerID );
		 return customerID;
	 }
	 
	 public void addCustomerDetails(JSONObject testData) {
		 
		 EnterTextByXpath(locators.customerNamexpath(), testData.getString("customerName"));
		 EnterTextByXpath(locators.addressxpath(), testData.getString("address"));
		 EnterTextByXpath(locators.cityxpath(), testData.getString("city"));
		 EnterTextByXpath(locators.statexpath(), testData.getString("state"));
		 EnterTextByXpath(locators.pinNumberxpath(), testData.getString("pin"));
		 scrollDown();
		 EnterTextByXpath(locators.telephoneNumberxpath(), testData.getString("phoneNo"));
		 
	 }

}
