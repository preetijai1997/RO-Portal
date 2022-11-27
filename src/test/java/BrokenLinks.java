import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bs0452\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://portal.bankit.in:9090/RO/");
		
		driver.switchTo().frame("Main");
		
		driver.findElement(By.name("userName")).sendKeys("preeti.jaiswal@bankit.in");
		driver.findElement(By.id("password")).sendKeys("Preeti@11");
		
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='popup']/div/div/button[@class='close']")).click();
		
      List<WebElement> links=  driver.findElements(By.xpath("//h5/a"));
      SoftAssert a =new SoftAssert();
      for(WebElement link:links)
      {
    	  String url= link.getAttribute("href");
    	  
    	  HttpURLConnection   con= (HttpURLConnection)new URL(url).openConnection();
  con.setRequestMethod("HEAD");
  
  con.connect();
  int ResponseCode=con.getResponseCode();
 System.out.println(ResponseCode);
	 // System.out.println("The broken link is "+ link.getText()+ "Response Code "+ResponseCode);
      a.assertTrue(ResponseCode>400, "The link with Text"+link.getText()+" is broken with code" +ResponseCode);
      }
  a.assertAll();
      }
}
	


