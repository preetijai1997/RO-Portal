package ro.tatkalwalletrechargerunner;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ro.dmtpageobjects.HomePageObject;
import ro.dmtpageobjects.LoginPageObjects;
import ro.tatkaalwalletrecharge.TatkalWalletRechargePage;

public class TatkalWalletRechargeRunner {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bs0452\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
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

		TatkalWalletRechargePage tr = new TatkalWalletRechargePage(driver);
		tr.tatkalwalletrecharge();
		tr.DebitCardForm("101", "Preeti Jaiswal", "8957181611", "Testing");
		Thread.sleep(2000);
		tr.printdataOfConfirmPage();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='Main']")));
		Thread.sleep(5000);
		tr.methodName();
		System.out.println("==============");
		Thread.sleep(3000);
		// driver.switchTo().defaultContent();
//		driver.switchTo().frame("Main");
//		
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> it = windows.iterator();
//		String parentWindow = it.next();
//		System.out.println(parentWindow+"======P============"+it);
//		
		// Thread.sleep(5000);
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ptm-card-iframe']")));
		// driver.switchTo().defaultContent();
		Thread.sleep(5000);

		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		int numberOfTags = elements.size();
		System.out.println(numberOfTags + ".................");

		driver.switchTo().frame(0);
		tr.payment("6522623006925353", "01", "23", "161");

		Thread.sleep(5000);
		System.out.println("99999999999999999");
		driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
		System.out.println("000000000000000000");
		Thread.sleep(5000);
		tr.clickOnPayBtn();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		while (it.hasNext()) {
			System.out.println("=========");
			String childWindow = it.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				System.out.println("cccccccccccccccppppppppppp");
				driver.switchTo().window(childWindow);
				Thread.sleep(20000);
				tr.submit();
				
//				while (it.hasNext()) {
//					System.out.println("=========");
//					String childWindow1 = it.next();
//					if (!childWindow.equalsIgnoreCase(childWindow1)) {
//						System.out.println("ccccccccccccccczzzzzzz");
//						driver.switchTo().window(childWindow1);
//						System.out.println("ccccccccccccccc11111111111111");
//						Thread.sleep(5000);
					
						
				//driver.switchTo().window(childWindow);
//				String child1=it.next();
//				if (!childWindow.equalsIgnoreCase(child1)) {
//					System.out.println("ccccccccccccccc1");
//					driver.switchTo().window(child1);
//					Thread.sleep(6000);
//					//driver.switchTo().window(childWindow);
//					tr.submit();
//				}
				//tr.submit();
			}
				}
		tr.successMsg();
			

		// for(int i=0; i<elements.size();i++)
//		{
//		WebElement text=elements.get(i);
//		System.out.println("elments tags "+text);
//		
//		}
//		Thread.sleep(3000);
//		String childWindow = it.next();
//		System.out.println(childWindow);
//
//		while (it.hasNext()) {
//			System.out.println("=========");
//			String childWindow = it.next();
//			if (!parentWindow.equalsIgnoreCase(childWindow)) {
//				System.out.println("00000000000000");
//				driver.switchTo().window(childWindow);
//				tr.payment("6522623006925353", "0123", "161");
//			}
//		}

	}
}
