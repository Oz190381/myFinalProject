package pageobjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public abstract class Basepage {
	WebDriver driver;
	WebDriverWait wait;
	String mainWindow;

	public Basepage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void fillText(WebElement el, String text) {
		highlightElement(el, "blue", "orange");
		waiting(400);
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		highlightElement(el, "blue", "yellow");
		waiting(1000);
		el.click();
	}

	public void waiting(long mill) {
		try {
			Thread.sleep(mill);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public String getText(WebElement el) {
		highlightElement(el, "orange", "orange");
		waiting(300);
		return el.getText();
	}
	//Alert - Overloading
	public void alertOK(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}
	
	public void alertOK() {
		driver.switchTo().alert().accept();
	}
	
	public void alertCancel() {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void waitForElementToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
	public void waitForElementToBeVisible(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	public void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
		}
	}
	
	public void moveBackToMainWindow() {
		driver.close();
		driver.switchTo().window(mainWindow);
	}

	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 */
	protected void highlightElement(WebElement element, String color, String bgColor) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 1px solid " + color + ";background-color: " + bgColor + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

}
