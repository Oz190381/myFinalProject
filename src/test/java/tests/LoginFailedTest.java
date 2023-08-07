package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.ProductsPage;

public class LoginFailedTest extends BaseTest {

	@Test(description = "Login with wrong username")
	public void tc01_loginFailedUsername() {
		ProductsPage pp = new ProductsPage(driver);
		pp.logOut();
		LoginPage lp = new LoginPage(driver);
		lp.login("ozs", "secret_sauce");
		// Validations
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(description = "Login with wrong password")
	public void tc02_loginFailedPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "12345");
		// Validations
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(description = "Login with wrong password and Wrong username")
	public void tc03_loginFailedPassAndUser() {
		LoginPage lp = new LoginPage(driver);
		lp.login("ozs", "12345");
		// Validations
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(description = "Login without password and username")
	public void tc04_loginFailedNoPassAndUser() {
		LoginPage lp = new LoginPage(driver);
		lp.login("", "");
		// Validations
		Assert.assertTrue(lp.checkUserFiledIsEmpty());
		Assert.assertTrue(lp.checkPasswordFiledIsEmpty());
	}

}
