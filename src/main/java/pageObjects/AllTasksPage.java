package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class AllTasksPage {

	public WebDriver driver;
	public NgWebDriver ngDriver;
	By navigationListElements = By.xpath("//app-nav-menu-item");
	By allTasks = By.xpath("(//app-nav-menu-item)[2]");
	By allTasksCount = By.xpath("//mat-card-content/mat-icon");
	By importantTasksCount = By.xpath("");

	public AllTasksPage(WebDriver driver, NgWebDriver ngDriver) {

		this.driver = driver;
		this.ngDriver = ngDriver;
	}
	
	public void validateAllTasks()
	{
		
	}
	
	public void navigateToAllTasks()
	{
		driver.findElement(allTasks).click();
		ngDriver.waitForAngularRequestsToFinish();
	}
	
	public int allTasksCount()
	{
		return driver.findElements(allTasksCount).size();
	}
	
	public int importantTasksCount()
	{
		return driver.findElements(importantTasksCount).size();
	}

}