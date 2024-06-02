package regression_test_cases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.google.common.io.Files;

public class baseclass {

	public WebDriver driver;
	
	

	@BeforeClass
	public void setup() throws Exception {
		String driverPath = System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
		
//		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V4/index.php");
		
		Thread.sleep(10000);
		

	}

	
	  
	 
//	@AfterClass
	public void teardown() throws Exception {
		Thread.sleep(10000);
		driver.close();
		driver.quit();
	}
}
