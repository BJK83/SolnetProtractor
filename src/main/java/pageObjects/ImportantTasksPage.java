package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class ImportantTasksPage {

	public WebDriver driver;
	public NgWebDriver ngDriver;

	By importantTasks = By.xpath("(//app-nav-menu-item)[3]");
	By importantTask = By.xpath("//mat-card");

	public ImportantTasksPage(WebDriver driver, NgWebDriver ngDriver) {

		this.driver = driver;
		this.ngDriver = ngDriver;
	}

	public void navigateToImportantTasks() {

		driver.findElement(importantTasks).click();
		ngDriver.waitForAngularRequestsToFinish();
			
		}
	
	public int importantTasksCount()
	{
		return driver.findElements(importantTask).size();
		
	}

}
