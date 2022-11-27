package ro.rechargepageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DATACARDPageObject {
	
	public DATACARDPageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
     
	
	@FindBy(xpath="//a[@class='data_card']")
	public WebElement clickOnDataCard;
	
	@FindBy(xpath="//select[@name='OperatorDataCrd']")
	public WebElement selectOperator;
	
	@FindBy(xpath="//input[@name='datacardno']")
	public WebElement enterAccNum;
	
    @FindBy(xpath="//input[@name='amountDataCrd']")
    public WebElement enterAmt;
    
    @FindBy(xpath="//button[@id='img_btn3']")
    public WebElement clickOnProceedToRechargeBtn;
    
    public void detailOfDtatCard(String dataCardNum, String Amt)
    {
    	clickOnDataCard.click();
    	
    	Select sc= new Select(selectOperator);
    	sc.selectByValue("Tata");
    	enterAccNum.sendKeys(dataCardNum);
    	enterAmt.sendKeys(Amt);
    	clickOnProceedToRechargeBtn.click();
    }
    
}
