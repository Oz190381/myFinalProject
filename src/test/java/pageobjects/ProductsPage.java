package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends MainToolbarPage {
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> productsNames;
	@FindBy(css = ".product_sort_container")
	private WebElement itemListOrder;

	// Validations
	@FindBy(css = ".title")
	private WebElement pageName;

	public ProductsPage(WebDriver driver) {
		super(driver);

	}
	
	public void changeitemListOrder(String value) {
		Select s = new Select(itemListOrder);
		s.selectByValue(value);
		
	}

	public void selectProductByName(String name) {
		for (WebElement el : productsNames) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}
	
	public void addToCartFromProductsPage(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_description"));
		for (WebElement elArea : list) {
			getText(elArea);
			WebElement elTitle = elArea.findElement(By.cssSelector(".inventory_item_name"));
			if (getText(elTitle).equalsIgnoreCase(name)) {
				WebElement addToCartBtn = elArea.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
				click(addToCartBtn);
				break;
			}
			
		}
	}
	
	public void addToCartByImg(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));
		for (WebElement elArea : list) {
			WebElement elTitle = elArea.findElement(By.cssSelector(".inventory_item_name"));
			if (getText(elTitle).equalsIgnoreCase(name)) {
				WebElement addToCartBtn = elArea.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
				click(addToCartBtn);
				break;
			}
			
		}
	}
	
	public void removeFromCartFromProductsPage(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_description"));
		for (WebElement elArea : list) {
			getText(elArea);
			WebElement elTitle = elArea.findElement(By.cssSelector(".inventory_item_name"));
			if (getText(elTitle).equalsIgnoreCase(name)) {
				WebElement removeFromCartBtn = elArea.findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
				click(removeFromCartBtn);
				break;
			}
			
		}
	}

	// Validations
	public String getPageName() {
		return getText(pageName);
	}
	
	public boolean isItProductsPage(String name) {
		if (getText(pageName).equalsIgnoreCase(name)) {
			return true;
		} else
			return false;

	}

}
