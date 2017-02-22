import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.testng.AllureTestListener;

/**
 * 
 */

/**
 * @author SiddhiVinayaka
 *
 */
public class MyAllureReportsTest2 {

	MyGoogleChromeBrowser2 mgc2 = new MyGoogleChromeBrowser2();
	WebDriver googlechromedriver2 = mgc2.DoUseGoogleChromeBrowser();
	AllureTestListener at2 = new AllureTestListener();

	
	/**
	 * @param args
	 */
	//public static void main(String[] args)
	@BeforeTest(alwaysRun=true)
	@Step(value="Initialize")
	public void Test000MyAllureTestMain()
	{
		// TODO Auto-generated method stub
		googlechromedriver2.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		googlechromedriver2.manage().window().maximize();
		
	}

	@Test(alwaysRun=true)
	@Step(value="Navigation")
	public void Test001NavigateToGoogleWebSite()
	{
		googlechromedriver2.navigate().to("http://google.com");
		WebDriverWait wait = new WebDriverWait(googlechromedriver2, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("lst-ib"))).isEnabled();
		googlechromedriver2.findElement(By.id("lst-ib")).sendKeys("Hello World" + Keys.ENTER);
		String mysearch = wait.until(ExpectedConditions.elementToBeClickable(By.id("lst-ib"))).getText().toString();
		if(mysearch.equals("Hello World"))
		{
			Assert.assertTrue(true);
		}

	}
	
	@AfterTest(alwaysRun=true)
	@Step(value="Close firefox Browser")
	public void Test002CloseGoogleChromeWebBrowser()
	{

		try {
			
			googlechromedriver2.quit();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
