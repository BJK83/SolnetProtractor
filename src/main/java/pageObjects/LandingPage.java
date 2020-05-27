package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class LandingPage {
	public WebDriver driver;
	public NgWebDriver ngDriver;

	By navigationListElements = By.xpath("//app-nav-menu-item");
	ByAngularButtonText Add = ByAngular.buttonText("Add");
	ByAngularButtonText logout = ByAngular.buttonText("logout");
	By taskTitle = By.xpath("//input[@ng-reflect-name='taskTitle']");
	By taskDescription = By.cssSelector("input[name='taskDesc']");
	By datePicker = By.xpath("//mat-datepicker-toggle");
	By isTaskImportant = By.xpath("//input[@id='mat-checkbox-1-input']");
	By deleteTask = By.xpath("//mat-icon[@class='remove-icon mat-icon notranslate material-icons mat-icon-no-color']");

	public LandingPage(WebDriver driver, NgWebDriver ngDriver) {

		this.driver = driver;
		this.ngDriver = ngDriver;
	}

	public void validateLandingPage() {

		List<WebElement> allFields = driver.findElements(By.xpath("//app-nav-menu-item"));
		String x = allFields.get(0).getText();

	}

	public List<WebElement> getnavigationListElements() {
		return driver.findElements(navigationListElements);
	}

	public boolean isAddButtonEnabled() {
		if (driver.findElement(Add).isEnabled()) {
			return true;

		}
		return false;
	}

	public boolean isLogOutButtonDisplayed() {
		if (driver.findElement(logout).isDisplayed()) {
			return true;

		}
		return false;
	}

	public void addTask(String taskName, String Description, String taskDueDate, String isImportant) {
		driver.findElement(taskTitle).sendKeys(taskName);
		ngDriver.waitForAngularRequestsToFinish();

		driver.findElement(taskDescription).sendKeys(Description);
		ngDriver.waitForAngularRequestsToFinish();

		if (!taskDueDate.equalsIgnoreCase("Today")) {

			selectDate(taskDueDate);
		}

		if (isImportant.equalsIgnoreCase("Yes")) {
			isImportantCheck();
			ngDriver.waitForAngularRequestsToFinish();

		}
		driver.findElement(Add).click();
		ngDriver.waitForAngularRequestsToFinish();

	}

	public void setTaskDescription(String description) {
		driver.findElement(taskDescription).sendKeys(description);
	}

	public void setDate() {
		driver.findElement(datePicker).click();

	}

	public void isImportantCheck() {
		Actions action = new Actions(driver);

		WebElement element = driver.findElement(isTaskImportant);
		action.moveToElement(element).click().perform();
	}

	public void removeTask(String taskToDelete) throws InterruptedException {
		WebElement homePage = driver.findElement(By.className("home-page"));
		List<WebElement> allTasks = homePage.findElements(By.xpath("//mat-card/mat-card-content/span"));

		String value1;
		int deleteIndex = 0;

		boolean taskFound = false;

		for (int i = 0; i < allTasks.size(); i++) {
			deleteIndex++;

			try {
				try {

					value1 = allTasks.get(i).getText();

					if (value1.equalsIgnoreCase(taskToDelete)) {

						Actions action = new Actions(driver);
						WebElement e = driver.findElement(By.xpath(
								"(//mat-icon[@class='remove-icon mat-icon notranslate material-icons mat-icon-no-color'])["+deleteIndex+"]"));
						action.moveToElement(e).click().perform();

						taskFound = true;
						break;
					}

				} catch (Exception e) {
					System.out.println("next iteration");
//					deleteIndex++;
				}

			} catch (Exception e) {
				System.out.println(e.toString());
			}

		}
		if (!taskFound) {
			Assert.fail("No task found for deleting");
		}

	}

	public void deleteAllTasks() throws InterruptedException {
		WebElement homePage = driver.findElement(By.className("home-page"));
		List<WebElement> allTasks = homePage.findElements(By.xpath("//mat-card/mat-card-content"));
		int size = allTasks.size();

		for (int x = 0; x < size; x++) {
			System.out.println(allTasks.get(x).getText());
			allTasks.get(x)
					.findElement(By.xpath(
							"//mat-icon[@class='remove-icon mat-icon notranslate material-icons mat-icon-no-color']"))
					.click();
			ngDriver.waitForAngularRequestsToFinish();

			Thread.sleep(2);
		}

		for (WebElement task : allTasks) {
			task.findElement(
					By.xpath("//mat-icon[@class='remove-icon mat-icon notranslate material-icons mat-icon-no-color']"))
					.click();
		}
	}
	
	public void selectDate(String date)
	{
		String[] splitDate  = date.split("-");
		String month = splitDate[0];
		String day = splitDate[1];
		
				
		
		driver.findElement(By.xpath("//mat-datepicker-toggle")).click();
		
		String displayedDate="";

		boolean flag = false;
		while(!flag)
		{
			displayedDate = driver.findElement(By.xpath("//*[@class='mat-calendar-period-button mat-button mat-button-base']")).getText();

			ngDriver.waitForAngularRequestsToFinish();
			if(displayedDate.contains(month))
			{
				driver.findElement(By.xpath("(//*[@class='mat-calendar-body-cell-content'])["+day+"]")).click();
				flag = true;
				break;

			}
			
			driver.findElement(By.xpath("//*[@class='mat-calendar-next-button mat-icon-button mat-button-base']")).click();
		}
	}

}
