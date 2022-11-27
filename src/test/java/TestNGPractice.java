import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGPractice {
	static WebDriver driver;

	@BeforeSuite
	public void driverInfo() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bs0452\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.bankit.in/RO/");
		System.out.println("Open URL");
}

	@Test
	public void SignUp() throws InterruptedException {
		
		driver.switchTo().frame("Main");
		driver.findElement(By.name("userName")).sendKeys("shobhit.rai@bankit.in");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("login")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='popup']/div/div/button")).click();
		
		System.out.println("Login Successful");
		System.out.println("Cut popup");
		}
	
	
	
	

}
