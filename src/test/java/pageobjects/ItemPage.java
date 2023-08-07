package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends MainToolbarPage {
	@FindBy(css = "#back-to-products")
	private WebElement backBtn;
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
	private WebElement addToCartBtn;
	@FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
	private WebElement removeFromBtn;

	// Validations
	@FindBy(css = ".inventory_details_name.large_size")
	private WebElement productName;

	public ItemPage(WebDriver driver) {
		super(driver);

	}
	
	public void addToCart() {
		click(addToCartBtn);
	}
	
	public void removeFromCart() {
		click(removeFromBtn);
	}
	
	public void returnToProductsPage() {
		click(backBtn);
		
	}

	// Validations
	public String isItProductName() {
		return getText(productName);
	}

}
