package pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class commonMethods {
	
 public WebDriver driver;
	
	/*******
	  CONSTRUCTOR
	 *******/

	  public commonMethods (WebDriver driver) {
	    this.driver = driver; 
  }
	 
	/*******
	  CONSTRUCTOR ENDS .........
	 *******/
	  
	  
	  public String takeScreenShot(String screenShotName) throws Exception { 
		  File sourcefile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		  File destination = new File ("./Screenshots/"+ screenShotName +".jpg");
		  Files.copy(sourcefile, destination);
		  
		  return destination.getAbsolutePath();
		  
	  }
	  
	  
	  
	  public void waitforPresence(String xpath) {
		  WebElement element = driver.findElement(By.xpath(xpath));
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  wait.until(ExpectedConditions.visibilityOf(element));
		  
	  }
	
	  public void waitForAlert() {
		  WebDriverWait waitForAlert = new WebDriverWait(driver, Duration.ofSeconds(60));
		  waitForAlert.until(ExpectedConditions.alertIsPresent());
		  System.out.println("alert found..");
		  driver.switchTo().alert().accept();
		  
	  }
	public void EnterTextByXpath (String Xpath , String value) {
		waitforPresence(Xpath);
		if(driver.findElement(By.xpath(Xpath)).isDisplayed()) {
			driver.findElement(By.xpath(Xpath)).sendKeys(value);
			System.out.println(value+": entered");
		}else {
			System.out.println("element couldn't be located");
		}
		
	}
	
	public void clickByXpath (String xpath) {
		waitforPresence(xpath);
		try {
			if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
				driver.findElement(By.xpath(xpath)).click();
			}
		}catch (Exception e) {
			System.out.println("element couldn't be clicked " + e.getMessage());
		}
	}
	
	public void validateTextByXpath (String text , String xpath) {
		try {
			waitforPresence(xpath);
			if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
				String actualText = driver.findElement(By.xpath(xpath)).getText();
				String expectedText = text;
				System.out.println("actualText displayed: " + actualText);
				System.out.println("expectedText is: " + expectedText);
				assertEquals(actualText, expectedText);
				System.out.println("actualText == expectedText");
				
			}
		}
		catch (Exception e) {
			System.out.println("Exception......");
		}
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	public void highLightText(String xpath) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.border='5px solid red'", driver.findElement(By.xpath(xpath)));
		
		//   js.executeScript("arguments[0].style.backgroundColor = 'yellow'", element);
	}
	
	public String getTextValue(String xpath) {
		highLightText(xpath);
		String textValue= driver.findElement(By.xpath(xpath)).getText();
		System.out.println("Text value is: " + textValue);
		return textValue;
	}
	
	public String generateRandomEmailAddress() {
		int PREFIX_LENGTH = 5;
		String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder emailPrefix = new StringBuilder();
        Random random = new Random();

        // Generate a random prefix for the email
        for (int i = 0; i < PREFIX_LENGTH; i++) {
            int index = random.nextInt(characters.length());
            emailPrefix.append(characters.charAt(index));
        }

        // Append the domain to the generated prefix
        String email = emailPrefix.toString() + "@mailer.com";
        return email;
	}
	
	
	
	
}
