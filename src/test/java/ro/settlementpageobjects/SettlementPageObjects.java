package ro.settlementpageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

public class SettlementPageObjects {

	public SettlementPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@onchange='transferbank();']")
	public WebElement clickradioSettlement;

	@FindBy(xpath = "//select[@id='settlementType']")
	public WebElement element;

	@FindBy(xpath = "//input[@id='avlaiblebalance']")
	public WebElement balance;

	@FindBy(xpath = "//span[@id='select2-settlement-bank-account-container']")
	public WebElement bankacno;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	public WebElement enterText;

	@FindBy(xpath = "//span[@role='combobox']/span[@title='45678900987654-TYUI-ANGUL CENTRAL CO-OP BANK LTD']")
	public WebElement value;

	@FindBy(xpath = "//*[@id='settlement-mobile-no']")
	public WebElement contactnum;

	@FindBy(xpath = "//input[@name='bankname']")
	public WebElement bankname;

	@FindBy(xpath = "//input[@id='settlement-ifsc-code']")
	public WebElement ifscCode;

	@FindBy(xpath = "//input[@id='settlement-holder-name']")
	public WebElement acholderName;

	@FindBy(xpath = "//input[@name='charge']")
	public WebElement bankitFee;

	@FindBy(xpath = "//input[@name='amount']")
	public WebElement amt;

	@FindBy(xpath = "//select[@name='transfermode']")
	public WebElement transferMode;

	@FindBy(xpath = "//input[@id='serviceAssurance']")
	public WebElement selectCheckbox;

	@FindBy(xpath = "//input[@id='checkboxId']")
	public WebElement termandconditioncheckbox;

	@FindBy(linkText = "I hereby agree to the terms and conditions of this settlement transaction.")
	public WebElement linkTermandCondition;

	@FindBy(xpath = "//input[@value='Submit']")
	public WebElement clickOnSubBtn;

	public void settlementForm(String amount, String text) throws InterruptedException {
		clickradioSettlement.click();

		Thread.sleep(4000);

		Select sc = new Select(element);
		sc.selectByValue("AEPS & MICROATM");

		String readonly = balance.getAttribute("readonly");
		System.out.println(readonly);
		// Assert.assertNotNull(readonly);

		bankacno.click();
		Thread.sleep(2000);
		enterText.sendKeys(text);
		enterText.sendKeys(Keys.ENTER);

		// value.click();

		String readonly1 = balance.getAttribute("readonly");
		System.out.println(readonly1);
		// Assert.assertNotNull(readonly1);

		String readonly2 = balance.getAttribute("readonly");
		System.out.println(readonly2);
		// Assert.assertNotNull(readonly2);

		String readonly3 = balance.getAttribute("readonly");
		System.out.println(readonly3);
		// Assert.assertNotNull(readonly3);

		String readonly4 = balance.getAttribute("readonly");
		System.out.println(readonly4);
		// Assert.assertNotNull(readonly4);

		amt.sendKeys(amount);
		bankitFee.click();

		selectCheckbox.click();

		termandconditioncheckbox.click();
		linkTermandCondition.click();
		clickOnSubBtn.click();

	}

}
