package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.ItemPage;
import pageobjects.LoginPage;
import pageobjects.ProductsPage;

public class RemoveFromProductsPageTest extends BaseTest {

	@Test(description = "Change item list order")
	public void tc01_itemListOrder() {
		ProductsPage pp = new ProductsPage(driver);
		pp.changeitemListOrder("za");
	}

	@Test(description = "Adding item to cart")
	public void tc02_addToCartFromProductsPage() {
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCartFromProductsPage("Sauce Labs Onesie");
	}

	@Test(description = "Change again item list order")
	public void tc03_itemListOrder() {
		ProductsPage pp = new ProductsPage(driver);
		pp.changeitemListOrder("hilo");
	}

	@Test(description = "Adding item to cart by image")
	public void tc04_addToCartByImg() {
		ProductsPage pp = new ProductsPage(driver);
		int itemsInCartBefore = pp.getNumOfItems();
		pp.addToCartByImg("Sauce Labs Fleece Jacket");

		// Validations
		int itemsInCartAfter = pp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore + 1);
	}

	@Test(dataProvider = "getData")
	public void tc05_addItemsToCartFromProductsPage(String name) {
		ProductsPage pp = new ProductsPage(driver);
		int itemsInCartBefore = pp.getNumOfItems();
		pp.addToCartFromProductsPage(name);

		// Validations
		int itemsInCartAfter = pp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore + 1);
	}

	@DataProvider
	public Object[][] getData() {
		String[][] data = { { "Sauce Labs Backpack" }, { "Sauce Labs Bike Light" }, { "Sauce Labs Bolt T-Shirt" },
				{ "Test.allTheThings() T-Shirt (Red)" } };
		return data;
	}

	@Test(description = "Remove item from products page")
	public void tc06_removeFromCart() {
		ProductsPage pp = new ProductsPage(driver);
		int itemsInCartBefore = pp.getNumOfItems();
		pp.removeFromCartFromProductsPage("Sauce Labs Bolt T-Shirt");

		// Validations
		int itemsInCartAfter = pp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore - 1);
	}

	@Test(dataProvider = "getData2")
	public void tc07_removeItemsFromCartFromProductsPage(String name) {
		ProductsPage pp = new ProductsPage(driver);
		int itemsInCartBefore = pp.getNumOfItems();
		pp.removeFromCartFromProductsPage(name);

		// Validations
		int itemsInCartAfter = pp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore - 1);
	}

	@DataProvider
	public Object[][] getData2() {
		String[][] data = { { "Sauce Labs Bike Light" }, { "Sauce Labs Backpack" },
				{ "Test.allTheThings() T-Shirt (Red)" }, };
		return data;
	}

	@Test(description = "Logout from system")
	public void tc08_logOut() {
		ProductsPage pp = new ProductsPage(driver);
		pp.openBurgerMenu();
		pp.closeBurgerMenu();
		pp.logOut();

		// Validations
		LoginPage lp = new LoginPage(driver);
		String expected = "Password for all users:";
		String actual = lp.getPasswordLine();
		Assert.assertEquals(actual, expected);
	}

}
