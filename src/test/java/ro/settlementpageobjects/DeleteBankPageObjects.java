package ro.settlementpageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DeleteBankPageObjects {
	
	public DeleteBankPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='deletebank']")
	public WebElement clickOnDeleteRadioBtn;
	
	@FindBy(xpath="//select[@id='deleteType']")
	public WebElement settlementAcType;
	
//	@FindBy(xpath="//span[@role='combobox']/span[@title='45678900987654-TYUI-ANGUL CENTRAL CO-OP BANK LTD']")
//	public WebElement bankacno;
	
	@FindBy(xpath="//input[@role='searchbox']")
	public WebElement searchboxtext;
	
	@FindBy(xpath = "//span[@id='select2-settlement-bank-account1-container']")
	public WebElement bankacno;

//	@FindBy(xpath = "//input[@class='select2-search__field']")
//	public WebElement enterText;
	
	@FindBy(xpath="//input[@value='Delete']")
	public WebElement DeleteBtn;
	
	@FindBy(xpath = "//div[contains(@class,'errormessage')]/h4")
	public WebElement message;

	
	public void DeleteBankForm(String text) throws InterruptedException
	{
		clickOnDeleteRadioBtn.click();
		Select sc= new Select(settlementAcType);
		sc.selectByValue("AEPS & MICROATM");
		
Thread.sleep(2000);
		bankacno.click();
		Thread.sleep(2000);
		searchboxtext.sendKeys(text);
		searchboxtext.sendKeys(Keys.ENTER);
		
		DeleteBtn.click();
	
		
		System.out.println(message.getText());

		
		
	}

}
