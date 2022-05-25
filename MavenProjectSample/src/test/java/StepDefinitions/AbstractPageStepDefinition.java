package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

public class AbstractPageStepDefinition {

	protected static WebDriver driver;
	
	
	protected WebDriver getDriver()
	{
		if(driver==null)
		{
			driver=new ChromeDriver();
			//launchBrowser();
		}
		return driver;
		
	}
//	public void beforeScenario()
//	{
//		try {
//			if(driver== null)
//			{
//			launchBrowser();
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	public void launchBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
	}
	
}
