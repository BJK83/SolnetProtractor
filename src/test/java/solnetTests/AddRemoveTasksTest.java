package solnetTests;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class AddRemoveTasksTest extends Base {
	
	@Test(groups = { "addRemoveTask", "smoke","regression" })	
	public void addRemoveTasks() throws InterruptedException
	{
		loginPage = new LoginPage(driver, ngDriver);
		landingPage = new LandingPage(driver, ngDriver);
		loginPage.logon();
		
		landingPage.addTask( "task 1",  "task 1 Description",  "JUN-18",  "yes");
		landingPage.addTask( "task 2",  "task 2 Description",  "Today",  "yes");
		landingPage.addTask( "task 3",  "task 3 Description",  "JUN-26",  "yes");
		
		
		Thread.sleep(5);

		landingPage.removeTask("task 2");
		
	}

}
