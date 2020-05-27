package solnetTests;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.TaskCheckPage;
import resources.Base;

public class MarkTaskCompleteTest extends Base{
	
	@Test(groups = { "smoke","regression" })	
	public void markTaskCompleteTest () throws InterruptedException
	{
		loginPage = new LoginPage(driver, ngDriver);
		landingPage = new LandingPage(driver, ngDriver);
		taskCheckPage = new TaskCheckPage(driver, ngDriver);
		
		loginPage.logon();
		
		landingPage.addTask( "task 1",  "task 1 Description",  "Today",  "yes");
		landingPage.addTask( "task 2",  "task 2 Description",  "Today",  "yes");
		landingPage.addTask( "task 3",  "task 3 Description",  "Today",  "yes");
		
		
		Thread.sleep(5);

		taskCheckPage.markTaskComplete("task 1");
		
	}

}
