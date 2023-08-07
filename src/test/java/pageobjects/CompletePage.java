package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends MainToolbarPage {
	@FindBy(css = "#back-to-products")
	private WebElement backHomeBtn;

	// Validations
	@FindBy(css = ".title")
	private WebElement completePageName;

	public CompletePage(WebDriver driver) {
		super(driver);

	}

	public void backHome() {
		click(backHomeBtn);
	}

	// Validations
	public String getPageName() {
		return getText(completePageName);
	}

	public boolean isItCompletePage(String name) {
		if (getText(completePageName).equalsIgnoreCase(name)) {
			return true;
		} else
			return false;

	}

}
