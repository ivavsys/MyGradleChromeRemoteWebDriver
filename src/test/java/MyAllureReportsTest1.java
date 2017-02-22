/**
 * 
 */

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.testng.AllureTestListener;

/**
 * @author SiddhiVinayaka
 *
 */
public class MyAllureReportsTest1
{
	MyGoogleChromeBrowser1 mgc1 = new MyGoogleChromeBrowser1();
	WebDriver googlechromedriver1 = mgc1.DoUseGoogleChromeBrowser();
	AllureTestListener at1 = new AllureTestListener();

	
	/**
	 * @param args
	 */
	//public static void main(String[] args)
	@BeforeTest(alwaysRun=true)
	@Step(value="Initialize")
	public void Test000MyAllureTestMain()
	{
		// TODO Auto-generated method stub
		googlechromedriver1.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		googlechromedriver1.manage().window().maximize();
		
	}

	@Test(alwaysRun=true)
	@Step(value="Navigation")
	public void Test001NavigateToGoogleWebSite()
	{
		googlechromedriver1.navigate().to("http://google.com");
		WebDriverWait wait = new WebDriverWait(googlechromedriver1, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("lst-ib"))).isEnabled();
		googlechromedriver1.findElement(By.id("lst-ib")).sendKeys("Hello World" + Keys.ENTER);
		String mysearch = wait.until(ExpectedConditions.elementToBeClickable(By.id("lst-ib"))).getText().toString();
		if(mysearch.equals("Hello World"))
		{
			AssertJUnit.assertTrue(true);
		}
	}
	
	@AfterTest(alwaysRun=true)
	@Step(value="Close Google Browser")
	public void Test002CloseGoogleChromeWebBrowser()
	{
		googlechromedriver1.quit();
		
	}
	

	
}
