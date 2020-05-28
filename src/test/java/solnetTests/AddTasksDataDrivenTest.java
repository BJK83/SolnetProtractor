package solnetTests;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;
import utilities.dataProvider;

public class AddTasksDataDrivenTest extends Base {

	@Test(dataProvider = "createTasktestData", dataProviderClass = dataProvider.class,groups = { "dataDriven", "regression" })
	public void addRemoveTasksTest(String taskName, String taskDescription, String taskDueDate, String isImportant) {
		loginPage = new LoginPage(driver, ngDriver);
		landingPage = new LandingPage(driver, ngDriver);
		loginPage.logon();

		landingPage.addTask(taskName, taskDescription, taskDueDate, isImportant);

	}

}
