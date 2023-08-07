package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends MainToolbarPage {
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> productsNames;
	@FindBy(css = "#finish")
	private WebElement finishBtn;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;

	// Validations
	@FindBy(css = ".title")
	private WebElement overviewPageName;

	public OverviewPage(WebDriver driver) {
		super(driver);

	}

	public void hoverOnProductsByName() {
		for (WebElement el : productsNames) {
			getText(el);
//				break;
		}
	}

	public void clickFinish() {
		click(finishBtn);
		waiting(4000);
	}
	
	public void canceling() {
		click(cancelBtn);
	}

	// Validations
	public String getPageName() {
		return getText(overviewPageName);
	}

	public boolean isItOverviewPage(String name) {
		if (getText(overviewPageName).equalsIgnoreCase(name)) {
			return true;
		} else
			return false;

	}

}
