package ro.aepsrunner;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ro.aepspageobjects.AadharPayPage;
import ro.aepspageobjects.BlanceEnquiryPage;
import ro.aepspageobjects.CashWithdrawalPage;
import ro.aepspageobjects.MiniStatementPage;
import ro.dmtpageobjects.HomePageObject;
import ro.dmtpageobjects.LoginPageObjects;

public class AepsTestRun {

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

		hp.clickOnmAEPS();

		Thread.sleep(3000);
		
	
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();

		while (it.hasNext()) {
			//System.out.println("===77777===");
			String childWindow = it.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
			
				driver.switchTo().window(childWindow);
				
				BlanceEnquiryPage balenq= new BlanceEnquiryPage(driver);
				
				balenq.BalanceEnquiryForm("8745963353","State Bank of India","671606281295");
				
				
				//CashWithdrawalPage cashWithdrawal= new CashWithdrawalPage(driver);
				//cashWithdrawal.CashwithdrawalForm("8957181611","IDBI Bank","775053481380","100");
				
//				AadharPayPage adpay= new AadharPayPage(driver);
//				adpay.AadharPayForm("8957181611","IDBI Bank","775053481380","100");
				
//				MiniStatementPage mini = new MiniStatementPage(driver);
//				mini.MiniStatementFormForm("8957181611","IDBI Bank","775053481380");
				
			}
		}
		
		

	}
}
