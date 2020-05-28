package solnetTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AllTasksPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateAllTasksTest extends Base {

	@Test(groups = { "functional", "regression" })
	public void validateAllTasksTest() {
		loginPage = new LoginPage(driver, ngDriver);
		landingPage = new LandingPage(driver, ngDriver);
		allTasksPage = new AllTasksPage(driver, ngDriver);

		loginPage.logon();

		landingPage.addTasks();


		allTasksPage.navigateToAllTasks();

		// the number of tasks to assert can be data driven 
		// using JSon data input, and evaluate dynamically actual and expected
		Assert.assertEquals(4, allTasksPage.allTasksCount());

	}

}
