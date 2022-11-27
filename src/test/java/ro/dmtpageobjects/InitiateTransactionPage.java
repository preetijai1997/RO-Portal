package ro.dmtpageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InitiateTransactionPage {
	
public InitiateTransactionPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@id='customer_mobile']")
public WebElement Sender_Mob_Num;


@FindBy(xpath="//input[@id='walletbal']")
public WebElement Sender_Remaining_Limit;

@FindBy(xpath="//input[@id='recepient_mobile']")
public WebElement Recipient_Mob_num;

@FindBy(xpath="//input[@id='recipient_name']")
public WebElement Recipient_Name;

@FindBy(xpath="//input[@value='0035104000177788']")
public WebElement Recipient_Account_Num;

@FindBy(xpath="//input[@id='amount']")
public WebElement Transfer_Amount;

@FindBy(xpath="//input[@id='charge']")
public WebElement Bankit_fee;


@FindBy(xpath="//input[@id='tamt']")
public WebElement tot_amount;

@FindBy(xpath="//input[@id='remark']")
public WebElement remark;

@FindBy(xpath="//table[@class='dmrparticulars']/tbody/tr[10]//input[@checked='checked']")
public WebElement checkbox;

@FindBy(xpath="//table[@class='dmrparticulars']/tbody/tr[11]/td/input[@value='IMPS']")
public WebElement radioBtnRight;

@FindBy(xpath="//table[@class='dmrparticulars']/tbody/tr[11]/td/input[@value='NEFT']")
public WebElement radioBtnLeft;


@FindBy(xpath="//input[@id='img_btn']")
public WebElement payNow;

@FindBy(xpath="//div[contains(@class,'form-success')]")
public WebElement successText;



public void VerifyReadOnlyProp()
{
	String readonly=Sender_Mob_Num.getAttribute("readonly");
	System.out.println(readonly);
	Assert.assertNotNull(readonly);
	
	String readonly1=Sender_Remaining_Limit.getAttribute("readonly");
	System.out.println(readonly1);
	Assert.assertNotNull(readonly1);
	
	String readonly2=Recipient_Mob_num.getAttribute("readonly");
	System.out.println(readonly2);
	Assert.assertNotNull(readonly2);
	
	String readonly3=Recipient_Name.getAttribute("readonly");
	System.out.println(readonly3);
	Assert.assertNotNull(readonly3);
	
	String readonly4=Recipient_Account_Num.getAttribute("readonly");
	System.out.println(readonly4);
	Assert.assertNotNull(readonly4);
}

public void initiateTransactionForm(String amt,String fee, String rmk)
{
	//System.out.println(rightAlign.getText());
	
	Transfer_Amount.sendKeys(amt);
	Bankit_fee.sendKeys(fee);
	tot_amount.click();
	remark.sendKeys(rmk);
	checkbox.click();
	radioBtnLeft.click();
	payNow.click();	
}

public void successText()
{
	System.out.println(successText.getText());
}
}
