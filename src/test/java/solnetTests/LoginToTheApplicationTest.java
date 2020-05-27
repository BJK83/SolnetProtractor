package solnetTests;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;


public class LoginToTheApplicationTest extends Base{
	
	@Test(groups = { "smoke","regression" })	
	public void loginToTheApplication()
	{
		loginPage = new LoginPage(driver,ngDriver);
		
		loginPage.logon();
	}

}
