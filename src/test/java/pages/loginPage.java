package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import regression_test_cases.*;



public class loginPage extends commonMethods{
	
	
	 WebDriver driver;
	locators locator = new locators();
	

	
	/*******
	 * CONSTRUCTOR
	 *******/
	
	public loginPage (WebDriver d) {
		super(d);	
//		driver=d;
		
	}
	
	/*******
	 * CONSTRUCTOR ENDS .........
	 *  
	 * 
	 *******/
	public void enterUserID_and_password(String userid, String password) throws Exception {
		
		EnterTextByXpath(locator.getUseridxpath() , userid);
		EnterTextByXpath(locator.getpasswordxpath() , password);
//		System.out.println("userID entered: " + userid);
//		System.out.println("password entered: " + password);
		//takeScreenShot("userID_password");
		
	}
	
	public void clickLoginButton() throws Exception {
		waitforPresence(locator.getloginbuttonxpath());
		clickByXpath(locator.getloginbuttonxpath());
		System.out.println("LoginButton Clicked.....");
		//takeScreenShot("loginButton");
	}
	
	public void validateGTPLBANKlogo() {
		validateTextByXpath(locator.gtplbanklogoxpath(), "Gtpl Bank");
		validateTextByXpath(locator.welcomeToBankManagerPagexpath(), "Welcome To Manager's Page of GTPL Bank");
	}
	
	public void clickLogoutButton() throws Exception {
		clickByXpath(locator.logoutxpath());
		System.out.println("Logout button clicked....");
		Thread.sleep(5000);
		waitForAlert();
		
	}
	
	
	
	
	
	
}
