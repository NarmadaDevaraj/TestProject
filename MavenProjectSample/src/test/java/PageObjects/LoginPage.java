package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='button']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id='rightPanel']/p")
	WebElement errorMsg;
	
	public void setUserName(String name)
	{
		username.click();
		username.clear();
		username.sendKeys(name);
	}
	public void setPassword(String passcode)
	{
		password.click();
		password.clear();
		password.sendKeys(passcode);
	}
	public void clickLoginButton()
	{
		loginButton.click();
		
		
	}
}
