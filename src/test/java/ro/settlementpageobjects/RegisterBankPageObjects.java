package ro.settlementpageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterBankPageObjects {
	public RegisterBankPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='registerType']/option")
	public List<WebElement> dropdownList;

	@FindBy(xpath = "//select[@id='registerType']")
	public WebElement element;

	@FindBy(xpath = "//input[@id='mobileNo']")
	public WebElement mobNo;

	@FindBy(xpath = "//input[@id='holdername']")
	public WebElement acholdername;

	@FindBy(xpath = "//input[@id='accountno']")
	public WebElement acno;

	@FindBy(xpath = "//input[@id='confirmaccountno']")
	public WebElement confacno;

	@FindBy(xpath = "//select[@id='bankname']")
	public WebElement bankName;

	@FindBy(xpath = "//button[@id='register']")
	public WebElement registerbankbtn;

	@FindBy(xpath = "//div[contains(@class,'errormessage')]/h4")
	public WebElement message;

	@FindBy(xpath = "//div[@id='chequeBlock']/div[2]")
	public WebElement ChequeBook;

	public void registerform(String mobnum, String acholder, String accountnum, String confirmaccno)
			throws InterruptedException, IOException {

		Select sc = new Select(element);
//		List<WebElement> options = sc.getOptions();
//		for (int i = 0; i < options.size(); i++) {
//			if (options.get(i).getText().equalsIgnoreCase("AEPS & MICROATM"))
//
//			{
//				options.get(i).click();
		sc.selectByValue("AEPS & MICROATM");
		mobNo.sendKeys(mobnum);
		acholdername.sendKeys(acholder);
		acno.sendKeys(accountnum);
		confacno.sendKeys(confirmaccno);

		Select bank = new Select(bankName);
		bank.selectByValue("Jammu And Kashmir Bank");

		registerbankbtn.click();
		System.out.println(message.getText());

	}
	/*
	 * if (options.get(i).getText().equalsIgnoreCase("MOVE TO BANK")) {
	 * 
	 * options.get(i).click();
	 * 
	 * mobNo.sendKeys(mobnum); acholdername.sendKeys(acholder);
	 * acno.sendKeys(accountnum); confacno.sendKeys(confirmaccno);
	 * 
	 * Select bank = new Select(bankName);
	 * bank.selectByValue("Jammu And Kashmir Bank"); ChequeBook.click();
	 * Thread.sleep(3000); Runtime.getRuntime().exec(
	 * "C:\\Users\\bs0452\\Desktop\\AutoITImage\\ImageUpload.exe");
	 * registerbankbtn.click(); System.out.println(message.getText()); }
	 */

}
