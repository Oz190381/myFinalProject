package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.FacebookPage;
import pageobjects.ProductsPage;
import pageobjects.TwitterPage;

public class LinkValidationTest extends BaseTest {

	@Test(description = "Press twitter btn")
	public void tc01_checkTwitter() {
		ProductsPage pp = new ProductsPage(driver);
		pp.openTwitter();

		TwitterPage tp = new TwitterPage(driver);

		Assert.assertTrue(tp.isItTwitterPage("https://twitter.com/saucelabs"));

		pp.moveBackToMainWindow();
	}

	@Test(description = "Press facebook btn")
	public void tc02_checkFacebook() {
		ProductsPage pp = new ProductsPage(driver);
		pp.openFacebook();

		FacebookPage fp = new FacebookPage(driver);
		Assert.assertTrue(fp.isItFacebookPage("https://www.facebook.com/saucelabs"));

		fp.closeMsg();
		fp.fillEmail("oz@gmail.com");

		pp.moveBackToMainWindow();

	}

}
