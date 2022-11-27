package ro.dmtpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountVerificationPage {
	
	public AccountVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="acc_info")
	public WebElement acverification;
	
	
	@FindBy(xpath="//input[@id='acc_no']")
	public WebElement acnum;
	
	@FindBy(id="bankname")
	public WebElement bankName;
	@FindBy(xpath="//input[@value='Submit']")
	public WebElement clickonSub;
	
	public void acverification()
	{
		acverification.click();
	}
	
	public void acverificationform(String acnumber)
	{
	    acnum.sendKeys(acnumber);
		bankName.click();
		Select sc= new Select(bankName);
		sc.selectByValue("1166");
		clickonSub.click();
	}

}
