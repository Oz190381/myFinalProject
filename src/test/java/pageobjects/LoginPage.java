package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {
	@FindBy(css = "#user-name")
	private WebElement userNameField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = "#login-button")
	private WebElement loginBtn;

	// Validations
	@FindBy(css = "[data-test='error']")
	private WebElement errorMsg;
	@FindBy(css = "#user-name")
	private WebElement userEmpty;
	@FindBy(css = "#password")
	private WebElement passwordEmpty;
	@FindBy(css = ".login_password h4")
	private WebElement passwordLine;

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public void login(String userName, String password) {
		fillText(userNameField, userName);
		fillText(passwordField, password);
		click(loginBtn);

	}

	// Validations
	public String getErrorMsg() {
		return getText(errorMsg);
	}
	
	public String getPasswordLine() {
		return getText(passwordLine);
	}

	public boolean checkUserFiledIsEmpty() {
		String userFiled = getText(userEmpty);
		if (userFiled.contains("")) {
			return true;
		} else
			return false;

	}

	public boolean checkPasswordFiledIsEmpty() {
		String passwordFiled = getText(passwordEmpty);
		if (passwordFiled.contains("")) {
			return true;
		} else
			return false;

	}

}
