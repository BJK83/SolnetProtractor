package solnetTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AllTasksPage;
import pageObjects.ImportantTasksPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateImportantTasksTest extends Base{
	
	@Test(groups = { "functional", "regression" })
	public void validateImportantTasksTest() 
	{
		loginPage = new LoginPage(driver, ngDriver);
		landingPage = new LandingPage(driver, ngDriver);
		allTasksPage = new AllTasksPage(driver, ngDriver);
		importantTasksPage = new ImportantTasksPage(driver, ngDriver);

		loginPage.logon();
		landingPage.addTasks();
		importantTasksPage.navigateToImportantTasks();
		Assert.assertEquals(3, importantTasksPage.importantTasksCount());
		
	}

}
