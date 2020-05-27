package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.paulhammant.ngwebdriver.NgWebDriver;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.TaskCheckPage;


public class Base {

	public static WebDriver driver;
	public static NgWebDriver ngDriver;
	public static LoginPage loginPage;
	public static LandingPage landingPage;
	public static TaskCheckPage taskCheckPage;

	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL=(String) prop.get("url");
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\chromedriver.exe");
		driver = new ChromeDriver();

		JavascriptExecutor javaScriptDriver = (JavascriptExecutor) driver; 
		ngDriver = new NgWebDriver(javaScriptDriver);
		driver.get(URL);
		ngDriver.waitForAngularRequestsToFinish();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	@AfterMethod
	public void afterTest()
	{
		driver.close();
		driver.quit();		
	}
	
	@BeforeTest
	public void beforeTest()
	{
		// write code to start the npm server here
	}
	
	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}
}