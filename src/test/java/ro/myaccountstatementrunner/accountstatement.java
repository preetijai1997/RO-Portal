package ro.myaccountstatementrunner;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ro.dmtpageobjects.HomePageObject;
import ro.dmtpageobjects.LoginPageObjects;
import ro.myaccountstatement.MyAccountStatementObject;

public class accountstatement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bs0452\\Downloads\\chromedriver_win32 (11)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://portal.bankit.in:9090/RO/");
		driver.switchTo().frame("Main");

		LoginPageObjects loginPage = new LoginPageObjects(driver);

		loginPage.userName("preeti.jaiswal@bankit.in");
		loginPage.userPass("Preeti@11");

		loginPage.clickLoginbtn.click();
		Thread.sleep(5000);
		// HomePage
		HomePageObject hp = new HomePageObject(driver);

		hp.CrossBtn();

		MyAccountStatementObject myacstate = new MyAccountStatementObject(driver);
		Thread.sleep(2000);
		myacstate.myaccount();
		Thread.sleep(2000);

		myacstate.fromcalendar("Sep", "2021");
		myacstate.tocalendar("Sep", "2021");
		myacstate.SelectProduct("Settelment");
		Thread.sleep(3000);
		myacstate.getEntryData();

		myacstate.clickOnService();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();

		while (it.hasNext()) {

			String childWindow = it.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.manage().window().maximize();

			}

		}
		Thread.sleep(3000);
		myacstate.printRecipiet();

	}

}
