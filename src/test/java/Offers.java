import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Offers {
 static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bs0452\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
	List<WebElement> elementList=	driver.findElements(By.xpath("//tr/td[1]"));
	
	List<String> originalList=elementList.stream().map(s->s.getText()).collect(Collectors.toList());
	
List<String> modifiedSortedList=	originalList.stream().sorted().collect(Collectors.toList());
//		
//Assert.assertTrue(originalList.equals(modifiedSortedList));
//Assert.assertEquals(originalList, modifiedSortedList);
List<String> price;
//do {
//	List<WebElement> rows=driver.findElemenst(By.xpath("//tr/td[1]"));
//	
//  price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggies(s)).collect(Collectors.toList());
//
//
//}


	}

}
