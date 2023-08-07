package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.ItemPage;
import pageobjects.LoginPage;
import pageobjects.ProductsPage;

public class BuyProductTest extends BaseTest {
	
	@Test(description = "Login to system")
	public void tc01_logIn() {
		ProductsPage pp = new ProductsPage(driver);
		// Validations
		String expected = "Products";
		String actual = pp.getPageName();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Select product by name")
	public void tc02_selectProduct() {
		ProductsPage pp = new ProductsPage(driver);
		pp.selectProductByName("Sauce Labs Backpack");
		
		// Validations
		ItemPage ip = new ItemPage(driver);
		String expected = "Sauce Labs Backpack";
		String actual = ip.isItProductName();
		Assert.assertEquals(actual, expected);
		
		ip.addToCart();
		ip.returnToProductsPage();
	}
	
	@Test(description = "Select product 2 by name")
	public void tc03_selectProduct2() {
		ProductsPage pp = new ProductsPage(driver);
		pp.selectProductByName("Sauce Labs Fleece Jacket");
		
		// Validations
		ItemPage ip = new ItemPage(driver);
		String expected = "Sauce Labs Fleece Jacket";
		String actual = ip.isItProductName();
		Assert.assertEquals(actual, expected);
		
		ip.addToCart();
		ip.returnToProductsPage();
	}
	
	@Test(description = "Remove from cart in item page")
	public void tc04_removeItemFromCart() {
		ProductsPage pp = new ProductsPage(driver);
		pp.selectProductByName("Sauce Labs Backpack");
		ItemPage ip = new ItemPage(driver);
		int itemsInCartBefore = ip.getNumOfItems();
		ip.removeFromCart();
		ip.returnToProductsPage();
		
		// Validations
		int itemsInCartAfter = pp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore - 2);
	}

}
