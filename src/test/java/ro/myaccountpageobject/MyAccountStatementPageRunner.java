package ro.myaccountpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ro.dmtpageobjects.HomePageObject;
import ro.dmtpageobjects.LoginPageObjects;

public class MyAccountStatementPageRunner {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		//loginPage.enterOTP();
		//loginPage.clickLoginbtn.click();
		// loginPage.enterOTP.sendKeys("111111");

		// loginPage.clickLoginbtn.click();

		Thread.sleep(5000);
		// HomePage
		HomePageObject hp = new HomePageObject(driver);

		hp.CrossBtn();
		
		MyAccountStatementPageObject myac=new MyAccountStatementPageObject(driver);
		myac.MyAccount();
		
		myac.clickOnStatementToGetReport();
		myac.clickFromDate();
		myac.clickSelectMonth();
		
		//myac.getMonth();
		myac.getMonths();
		myac.getYear();
		myac.datePicker();
		myac.clicTODATE();
		myac.getToMonths();
		myac.getToYear();
		myac.dateToPicker();
		myac.clickOnSelectProd();
		myac.selectProductFromDropdown();
		myac.ClickOnSub();
		myac.tableElement();
		myac.particulars();
		

	}

}
