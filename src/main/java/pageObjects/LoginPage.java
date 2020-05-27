package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class LoginPage {
	public WebDriver driver;
	public NgWebDriver ngDriver;

	By username = By.id("mat-input-0");
	By password = By.id("mat-input-1");
	ByAngularButtonText Login = ByAngular.buttonText("Login");


	public LoginPage(WebDriver driver, NgWebDriver ngDriver) {
		this.driver = driver;
		this.ngDriver = ngDriver;
	}

	public void setUserName() {
		driver.findElement(username).sendKeys("user");
		ngDriver.waitForAngularRequestsToFinish();
	}

	public void setPassword() {
		driver.findElement(password).sendKeys("user");
		ngDriver.waitForAngularRequestsToFinish();

	}

	public void setLogin() {
		driver.findElement(Login).click();
		ngDriver.waitForAngularRequestsToFinish();


	}

	public void logon() {
		setUserName();
		setPassword();
		setLogin();

	}

}
