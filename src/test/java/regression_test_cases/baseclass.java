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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class baseclass {

	public WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	
	
	

	@BeforeClass
	public void setup() throws Exception {
		String driverPath = System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
		String reportPath = System.getProperty("user.dir") + "/reports/report.html";
		
//		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		/***
		 below code is for extentReports
		 ***/
		reports = new ExtentReports(reportPath);
//		test = reports.startTest("bankExtentReport");
		
		driver.get("https://demo.guru99.com/V4/index.php");
		
		Thread.sleep(10000);
		

	}
	
	public String takeScreenShot(String screenShotName) throws Exception { File
		  sourcefile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); File
		 destination = new File ("./Screenshots/"+ screenShotName +".jpg");
		 Files.copy(sourcefile, destination);
		  
		  return destination.getAbsolutePath();
	}
	
//	public void logInfo(String info , String screenshotName) throws Exception {
//		test.log(LogStatus.PASS,info,test.addScreenCapture(takeScreenShot(screenshotName)));
//	}
	
	public void logInfo(ExtentTest test, String info, String screenshotName) throws Exception {
        test.log(LogStatus.PASS, info, test.addScreenCapture(takeScreenShot(screenshotName)));
    }

	
	  
	 
	@AfterClass
	public void teardown() throws Exception {
		System.out.println("teardown begins .......");
		System.out.println("\n");
		reports.endTest(test);
		reports.flush();
		reports.close();
		Thread.sleep(10000);
		driver.close();
		driver.quit();
	}
}
