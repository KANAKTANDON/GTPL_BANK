package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class newAccount extends commonMethods{
	locators locator = new locators();
	public newAccount(WebDriver d) {
		super(d);
	}
	
	public void clickNewAccount() throws Exception {
		clickByXpath(locator.getClickNewAccountXpath());
		System.out.println("NewAccount button clicked....");
		
	}
	
	public void validateAddNewAccFormText() {
		WebElement e = driver.findElement(By.xpath(locator.getNewAccFormTextXpath()));
		String newAccForm = e.getText();
		highLightText(locator.getNewAccFormTextXpath());
		try {
			if (newAccForm.contains("Add new account form")) {
				System.out.println("Add new account form , validation passed");
			}
		}catch (Exception E) {
			System.out.println("Add new account form , validation failed");
		}
	}
	
	public void enterCustomerID(String customerid) {
		EnterTextByXpath(locator.getEnterCustomeridXpath(), customerid);
		System.out.println("customerID value entered: " + customerid);
	}
	
	public void enterInitialDepositAmount(String depositAmount) throws Exception {
		EnterTextByXpath(locator.getEnterInitialDepositXpath(), depositAmount);
		System.out.println("customerID value entered: " + depositAmount);
		Thread.sleep(5000);
	}
	public void clickSubmitButton_newAccCreation() throws Exception {
		highLightText(locator.getSubmitButtonForNewAccCreationXpath());
		takeScreenShot("newAccountCreation");
		clickByXpath(locator.getSubmitButtonForNewAccCreationXpath());
		System.out.println("submitButton clicked for new account creation....");
		Thread.sleep(10000);
	}
	
	public String getAccountNumber() throws Exception {
		String accountID = getTextValue(locator.getAccountidXpath());
		highLightText(locator.getAccountidXpath());
		takeScreenShot("accountID");
		System.out.println("account number is: " + accountID);
		return accountID;
	}
	
	public void validateCustomerid(String customerid) {
		String actualCustomerid= getTextValue(locator.getCustomerID());
		String expectedCustomer = customerid;
		highLightText(locator.getCustomerID());
		if (actualCustomerid.equals(expectedCustomer)) {
			System.out.println("customerid validation passed....");
		}else {
			System.out.println("customerid validation failed....");
		}
	}
	
	

}
