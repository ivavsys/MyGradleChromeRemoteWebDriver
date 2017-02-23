/**
 * 
 */

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author SiddhiVinayaka
 *
 */
public class MyGoogleChromeBrowser1 {
	
	public WebDriver DoUseGoogleChromeBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "C:\\WEBDRIVERS\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			RemoteWebDriver googlechromedriver = new RemoteWebDriver(new URL("http://192.168.1.120:5555/wd/hub"), capabilities);
			return googlechromedriver;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
			
		}
	}
	

}
