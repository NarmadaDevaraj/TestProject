package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static DriverManager driverManager;
	public static WebDriver driver;
	
	public DriverManager()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("Chrome driver ="+driver);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver()
	{
		return DriverManager.driver;
		
	}
	
	public static void setupDriver()
	{
		if(driverManager==null)
		{
			driverManager=new DriverManager();
		}
	}
	
	public static void tearDown()
	{
		driverManager=null;
		driver.quit();
	}
}
