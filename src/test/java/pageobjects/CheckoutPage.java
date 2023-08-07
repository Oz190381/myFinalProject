package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends MainToolbarPage {
	@FindBy(css = "#first-name")
	private WebElement firstNameBox;
	@FindBy(css = "#last-name")
	private WebElement lastNameBox;
	@FindBy(css = "#postal-code")
	private WebElement zipCodeBox;
	@FindBy(css = "[data-test='continue']")
	private WebElement continueBtn;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;

	// Validations
	@FindBy(css = ".title")
	private WebElement checkoutPageName;
	@FindBy(css = "[data-test='error']")
	private WebElement errorPersoInfoMis;

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}

	public void fillPersonalInformations(String name, String lastName, String zipCode) {
		fillText(firstNameBox, name);
		fillText(lastNameBox, lastName);
		fillText(zipCodeBox, zipCode);
		click(continueBtn);
	}

	public void cancelCheckout() {
		click(cancelBtn);
	}

	// Validations
	public String getPageName() {
		return getText(checkoutPageName);
	}

	public boolean isItCheckoutPage(String name) {
		if (getText(checkoutPageName).equalsIgnoreCase(name)) {
			return true;
		} else
			return false;

	}

	public boolean getErrorPersoInfoIsMissing(String name) {
		String error = getText(errorPersoInfoMis);
		if (error.contains(name)) {
			return true;
		}
		return false;
	}
}
