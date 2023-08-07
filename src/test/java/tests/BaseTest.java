package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pageobjects.LoginPage;
import pageobjects.MainToolbarPage;

import org.openqa.selenium.TakesScreenshot;

import utils.Utils;

public class BaseTest {
	WebDriver driver;

	@BeforeClass(description = "Setup")
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Utils u = new Utils();
		String url = u.getValue("url");
		driver.get(url);
	}

	@BeforeClass
	public void setupLogin() {
		LoginPage lp = new LoginPage(driver);
		Utils u = new Utils();
		String userName = u.getValue("userName");
		String password = u.getValue("password");
		lp.login(userName, password);
	}

	/*
	 * This method will run after wach test, it will take screen shot only for tests
	 * that failed
	 */
	@AfterMethod
	public void failedTest(ITestResult result) {
		// check if the test failed
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// result.getname() method will give you current test case name.
			// ./ScreenShots/ tell you that, in your current directory, create folder
			// ScreenShots. dot represents current directory
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
