package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.Advice.Return;

public class TwitterPage extends MainToolbarPage {
	
	public TwitterPage(WebDriver driver) {
		super(driver);
		
	}
	
	public boolean isItTwitterPage(String name) {
		if (getCurrentUrl().equalsIgnoreCase(name)) {
			return true;
		} else
			return false;
	}

}
