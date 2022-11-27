package ro.tatkaalwalletrecharge;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class TatkalWalletRechargePage {
	
	//static WebDriver driver;
    public	TatkalWalletRechargePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//button[@data-toggle='dropdown']")
	public WebElement clickOnMyAccount;
    
    
	@FindBy(xpath = "//ul[contains(@class,'myAccount')]/li")
	public List<WebElement> dropdownList;
	
	@FindBy(xpath="//input[@name='PAYMENT_TYPE_ID']")
	public List<WebElement> countradiobtn;
	
	//Debit Card
	@FindBy(xpath="//input[@value='DC']")
	public WebElement radioBtnDC;
	
	@FindBy(xpath="//input[@name='amount']")
	public WebElement amt;
	
	@FindBy(xpath="//input[@name='mailId']")
	public WebElement emailId;
	
	@FindBy(xpath="//input[@name='mobileNo']")
	public WebElement agentMob;
	
	@FindBy(xpath="//input[@name='depositorName']")
	public WebElement depositerName;
	
	@FindBy(xpath="//input[@name='depositorMobile']")
	public WebElement depositernum;
	
	@FindBy(xpath="//textarea[@name='remark']")
	public WebElement remark;
	
//	@FindBy(xpath="//div[@id='consentForm']/h4/a")
//	public WebElement clickOnDownloadForm;
	
	@FindBy(xpath="//input[@id='checkboxId']")
	public WebElement selectCheckBox;
	
	@FindBy(xpath="//input[@id='img_btn']")
	public WebElement clcikOnSub;
	
	@FindBy(xpath="//table[@class='acc_deposit_table']/tbody/tr")
	public List<WebElement> detailsOfConfirmDetailPage;
	
	@FindBy(xpath="//input[@value='Submit']")
	public WebElement clickOnSubmit;
	//p[text()='Debit Card']
	//p[@class='ptm-paymode-name']
	@FindBy(xpath="//p[text()='Debit Card']")
	public WebElement DebitCardPayment;
	
	@FindBy(xpath="//input[@id='cardNumber']")
	public WebElement CardNum;
	
	@FindBy(xpath="//input[@id='cardExpirationMonth']")
	public WebElement expiryMonth;
	
	@FindBy(xpath="//input[@id='cardExpirationYear']")
	public WebElement expiryYear;
	
	@FindBy(xpath="//input[@id='cvv']")
	public WebElement enterCVV;
	
	
	@FindBy(xpath="//img[@class='ptm-lock-img']")
	public WebElement clickOnPayBtn;
	
	@FindBy(xpath="//button[@name='submitBtnname']")
	public WebElement submitOTP;
	
	@FindBy(xpath="//div[text()='Wallet credited successfully.'] ")
	public WebElement creditMsg;
	
	public void tatkalwalletrecharge()
	{
		clickOnMyAccount.click();
		for(int i=0; i<dropdownList.size();i++)
		{
			if(dropdownList.get(i).getText().equalsIgnoreCase("Tatkal Wallet Recharge"))
			{
				dropdownList.get(i).click();
			}
			
		//	System.out.println(dropdownList.get(i).getText());
		}
		
		
		 // System.out.println(countradiobtn.size());
		
	}
	
	
	//Debit Card
	public void DebitCardForm(String amount, String holderName, String mobNum, String rmk) throws InterruptedException
	{
		radioBtnDC.click();
		amt.sendKeys(amount);
		depositerName.sendKeys(holderName);
		depositernum.sendKeys(mobNum);
		remark.sendKeys(rmk);
		Thread.sleep(3000);
		//clickOnDownloadForm.click();
		Thread.sleep(3000);
		selectCheckBox.click();
		clcikOnSub.click();
	}
	
	public void printdataOfConfirmPage()
	{
		for(int i=0; i<detailsOfConfirmDetailPage.size()-1;i++)
		{
		   System.out.println(detailsOfConfirmDetailPage.get(i).getText());
		}
		clickOnSubmit.click();
	}
	
	public void methodName()
	{
	DebitCardPayment.click();
	}
	
	public void payment(String cardnum, String exmon,String exyear, String enteredCvv) throws InterruptedException
	{
		
		
		//Thread.sleep(3000);
		CardNum.sendKeys(cardnum);
		Thread.sleep(3000);
		expiryMonth.sendKeys(exmon);
		expiryYear.sendKeys(exyear);
		Thread.sleep(3000);
		
		enterCVV.sendKeys(enteredCvv);
		Thread.sleep(3000);
		
	}
	public void clickOnPayBtn()
	{
		clickOnPayBtn.click();
	}
	
	public void submit()
	{
		submitOTP.click();
	}
	
	public void successMsg()
	{
		String msg=creditMsg.getText();
		System.out.println("Success Msg is ==="+msg);
	}
	
	

}
