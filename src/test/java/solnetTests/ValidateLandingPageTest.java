package solnetTests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateLandingPageTest extends Base {

	@Test(groups = { "smoke","regression" })	
	public void validateLandingPage() {
		loginPage = new LoginPage(driver, ngDriver);
		landingPage = new LandingPage(driver, ngDriver);

		loginPage.logon();

		Assert.assertEquals(driver.getTitle(), "Task Manager");

		List<WebElement> navigationListElements = landingPage.getnavigationListElements();

		Assert.assertTrue(navigationListElements.get(0).getText().contains("My day"));
		Assert.assertTrue(navigationListElements.get(0).getText().contains("wb_sunny"));
		Assert.assertTrue(navigationListElements.get(1).getText().contains("All Tasks"));
		Assert.assertTrue(navigationListElements.get(1).getText().contains("home"));
		Assert.assertTrue(navigationListElements.get(2).getText().contains("Important Tasks"));
		Assert.assertTrue(navigationListElements.get(2).getText().contains("star"));

		Assert.assertTrue(landingPage.isAddButtonEnabled());
		Assert.assertTrue(landingPage.isLogOutButtonDisplayed());

	}
}
