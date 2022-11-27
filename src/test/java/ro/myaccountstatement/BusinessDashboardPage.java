package ro.myaccountstatement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessDashboardPage {
	
	public BusinessDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	public WebElement clickOnMyAccount;
	
	@FindBy(xpath="//a[text()='Business Dashboard']")
	public WebElement clickOnBusiness;
	

	@FindBy(xpath = "//ul[contains(@class,'myAccount')]/li")
	public List<WebElement> dropdownList;
	
	@FindBy(xpath="//button[@id='refresh']")
	public WebElement clickOnRefreshBtn;
	
	@FindBy(xpath="//button[@id='printableTable']")
	public WebElement clickOnDownloadBtn;
	
	@FindBy(xpath = "//input[@id='print']")
	public WebElement clickOnPrintRecipiet;


	public void businessDashboard() throws InterruptedException
	{
		clickOnMyAccount.click();
		for(int i=0; i<dropdownList.size();i++)
		{
			if(dropdownList.get(i).getText().equalsIgnoreCase("Business Dashboard"))
			{
				dropdownList.get(i).click();
			}
		}
		clickOnRefreshBtn.click();
		Thread.sleep(3000);
		clickOnDownloadBtn.click();
		
		
	}
	public void printRecipiet() {
		clickOnPrintRecipiet.click();
	}

}
