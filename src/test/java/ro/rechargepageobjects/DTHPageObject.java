package ro.rechargepageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DTHPageObject {
	
	public DTHPageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='dth_tab']")
	public WebElement clickOnDTHTab;
	
	@FindBy(xpath="//select[@name='OperatorDTH']")
	public WebElement selectOperator;
	
	@FindBy(xpath="//input[@name='DTHNo']")
	public WebElement enterAccNum;
	
    @FindBy(xpath="//input[@name='amountDTH']")
    public WebElement enterAmt;
    
    @FindBy(xpath="//button[@id='img_btn2']")
    public WebElement clickOnProceedToRechargeBtn;
    
    public void DTHDetails(String acNo, String amt)
    {
    	clickOnDTHTab.click();
    	Select sc= new Select(selectOperator);
    	sc.selectByValue("DISH");
    	enterAccNum.sendKeys(acNo);
    	enterAmt.sendKeys(amt);
    	clickOnProceedToRechargeBtn.click();
    }

}
