package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.Advice.Return;

public class FacebookPage extends MainToolbarPage {
	@FindBy(css=".x1vjfegm > div > i")
	private  WebElement xMsg;
	@FindBy(css=".xzkaem6 > div.x6s0dn4.x78zum5.x1iyjqo2.x1n2onr6")
	private  WebElement pageName;
	@FindBy(css="[name='email']")
	private  WebElement emailBox;
	
	public FacebookPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void closeMsg() {
		waitForElementToBeVisible(xMsg);
		click(xMsg);
	}
	
	public void fillEmail(String email) {
		fillText(emailBox, email);
		waiting(1000);
	}
	
	public boolean isItFacebookPage(String name) {
		if (getCurrentUrl().equalsIgnoreCase(name)) {
			return true;
		} else
			return false;
	}
	
	public String getPageName() {
		return getText(pageName);
	}

}
