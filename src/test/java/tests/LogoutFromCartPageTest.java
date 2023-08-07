package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.ItemPage;
import pageobjects.LoginPage;
import pageobjects.ProductsPage;

public class LogoutFromCartPageTest extends BaseTest {

	@Test(description = "Adding item to cart")
	public void tc01_addToCartFromProductsPage() {
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCartFromProductsPage("Sauce Labs Bike Light");
	}

	@Test(description = "Open Cart")
	public void tc02_openCartPage() {
		ProductsPage pp = new ProductsPage(driver);
		pp.openCart();

		// Validations
		CartPage cp = new CartPage(driver);
		String expected = "Your Cart";
		String actual = cp.getPageName();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Logout from cart page")
	public void tc03_logOutFromCart() {
		CartPage cp = new CartPage(driver);
		cp.logOut();

		// Validations
		LoginPage lp = new LoginPage(driver);
		String expected = "Password for all users:";
		String actual = lp.getPasswordLine();
		Assert.assertEquals(actual, expected);
	}

}
