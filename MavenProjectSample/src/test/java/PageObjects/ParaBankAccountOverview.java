package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BrowserActions;

public class ParaBankAccountOverview {
	
	WebDriver driver;
	BrowserActions ba=new BrowserActions();
	public ParaBankAccountOverview(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Log Out']")
	WebElement logOut;
	@FindBy(xpath="//a[text()='Bill Pay']")
	WebElement billPay;
	@FindBy(xpath="//a[text()='Update Contact Info']")
	WebElement updateContactInfo;
	
	
	//a[text()='Open New Account']
	public void clickLogOut()
	{
		System.out.println("Sample :"+logOut);
		if(logOut.isEnabled())
		{
			System.out.println("enabled");
		}
		logOut.click();
	}
	public void clickOnBillPayLink()
	{
		ba.click(billPay);
	}
	
	public void clickOnUpdateContactInfoLink()
	{
		ba.click(updateContactInfo);
	}

}
