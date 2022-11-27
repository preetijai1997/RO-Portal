
package ro.dmtpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="Main")
	public WebElement Frame;
	
	
	@FindBy(xpath="//input[@name='userName']")
	public WebElement userName;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="login")
	public WebElement clickLoginbtn;
	
	@FindBy(name="varifyMobileCode")
	public WebElement enterOTP;
	
	public void userName(String name)
	{
		userName.sendKeys(name);
	}
	
	public void userPass(String Pass)
	{
		password.sendKeys(Pass);
	}
	
	public void clickLoginBtn()
	{
		clickLoginbtn.click();
	}
	
	public void enterOTP() throws InterruptedException
	{
		Thread.sleep(7000);
		enterOTP.click();
	}
	
	
	
	
	/*
	@FindBy(xpath="//span[text()='Login']")
	public WebElement clickOnLogin;
	
	@FindBy(xpath="//input[@class='style__input___3NmkT']")
	public WebElement enterPhoneNum;
	
	@FindBy(xpath="//span[text()='LOGIN']")
	public WebElement clickOnLoginbtn;
	
	
	
	@FindBy(xpath="//*[@id=\"body-container\"]/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[1]/a")
	public WebElement clickOnDoneBtn;
	
	public void loginDetails(String num) throws InterruptedException
	{
		Thread.sleep(3000);
		clickOnLogin.click();
		enterPhoneNum.sendKeys(num);
		Thread.sleep(2000);
		clickOnLoginbtn.click();
		Thread.sleep(4000);
		enterOTP.click();
		Thread.sleep(27000);
		clickOnDoneBtn.click();
	}
	*/
	

}
