package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.ProductsPage;

public class LoginTest extends BaseTest {

	@Test(description = "Login to the system")
	public void tc01_loginToSystem() {
		ProductsPage pp = new ProductsPage(driver);
		pp.logOut();
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		// Validations
		String expected = "Products";
		String actual = pp.getPageName();
		Assert.assertEquals(actual, expected);
	}

}
