package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class TaskCheckPage {

	public WebDriver driver;
	public NgWebDriver ngDriver;
	
	
	public TaskCheckPage(WebDriver driver, NgWebDriver ngDriver) {

		this.driver = driver;
		this.ngDriver = ngDriver;
	}
	
	
	public void markTaskComplete(String taskToMarkComplete) throws InterruptedException {
		WebElement homePage = driver.findElement(By.className("home-page"));
		List<WebElement> allTasks = homePage.findElements(By.xpath("//mat-card/mat-card-content/span"));

		String value1;
		int markIndex = 0;

		boolean taskFound = false;

		for (int i = 0; i < allTasks.size(); i++) {
			markIndex++;

			try {
				try {

					value1 = allTasks.get(i).getText();

					if (value1.equalsIgnoreCase(taskToMarkComplete)) {

						Actions action = new Actions(driver);
						WebElement e = driver.findElement(By.xpath(
								"(//*[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin'])["+markIndex+"]"));
						for(int t=0;t<2;t++)
						action.moveToElement(e).click().perform();

						taskFound = true;
						break;
					}

				} catch (Exception e) {
					System.out.println("next iteration");
				}

			} catch (Exception e) {
				System.out.println(e.toString());
			}

		}
		if (!taskFound) {
			Assert.fail("No task found for marking complete");
		}

	}
}
