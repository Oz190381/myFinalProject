package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.ItemPage;
import pageobjects.ProductsPage;

public class CartTest extends BaseTest {

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
		pp.selectProductByName("Sauce Labs Bolt T-Shirt");
		ItemPage ip = new ItemPage(driver);
		ip.addToCart();
		ip.returnToProductsPage();
	}

	@Test(description = "Adding item3 to cart")
	public void tc03_addItem3() {
		ProductsPage pp = new ProductsPage(driver);
		int itemsInCartBefore = pp.getNumOfItems();
		pp.addToCartFromProductsPage("Sauce Labs Fleece Jacket");

		// Validation
		int itemsInCartAfter = pp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore + 1);
	}

	@Test(description = "Remove item from item page")
	public void tc04_removeItem() {
		ProductsPage pp = new ProductsPage(driver);
		int itemsInCartBefore = pp.getNumOfItems();
		pp.openCart();
		CartPage cp = new CartPage(driver);

		// Validation
		Assert.assertTrue(cp.isItCartPage("your cart"));

		cp.selectProductByName("Sauce Labs Fleece Jacket");
		ItemPage ip = new ItemPage(driver);
		ip.removeFromCart();
		ip.openCart();

		// Validation
		int itemsInCartAfter = cp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore - 1);
	}

	@Test(description = "Remove item from cart page")
	public void tc05_removeItem() {
		CartPage cp = new CartPage(driver);
		int itemsInCartBefore = cp.getNumOfItems();
		cp.removeItemFromCart("Sauce Labs Bolt T-Shirt");

		// Validation
		int itemsInCartAfter = cp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore - 1);
	}
	
	@Test(description = "Press continue shopping")
	public void tc06_continueShopping() {
		CartPage cp = new CartPage(driver);
		cp.continueShopping();
		ProductsPage pp = new ProductsPage(driver);
		
		//Validation
		String expected = "Products";
		String actual = pp.getPageName();
		Assert.assertEquals(actual, expected);
		
		pp.addToCartFromProductsPage("Sauce Labs Bolt T-Shirt");
		pp.openCart();
	}

	@Test(description = "Press checkout button")
	public void tc07_checkout() {
		CartPage cp = new CartPage(driver);
		cp.checkOut();
		
		// Validation
		Assert.assertTrue(cp.isItCheckoutPage("your cart page"));
	}

}
