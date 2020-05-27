package solnetTests;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class SpecificDate  extends Base{
	
	@Test
	public void spdat() throws InterruptedException
	{
		
		loginPage = new LoginPage(driver, ngDriver);
		landingPage = new LandingPage(driver, ngDriver);
		loginPage.logon();
		
		landingPage.addTask( "task 1",  "task 1 Description",  "11 jun 2020",  "yes");
		landingPage.addTask( "task 2",  "task 2 Description",  "11 jun 2020",  "yes");
		
		driver.findElement(By.xpath("//mat-datepicker-toggle")).click();

		String month = "AUG";
		int date = 20;
		String mmm="";

		boolean flag = false;
		while(!flag)
		{
			mmm = driver.findElement(By.xpath("//*[@class='mat-calendar-period-button mat-button mat-button-base']")).getText();

			ngDriver.waitForAngularRequestsToFinish();
			if(mmm.contains(month))
			{
				driver.findElement(By.xpath("(//*[@class='mat-calendar-body-cell-content'])["+--date+"]")).click();
				flag = true;
				break;

			}
			
			driver.findElement(By.xpath("//*[@class='mat-calendar-next-button mat-icon-button mat-button-base']")).click();
		}
		ngDriver.waitForAngularRequestsToFinish();
		ngDriver.waitForAngularRequestsToFinish();

		
		// $x("//*[@class='mat-calendar-period-button mat-button mat-button-base']")
		//$x("//*[@class='mat-calendar-body-cell-content']")[0]
		
		driver.findElement(By.xpath("(//*[@class='mat-calendar-body-cell-content'])[30]")).click();
		Thread.sleep(5);
	}

}
