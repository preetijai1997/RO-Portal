package ro.aepspageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MiniStatementPage {

	 public MiniStatementPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath = "//ul[@role='tablist']/a/li[text()='Mini Statement']")
		public WebElement clickonBalanceEnquiry;

		@FindBy(xpath = "//ul[contains(@class,'ui-tabs-nav')]/a")
		public List<WebElement> listOfNavMenu;

		@FindBy(xpath = "//input[@id='mobileNo']")
		public WebElement mobNum;

		@FindBy(xpath = "//select[@id='bankname']")
		public WebElement bankName;

		@FindBy(xpath = "//select[@id=\"bankname\"]/option")
		public List<WebElement> banknameList;

		@FindBy(xpath = "//input[@id='vald']")
		public WebElement aadharNum;

		@FindBy(xpath = "//select[@id='device']")
		public WebElement device;

		@FindBy(xpath = "//input[@value='Capture Fingerprint']")
		public WebElement clickOnCaptueFingerPrintbtn;

		@FindBy(xpath = "//input[@id='agreement']")
		public WebElement selectCheckBox;

		@FindBy(xpath = "//input[@value='Submit']")
		public WebElement clickOnSub;
		
		@FindBy(xpath="//p[@id='msg']")
		public WebElement getMessage;

		public void MiniStatementFormForm(String num, String BankName,String aadhar) throws InterruptedException {
			System.out.println("start");

			for (int i = 0; i < listOfNavMenu.size(); i++) {
				//System.out.println("88888888888888");
				String name = listOfNavMenu.get(i).getText();
				System.out.println(name);
				
				if(listOfNavMenu.get(i).getText().equals("Mini Statement"))
				{
					Thread.sleep(3000);
					listOfNavMenu.get(i).click();
					//clickonBalanceEnquiry.click();
				}

			}
			mobNum.sendKeys(num);
			Thread.sleep(3000);
			bankName.click();
			Thread.sleep(3000);
			for(int i=0; i<banknameList.size();i++)
			{
//				String bankName=banknameList.get(i).getText();
//				System.out.println(bankName);
				if(banknameList.get(i).getText().equals(BankName))
				{
					
					banknameList.get(i).click();
					
					
					
					//banknameList.get(i).sendKeys(Keys.ENTER);
				}
			}
			aadharNum.sendKeys(aadhar);
			
			Select sc= new Select(device);
			sc.selectByValue("Mantra MFS 100");
			clickOnCaptueFingerPrintbtn.click();
			Thread.sleep(6000);
			selectCheckBox.click();
			clickOnSub.click();
			System.out.println(getMessage.getText());
//			clickonBalanceEnquiry.click();
//			mobNum.sendKeys(num);
//			bankName.click();
//			for(int i=0; i<banknameList.size();i++)
//			{
//				String text=banknameList.get(i).getText();
//				System.out.println(text);
//			}
		}


}
