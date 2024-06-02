package pages;

import org.openqa.selenium.WebDriver;

public class locators{
	
	private String userid = "//input[@name='uid']";
	private String password = "//input[@name='password']";
	private String loginbtn = "//input[@name='btnLogin']";
	
	private String welcomeToBankManagerPage = "//marquee[@class='heading3' and contains(text(),\"Welcome To Manager's Page of GTPL Bank\")]";
	private String gtplBankLogo = "//h2[contains (text(),'Gtpl Bank')]";
	private String logout="//a[contains(text(), 'Log out')]";
	
	/****
	 *add customer details...... 
	 ******/
	
	private String addCustomer="//a[contains (text(),'New Customer')]";
	private String addnewcustomertext = "//p[text()='Add New Customer']";
	private String customerName = "//input[@name='name']";
	private String customerGender_male = "//input[@name='rad1'][1]";
	private String customerGender_female = "//input[@name='rad1'][2]";
	private String dob = "//input[@id='dob']";
	private String address = "//textarea[@name='addr']";
	private String city = "//input[@name='city']";
	private String state = "//input[@name='state']";
	private String pin = "//input[@name='pinno']";
	private String telephone = "//input[@name='telephoneno']";
	private String email = "//input[@name='emailid']";
	private String submit = "//input[@value='Submit']";
	private String password_newCustomer= "//input[@name='password']";
	private String customerID = "//td[text()='Customer ID']//following-sibling::td";
	/****
	 *add customer details...... 
	 ******/
	
	/***************
	Account creation....
	 **************/
	private String newAccount = "//a[text()='New Account']";
	private String addNewAccountFormText="//p[text()='Add new account form']";
	private String enterCustomerID="//input[@name='cusid']";
	private String enterInitialDeposit="//input[@name='inideposit']";
	private String submitButton_createAccount="//input[@type='submit' and @name='button2']";
	private String accountID="//td[text()='Account ID']//following-sibling::td";
	
	
	
	
	
	
	
	public String getUseridxpath() {
		return userid;
	}
	public String getpasswordxpath() {
		return password;
	}
	public String getloginbuttonxpath() {
		return loginbtn;
	}
	public String welcomeToBankManagerPagexpath() {
		return welcomeToBankManagerPage;
	}
	public String gtplbanklogoxpath() {
		return gtplBankLogo;
	}
	public String logoutxpath() {
		return logout;
	}
	public String addCustomerxpath() {
		return addCustomer;
	}
	public String addnewCustomertextxpath() {
		return addnewcustomertext;
	}
	public String customerNamexpath() {
		return customerName;
	}
	
	public String maleGenderxpath() {
		return customerGender_male;
	}
	public String FemaleGenderxpath() {
		return customerGender_female;
	}
	public String dobxpath() {
		return dob;
	}
	public String addressxpath() {
		return address;
	}
	
	public String cityxpath() {
		return city;
	}
	public String statexpath() {
		return state;
	}
	public String pinNumberxpath() {
		return pin;
	}
	
	public String telephoneNumberxpath() {
		return telephone;
	}
	public String emailxpath() {
		return email;
	}
	public String getpasswordNewCustomerxpath() {
		return password_newCustomer;
	}
	
	public String submitButton() {
		return submit;
	}
	public String getCustomerID() {
		return customerID;
	}
	
	/******************************************************************************************
	*******************************************************************************************/
	
	
	public String getClickNewAccountXpath() {
		return newAccount;
	}
	public String getNewAccFormTextXpath() {
		return addNewAccountFormText;
	}
	
	public String getAddNewAccXpath() {
		return addNewAccountFormText;
	}
	
	public String getEnterCustomeridXpath() {
		return enterCustomerID;
	}
	public String getEnterInitialDepositXpath() {
		return enterInitialDeposit;
	}
	public String getSubmitButtonForNewAccCreationXpath() {
		return submitButton_createAccount;
	}
	public String getAccountidXpath() {
		return accountID;
	}
	
	
}
