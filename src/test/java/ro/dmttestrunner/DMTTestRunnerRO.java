package ro.dmttestrunner;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ro.dmtpageobjects.ADDRecipientPage;
import ro.dmtpageobjects.AccountVerificationPage;
import ro.dmtpageobjects.DMTPageObject;
import ro.dmtpageobjects.HomePageObject;
import ro.dmtpageobjects.ImportRecipient;
import ro.dmtpageobjects.InitiateTransactionPage;
import ro.dmtpageobjects.LoginPageObjects;

public class DMTTestRunnerRO {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bs0452\\Downloads\\chromedriver_win32 (11)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://portal.bankit.in:9090/RO/");
//		  Dimension d = new Dimension(300,1080);
//		  driver.manage().window().setSize(d);
		driver.switchTo().frame("Main");

		// LoginPage
		LoginPageObjects loginPage = new LoginPageObjects(driver);

		loginPage.userName("preeti.jaiswal@bankit.in");
		loginPage.userPass("Preeti@11");

		loginPage.clickLoginbtn.click();
		loginPage.enterOTP();
		loginPage.clickLoginbtn.click();
		// loginPage.enterOTP.sendKeys("111111");

		// loginPage.clickLoginbtn.click();

		Thread.sleep(5000);
		// HomePage
		HomePageObject hp = new HomePageObject(driver);

		hp.CrossBtn();

		Thread.sleep(3000);
		hp.DMR();

		DMTPageObject dmtpage = new DMTPageObject(driver);
		dmtpage.DMR();

		dmtpage.getListOfDMT();
		dmtpage.clickOnAremit();
		dmtpage.senderMobNo("9616144812");
		dmtpage.submit();
		Thread.sleep(6000);
		dmtpage.tableValue();

		dmtpage.getRepientText();

		dmtpage.clickONPayNowBtn();

		// initiatepage
		InitiateTransactionPage it = new InitiateTransactionPage(driver);
		// it.VerifyReadOnlyProp();
		it.initiateTransactionForm("3000", "2", "Testing");
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(4000);
		it.successText();
		

		/*
		 * //AddRecipient ADDRecipientPage adrecp= new ADDRecipientPage(driver);
		 * Thread.sleep(4000); adrecp.clickAddRp(); adrecp.checkSenderMobNo();
		 * adrecp.checkSenderName(); adrecp.formDetials("Preeto", "6718324156",
		 * "003415626717708", "003415626717708");
		 * 
		 * 
		 * //AccountVerification Thread.sleep(3000); AccountVerificationPage av= new
		 * AccountVerificationPage(driver); av.acverification();
		 * av.acverificationform("0035104000177788");
		 * 
		 * 
		 * 
		 * //importRecipient ImportRecipient imp= new ImportRecipient(driver);
		 * 
		 * imp.clickOnImport(); Thread.sleep(2000);
		 * 
		 * imp.formImportFrom("9616144812"); imp.getRecipientName(); // imp.ImportTo();
		 * // imp.selectedCheckbox(); imp.selectbox("8089315998");
		 * dmtpage.senderMobNo("8089315998"); dmtpage.submit();
		 * 
		 */
	}

}
