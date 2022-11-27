package ro.myaccountstatementrunner;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ro.dmtpageobjects.HomePageObject;
import ro.dmtpageobjects.LoginPageObjects;
import ro.myaccountstatement.BusinessDashboardPage;

public class businessDashboardTestRunner {

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

		BusinessDashboardPage myacstate = new BusinessDashboardPage(driver);
		Thread.sleep(2000);
		myacstate.businessDashboard();
		
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
