package ro.rechargepageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RechargeObject {
	
	public RechargeObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='RECHARGE']")
	public WebElement clickOnRecharge;
	
	@FindBy(className="mobile_tab")
	public WebElement clickOnMob;
	
	@FindBy(xpath="//select[@id='OperatorMobile']")
	public WebElement clickOnOpertaorName;
	
	@FindBy(xpath="//input[@name='mobileNo']")
	public WebElement enterMobNum;
	
	@FindBy(xpath="//input[@name='amountMobile']")
	public WebElement enterAmt;
	
	@FindBy(xpath="//a[@id='plans']")
	public WebElement clickOnBrowsePlan;
	
	@FindBy(id="planList")
	public WebElement clickOnselectCircle;
	
	@FindBy(xpath="//a[text()='TOPUP']")
	public WebElement clickOnTopUp;
	
	@FindBy(id="currentValue0")
	public WebElement clickOnvalue;
	
	@FindBy(xpath="//button[@id='img_btn1']")
	public WebElement clickOnProceedToRechargeBtn;
	
	public void clickOnRechargeModule()
	{
		clickOnRecharge.click();
	}
	public void MobileDetails(String num, String amt) throws InterruptedException
	{
		clickOnRecharge.click();
		Select sc= new Select(clickOnOpertaorName);
		sc.selectByValue("Jio");
		enterMobNum.sendKeys(num);
		enterAmt.sendKeys(amt);
		Thread.sleep(3000);
		clickOnBrowsePlan.click();
		Thread.sleep(3000);
		Select sc1= new Select(clickOnselectCircle);
		sc1.selectByValue("21");
		Thread.sleep(5000);
		clickOnTopUp.click();
		Thread.sleep(3000);
		clickOnvalue.click();
		Thread.sleep(7000);
		//clickOnProceedToRechargeBtn.click();
	}

}
