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
		

		landingPage.addTasks();
		
		taskCheckPage.markTaskComplete("task 2");
		
	}

}
