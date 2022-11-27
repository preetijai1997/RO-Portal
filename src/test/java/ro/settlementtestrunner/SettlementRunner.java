package ro.settlementtestrunner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ro.dmtpageobjects.HomePageObject;
import ro.dmtpageobjects.LoginPageObjects;
import ro.settlementpageobjects.DeleteBankPageObjects;
import ro.settlementpageobjects.RegisterBankPageObjects;
import ro.settlementpageobjects.SettlementPageObjects;

public class SettlementRunner {

	 static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bs0452\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://portal.bankit.in:9090/RO/");
		driver.switchTo().frame("Main");

		LoginPageObjects loginPage = new LoginPageObjects(driver);

		loginPage.userName("amit.malu@bankit.in");
		loginPage.userPass("Amit@123");

		loginPage.clickLoginbtn.click();
		Thread.sleep(5000);
		// HomePage
		HomePageObject hp = new HomePageObject(driver);

		hp.CrossBtn();
		hp.clickOnsettlement();

		Thread.sleep(3000);

		RegisterBankPageObjects rb = new RegisterBankPageObjects(driver);
		rb.registerform("89576715255", "SitaJaiswal", "00345626637795", "00345626637795");
		Thread.sleep(3000);

		SettlementPageObjects settlement = new SettlementPageObjects(driver);

		settlement.settlementForm("3000", "SitaJaiswal");
		
		DeleteBankPageObjects db= new DeleteBankPageObjects(driver);
		Thread.sleep(4000);
		db.DeleteBankForm("SitaJaiswal");
		
		driver.switchTo().alert().accept();

	}
}
