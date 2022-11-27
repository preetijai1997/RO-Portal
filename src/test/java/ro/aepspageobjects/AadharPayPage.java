package ro.aepspageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AadharPayPage {
	
	public AadharPayPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@role='tablist']/a/li[text()='Aadhaar Pay']")
	public WebElement clickOnAadharPay;
	
	@FindBy(xpath = "//ul[contains(@class,'ui-tabs-nav')]/a")
	public List<WebElement> listOfNavMenu;
	
	@FindBy(xpath="//input[@id='mobileNo']")
	public WebElement mobNo;
	
	
	@FindBy(id = "bankname")
	public WebElement bankName;

	@FindBy(xpath = "//select[@id=\"bankname\"]/option")
	public List<WebElement> banknameList;

	@FindBy(xpath = "//input[@id='vald']")
	public WebElement aadharNum;
	
	@FindBy(xpath="//input[@id='amount']")
	public WebElement amt;
	
	@FindBy(xpath = "//select[@id='device']")
	public WebElement device;

	@FindBy(xpath = "//input[@value='Capture Fingerprint']")
	public WebElement clickOnCaptueFingerPrintbtn;

	@FindBy(xpath = "//input[@id='agreement']")
	public WebElement selectCheckBox;

	@FindBy(xpath = "//input[@value='Submit']")
	public WebElement clickOnSub;

	public void AadharPayForm(String num, String BankName,String aadhar, String amount) throws InterruptedException {
		System.out.println("start");

		for (int i = 0; i < listOfNavMenu.size(); i++) {
			//System.out.println("88888888888888");
			String name = listOfNavMenu.get(i).getText();
			System.out.println(name);
			
			if(listOfNavMenu.get(i).getText().equals("Aadhaar Pay"))
			{
				Thread.sleep(3000);
				listOfNavMenu.get(i).click();
				//clickonBalanceEnquiry.click();
			}

		}
		mobNo.sendKeys(num);
		bankName.click();
		Thread.sleep(3000);
		for(int i=0; i<banknameList.size();i++)
		{
//			String bankName=banknameList.get(i).getText();
//			System.out.println(bankName);
			if(banknameList.get(i).getText().equals(BankName))
			{
				
				banknameList.get(i).click();
				
				
				
				//banknameList.get(i).sendKeys(Keys.ENTER);
			}
		}
		aadharNum.sendKeys(aadhar);
		amt.sendKeys(amount);
		
		Select sc= new Select(device);
		sc.selectByValue("Mantra MFS 100");
		clickOnCaptueFingerPrintbtn.click();
		Thread.sleep(6000);
		selectCheckBox.click();
		clickOnSub.click();
//		clickonBalanceEnquiry.click();
//		mobNum.sendKeys(num);
//		bankName.click();
//		for(int i=0; i<banknameList.size();i++)
//		{
//			String text=banknameList.get(i).getText();
//			System.out.println(text);
//		}
	}


}
