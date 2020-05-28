package solnetTests;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class AddRemoveTasksTest extends Base {
	
	@Test(groups = { "addRemoveTask", "smoke","regression" })	
	public void addRemoveTasksTest() throws InterruptedException
	{
		loginPage = new LoginPage(driver, ngDriver);
		landingPage = new LandingPage(driver, ngDriver);
		loginPage.logon();
		
		landingPage.addTasks();

		landingPage.removeTask("task 2");
		
	}

}
