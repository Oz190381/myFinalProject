package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MainToolbarPage extends Basepage {
	@FindBy(css = "#react-burger-menu-btn")
	private WebElement burgerMenuBtn;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logoutBtn;
	@FindBy(css = ".bm-item-list a:nth-child(1)")
	private WebElement allItemsBtn;
	@FindBy(css = ".shopping_cart_link")
	private WebElement cartBtn;
	@FindBy(css = "#react-burger-cross-btn")
	private WebElement xMenuBtn;
	@FindBy(css = ".social_facebook>a")
	private WebElement faceBookBtn;
	@FindBy(css = ".social_twitter>a")
	private WebElement twitterBtn;
	@FindBy(css = ".social_linkedin>a")
	private WebElement linkedinBtn;
	
	// Validations
	@FindBy(css = ".shopping_cart_badge")
	private WebElement numOfItems;
	

	public MainToolbarPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void openBurgerMenu() {
		click(burgerMenuBtn);
	}
	
	public void closeBurgerMenu() {
		waitForElementToBeClickable(xMenuBtn);
		click(xMenuBtn);
	}

	public void logOut() {
		(burgerMenuBtn).click();
		waitForElementToBeClickable(logoutBtn);
		(logoutBtn).click();
	}
	
	public void backToProductsPage() {
		(burgerMenuBtn).click();
		waitForElementToBeClickable(allItemsBtn);
		(allItemsBtn).click();
	}

	public void openCart() {
		click(cartBtn);
	}
	
	public void openFacebook() {
		click(faceBookBtn);
		moveToNewWindow();
	}
	
	public void openTwitter() {
		click(twitterBtn);
		moveToNewWindow();
	}
	
	public void openLinkedin() {
		click(linkedinBtn);
		moveToNewWindow();
	}
	
	// Validations
	public int getNumOfItems() {
		String s = getText(numOfItems);
		int i = Integer.parseInt(s);
		return i;
	}

}
