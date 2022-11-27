import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPageObject {

	public OffersPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr/td[1]")
	public List<WebElement> listOffruitandVeg;

	@FindBy(xpath = "//tr/td[2]")
	public List<WebElement> listOfPrice;

	public void getPrice(WebDriver driver) {
		for (int i = 0; i < listOffruitandVeg.size(); i++) {
			String vegorfruit = listOffruitandVeg.get(i).getText();
			if (vegorfruit.equals("Strawberry")) {
				
				
				String price = driver.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();

				System.out.println(price);
			}
			

		}

	}

}
