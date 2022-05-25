package Utility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;

public class BrowserActions {
	//private static String scenarioName=null;
	WebDriver driver=DriverManager.getDriver();
	
	public void selectByOptionText(WebElement element,String text)
	{
		Select select=new Select(element);
	     select.selectByVisibleText(text);

	}
	public static void getCurrentTime()
	{
		LocalDateTime date = LocalDateTime.now();
	      System.out.println("Current Date and Time: "+date);
	}
	public void fluentWait_Click(final WebElement element)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
	WebElement fElement=wait.until(new Function<WebDriver , WebElement>(){

		public WebElement apply(WebDriver driver) {
			
			//WebElement aElement=element;
			return element;
		}
	});
			
	fElement.click();			
	}
	
	public void explicitWaitEleToBeClickable_Click(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement wElement=wait.until(ExpectedConditions.elementToBeClickable(element));
		wElement.click();
	}
	public void explicitWaitEleToBeVisible(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void explicitWaitTextTobePresent(WebElement element,String text)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void captureScreenshot(String scenarioName)
	{
		LocalDateTime date = LocalDateTime.now();
	      System.out.println("Current Date and Time: "+date);
	      String directory=System.getProperty("user.dir")+"\\ReportHistory\\Screenshots\\abc_"+scenarioName+".png";
	      //String directory="C:\\Users\\703323585\\Narmada_AutomationProject_April17\\MavenProjectSample\\ReportHistory\\Screenshots\\abc_"+scenarioName+".png";
		//ScreenshotManager.takeScreenshot(driver, System.getProperty("user.dir"+"\\ReportHistory\\Screenshots\\abc_"+date+".png"));
	      ScreenshotManager.takeScreenshot(driver,directory);
	}
	public void type(WebElement element,String text)
	{
		explicitWaitEleToBeVisible(element);
		element.clear();
		explicitWaitEleToBeClickable_Click(element);
		element.sendKeys(text);
	}
	public void click(WebElement element)
	{
		explicitWaitEleToBeVisible(element);
		explicitWaitEleToBeClickable_Click(element);
	}
	public void clearTextBox(WebElement element)
	{
		explicitWaitEleToBeVisible(element);
		element.clear();
	}
}
