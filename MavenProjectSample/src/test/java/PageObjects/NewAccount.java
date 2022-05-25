package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Hooks.ProjectConfiguration;
import Utility.BrowserActions;

public class NewAccount {
public WebDriver driver;
	
	public NewAccount(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	BrowserActions ba=new BrowserActions();
	SoftAssert softassert = new SoftAssert();
	Logger log=(Logger) LogManager.getLogger("NewAccount.java");
	public static String actNewAccountId=null;
	
	@FindBy(xpath="//a[text()='Open New Account']")
	WebElement clickOnOpenNewAccount;
	@FindBy(xpath="//select[@id='type']")
	WebElement sAccountType;
	@FindBy(xpath="//select[@id='fromAccountId']")
	WebElement fromAccountId;
	@FindBy(xpath="//input[@class='button']")
	WebElement clickNewAccountButton;
	@FindBy(xpath="//h1[@class='title']")
	WebElement getTitle;
	@FindBy(xpath="//a[@id='newAccountId']")
	WebElement getNAccounttId;
	@FindBy(xpath="//table/tbody/tr/td[text()='Account Number:']/following-sibling::td[@id='accountId']")
	WebElement vefAccountId;
	@FindBy(xpath="//table/tbody/tr/td[text()='Account Type:']/following-sibling::td[@id='accountType']")
	WebElement vefAccountType;
	@FindBy(xpath="//select[@id='month']")
	WebElement selectMonth;
	@FindBy(xpath="//select[@id='transactionType']")
	WebElement selectTransactionType;
	@FindBy(xpath="//table[@id='transactionTable']")
	WebElement selecttransactionTable;
	@FindBy(xpath="//p[@class='ng-scope']")
	WebElement transactionTableMsg;
	
	public void clickOnNewAccountlink()
	{
		ba.explicitWaitEleToBeClickable_Click(clickOnOpenNewAccount);
	}
	public void selectAccountType(String sText)
	{
	
		ba.selectByOptionText(sAccountType, sText);
		
	}
	public void selectExAccountNum(String sNum)
	{
	
		ba.selectByOptionText(fromAccountId, sNum);
		
	}
	public void clickOnNewAccButton()
	{
		ba.explicitWaitEleToBeClickable_Click(clickNewAccountButton);
	}
	public void verifyTile(String expectedTitle)
	{
		String actPageTitle=getTitle.getText();
		Assert.assertEquals(actPageTitle, expectedTitle);
		//ba.captureScreenshot(ProjectConfiguration.scenarioName);
	}
	public void getNewAccountID()
	{
	 actNewAccountId=getNAccounttId.getText();
	}
	public void clickOnNewAccountID()
	{
		
		ba.explicitWaitEleToBeClickable_Click(getNAccounttId);
	}
	public void accountIdVerify()
	{
		try {
			Thread.sleep(6000);
			String expectedActID=vefAccountId.getText();
			if(actNewAccountId.equalsIgnoreCase(expectedActID))
			{
				Assert.assertTrue(true);
				log.info("Account Id verification done");
			}else
			{
				softassert.fail("Account Id not getting matched");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void accountTypeVerify(String expectedActType)
	{
		try {
			String actActtype=vefAccountType.getText();
			if(actActtype.equalsIgnoreCase(expectedActType))
			{
				Assert.assertTrue(true);
				log.info("Account Type Verification done");
			}else
			{
				softassert.fail("Account Id not getting matched");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void selectMonths(String monthName)
	{
		ba.selectByOptionText(selectMonth, monthName);
	}
	public void selectTrasactionType(String tText)
	{
		ba.selectByOptionText(selectTransactionType, tText);
	}

	public void clickOnGoButton()
	{
		ba.explicitWaitEleToBeClickable_Click(clickNewAccountButton);
		String actTransactionTableMsg=transactionTableMsg.getText();
		log.info("Transaction table msg verified Successfully:"+actTransactionTableMsg);
	}
}
