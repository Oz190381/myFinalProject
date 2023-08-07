package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.ItemPage;
import pageobjects.LoginPage;
import pageobjects.ProductsPage;

public class BuyFromProductsPageTest extends BaseTest {

	@Test(description = "Login to system")
	public void tc01_logIn() {
		ProductsPage pp = new ProductsPage(driver);
		// Validations
		String expected = "Products";
		String actual = pp.getPageName();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Adding item to cart")
	public void tc02_addToCartFromProductsPage() {
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCartFromProductsPage("Test.allTheThings() T-Shirt (Red)");
		pp.openCart();
		CartPage cp = new CartPage(driver);

		// Validations
		String expected = "Your Cart";
		String actual = cp.getPageName();
		Assert.assertEquals(actual, expected);

		cp.backToProductsPage();
	}

	@Test(description = "Adding item num 2 to cart")
	public void tc03_addToCartFromProductsPage() {
		ProductsPage pp = new ProductsPage(driver);
		int itemsInCartBefore = pp.getNumOfItems();
		pp.addToCartFromProductsPage("Sauce Labs Bolt T-Shirt");
		pp.openCart();
		CartPage cp = new CartPage(driver);

		// Validations
		int itemsInCartAfter = cp.getNumOfItems();
		Assert.assertEquals(itemsInCartAfter, itemsInCartBefore + 1);
		
		cp.backToProductsPage();
	}
	
	@Test(description = "Logout from system")
	public void tc04_logOut() {
		ProductsPage pp = new ProductsPage(driver);
		pp.openBurgerMenu();
		pp.closeBurgerMenu();
		pp.logOut();
		
		// Validations
		LoginPage lp = new LoginPage(driver);
		String expected = "Password for all:";
		String actual = lp.getPasswordLine();
		Assert.assertEquals(actual, expected);
	}

}
