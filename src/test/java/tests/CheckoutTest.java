package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.CompletePage;
import pageobjects.ItemPage;
import pageobjects.OverviewPage;
import pageobjects.ProductsPage;

public class CheckoutTest extends BaseTest {

	@Test(description = "Adding item to cart")
	public void tc01_addItem1() {
		ProductsPage pp = new ProductsPage(driver);
		pp.selectProductByName("Sauce Labs Bike Light");
		ItemPage ip = new ItemPage(driver);
		ip.addToCart();
		ip.returnToProductsPage();
	}

	@Test(description = "Adding item2 to cart")
	public void tc02_addItem2() {
		ProductsPage pp = new ProductsPage(driver);
		int itemsInCartBefore = pp.getNumOfItems();
		pp.addToCartFromProductsPage("Sauce Labs Backpack");

		// Validation
		int itemsInCartAfter = pp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore + 1);

		pp.openCart();
		CartPage cp = new CartPage(driver);
		cp.checkOut();
		CheckoutPage cop = new CheckoutPage(driver);
		// Validation
		Assert.assertTrue(cop.isItCheckoutPage("Checkout: Your Information"));
	}

	@Test(description = "Fill personal details")
	public void tc03_fillPersonalInf() {
		CheckoutPage cop = new CheckoutPage(driver);
		cop.fillPersonalInformations("Oz", "Shem Tov", "823445");
		cop.openCart();
	}

	@Test(description = "Check the canceling button")
	public void tc04_cancelCheck() {
		CartPage cp = new CartPage(driver);
		cp.checkOut();
		CheckoutPage cop = new CheckoutPage(driver);
		cop.cancelCheckout();
		// Validation
		Assert.assertTrue(cp.isItCartPage("Your Cart"));
		cp.checkOut();
	}

	@Test(description = "Finish the order")
	public void tc05_finishTheProcess() {
		CheckoutPage cop = new CheckoutPage(driver);
		cop.fillPersonalInformations("Oz", "Shem Tov", "823445");

		OverviewPage op = new OverviewPage(driver);
		// Validation
		Assert.assertTrue(op.isItOverviewPage("Checkout: Overview"));
		op.hoverOnProductsByName();
		op.clickFinish();

		// Validation
		CompletePage cp = new CompletePage(driver);
		String expected = "Checkout: Complet";
		String actual = cp.getPageName();
		Assert.assertEquals(actual, expected);
	}
}
