package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends MainToolbarPage {
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> productsNames;
	@FindBy(css = ".cart_item_label")
	private List<WebElement> list;
	@FindBy(css = "#checkout")
	private WebElement checkoutBtn;
	@FindBy(css = "#continue-shopping")
	private WebElement continueShoppingBtn;

	// Validations
	@FindBy(css = ".title")
	private WebElement pageName;
	@FindBy(css = ".title")
	private WebElement checkoutPageName;

	public CartPage(WebDriver driver) {
		super(driver);

	}

	public void selectProductByName(String name) {
		for (WebElement el : productsNames) {
			getText(el);
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}

	public void removeItemFromCart(String name) {
		for (WebElement elArea : list) {
			getText(elArea);
			WebElement elTitle = elArea.findElement(By.cssSelector(".inventory_item_name"));
			if (elTitle.getText().equalsIgnoreCase(name)) {
				WebElement removeBtn = elArea.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
				click(removeBtn);
				break;
			}
		}
	}
	
	public void continueShopping() {
		click(continueShoppingBtn);
	}

	public void checkOut() {
		click(checkoutBtn);
	}

	// Validations
	public String getPageName() {
		return getText(pageName);
	}

	public boolean isItCartPage(String name) {
		if (getText(pageName).equalsIgnoreCase(name)) {
			return true;
		} else
			return false;

	}
	
	public boolean isItCheckoutPage(String name) {
		if (getText(checkoutPageName).equalsIgnoreCase(name)) {
			return true;
		} else
			return false;

	}

}
