package ro.dmtpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ADDRecipientPage {

	
	public ADDRecipientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='a_benfeciary']")
	public WebElement clickonAddRecipient;
	
	@FindBy(xpath="//input[@id='mob_no']")
	public WebElement senderMobNo;
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement senderName;
	
	@FindBy(id="beneficiary_name")
    public WebElement beneName;
	
	@FindBy(id="beneficiary_mob_no")
	public WebElement beneNum;
	
	@FindBy(id="account_no")
	public WebElement accountNum;
	
	@FindBy(id="confirm_acc_no")
	public WebElement confirmAcNum;
	
	@FindBy(id="bankname")
	public WebElement bankName;
	
	@FindBy(xpath="//input[@value=\"Submit\"]")
	public WebElement clickOnSub;
	
	@FindBy(xpath="//div[contains(@class,'form-success')]")
	public WebElement successMessage;
	
	public void clickAddRp()
	{
		clickonAddRecipient.click();
	}
	
	public void checkSenderMobNo()
	{
	String actualNum=	senderMobNo.getText();
	System.out.println(actualNum);
		
		//Assert.assertEquals(actualNum, "8957181611");
	}
	
	public void checkSenderName()
	{
		String actualName=	senderMobNo.getText();
		//Assert.assertEquals(actualName, "PREETI JAISWAL");
		
	  System.out.println(actualName);
	}
	
	
	public void formDetials(String recipientname, String beneno, String acno, String confacno)
	{
		beneName.sendKeys(recipientname);
		beneNum.sendKeys(beneno);
		accountNum.sendKeys(acno);
		confirmAcNum.sendKeys(confacno);
		
		bankName.click();
		Select sc= new Select(bankName);
		sc.selectByValue("1135");
		clickOnSub.click();
		System.out.println(successMessage.getText());
		
		
	}
}
