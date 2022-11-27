package ro.rechargepagerunner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ro.dmtpageobjects.HomePageObject;
import ro.dmtpageobjects.LoginPageObjects;
import ro.rechargepageobjects.DATACARDPageObject;
import ro.rechargepageobjects.DTHPageObject;
import ro.rechargepageobjects.RechargeObject;

public class RechargePageRunner {
	

	 static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bs0452\\Downloads\\chromedriver_win32 (11)\\chromedriver.exe");
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
		//hp.clickOnsettlement();

		Thread.sleep(3000);
		
RechargeObject ro= new RechargeObject(driver);

ro.clickOnRechargeModule();
//		ro.MobileDetails("8957181611", "29");

//		DTHPageObject dth= new DTHPageObject(driver);
//		dth.DTHDetails("78901234567", "20100");

DATACARDPageObject datacard= new DATACARDPageObject(driver);
datacard.detailOfDtatCard("87763278", "3000");
}
	
}
