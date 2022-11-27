package ro.dmtpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	
	public HomePageObject(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='popup']/div/div/button[@class='close']")
	public WebElement clickOnCrossBtn;
	
	
	@FindBy(linkText="SETTLEMENT")
	public WebElement clickOnSettlement;

	
	@FindBy(linkText="DMT")
	public WebElement DMT;
	
	@FindBy(linkText="AEPS")
	public WebElement AEPS;
	
	public void CrossBtn()
	{
		clickOnCrossBtn.click();
	}
	
	
	public void DMR()
	{
		DMT.click();
	}
	
	public void clickOnsettlement()
	{
		clickOnSettlement.click();
	}
	
	public void clickOnmAEPS()
	{
		AEPS.click();
	}
	

}
