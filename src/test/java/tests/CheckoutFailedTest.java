package tests;

import java.security.PublicKey;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.CompletePage;
import pageobjects.ItemPage;
import pageobjects.OverviewPage;
import pageobjects.ProductsPage;

public class CheckoutFailedTest extends BaseTest {

	@Test(description = "Adding item to cart")
	public void tc01_addItem() {
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCartFromProductsPage("Sauce Labs Backpack");
		int itemsInCartBefore = pp.getNumOfItems();
		pp.addToCartFromProductsPage("Sauce Labs Bike Light");

		// Validation
		int itemsInCartAfter = pp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore + 1);

		pp.openCart();
	}

	@Test(description = "Open cart page")
	public void tc02_openCart() {
		CartPage cp = new CartPage(driver);
		cp.checkOut();
		CheckoutPage cop = new CheckoutPage(driver);
		// Validation
		Assert.assertTrue(cop.isItCheckoutPage("Checkout: Your Information"));
	}

	@Test(dataProvider = "getData")
	public void tc03_fillWithMissInfo(String name, String lastName, String zipCode) {
		CheckoutPage cop = new CheckoutPage(driver);
		cop.fillPersonalInformations(name, lastName, zipCode);

		// Validation
		Assert.assertTrue(cop.getErrorPersoInfoIsMissing("Error"));
	}

	@DataProvider
	public Object[][] getData() {
		String[][] data = { { "Oz", "Shem Tov", "" }, { "Oz", "", "" }, { "", "Shem Tov", "" }};
		return data;
	}

}
