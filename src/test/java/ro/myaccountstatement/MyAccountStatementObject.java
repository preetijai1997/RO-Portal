package ro.myaccountstatement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class MyAccountStatementObject {

	public MyAccountStatementObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	public WebElement clickOnMyAccount;

	@FindBy(xpath = "//ul[contains(@class,'myAccount')]/li")
	public List<WebElement> dropdownList;

	@FindBy(linkText = "My Account Statement")
	public WebElement clickonMyAcState;

	@FindBy(xpath = "//div[@class='heddingBox']")
	public WebElement getTextOfHeading;

	@FindBy(xpath = "//input[@id='fromDate']")
	public WebElement clickOnFromDate;

	@FindBy(xpath = "//option[@selected='selected']")
	public List<WebElement> monthYear;

	@FindBy(xpath = "//select[@data-handler='selectMonth']/option")
	public List<WebElement> months;

	@FindBy(xpath = "//select[@data-handler='selectYear']/option")
	public List<WebElement> years;

	@FindBy(xpath = "//select[@data-handler='selectMonth']")
	public WebElement clickOnMonthBox;

	@FindBy(xpath = "//select[@data-handler='selectYear']")
	public WebElement clickOnYearBox;

	@FindBy(xpath = "//td[@data-handler='selectDay']/a[text()='1']")
	public WebElement date;

	@FindBy(xpath = "//td[@data-handler='selectDay']/a[text()='30']")
	public WebElement date1;

	@FindBy(xpath = "//td[@data-handler='selectDay']/a[text()='30']")
	public WebElement date2;

	@FindBy(xpath = "//input[@id='toDate']")
	public WebElement todateclick;

	@FindBy(xpath = "//select[@id='product']")
	public WebElement selectProducttextbox;

	@FindBy(xpath = "//select[@id='product']/option")
	public List<WebElement> selectProduct;

	@FindBy(xpath = "//input[@value='Submit']")
	public WebElement clickOnSub;

	@FindBy(xpath = "//div[@align='center'][2]/table/tbody/tr")
	public List<WebElement> entries;

	@FindBy(xpath = "//table[@class='table table-fixed']/thead/tr/th")
	public List<WebElement> tableheading;

	@FindBy(xpath = "/html/body/section[1]/div/div/div/div[3]/table/tbody/tr[1]/td[4]/a")
	public WebElement clickOnSettlement;

	@FindBy(xpath = "//input[@id='print']")
	public WebElement clickOnPrintRecipiet;

	public void myaccount() {
		clickOnMyAccount.click();
		for (int i = 0; i < dropdownList.size(); i++) {
			String listName = dropdownList.get(i).getText();
			System.out.println(listName);

			if (dropdownList.get(i).getText().equalsIgnoreCase("My Account Statement")) {
				clickonMyAcState.click();
				break;
			}
		}
	}

	public void fromcalendar(String expMonth, String expYear) {
		System.out.println(getTextOfHeading.getText());
		clickOnFromDate.click();

		for (int i = 0; i < monthYear.size(); i++) {
			System.out.println(monthYear.get(i).getText());
		}

		if (clickOnMonthBox.equals(expMonth)) {
			clickOnMonthBox.click();
		}

		if (clickOnYearBox.equals(expYear)) {
			clickOnYearBox.click();
		}

		for (int i = 0; i < months.size(); i++) {
			String monthname = months.get(i).getText();
			System.out.println(monthname);
			clickOnMonthBox.click();
			if (months.get(i).getText().equals(expMonth)) {
				months.get(i).click();
				break;
			}
		}

		for (int i = 0; i < years.size(); i++) {
			String yearvalue = years.get(i).getText();
			System.out.println(yearvalue);
			clickOnYearBox.click();
			if (years.get(i).getText().equals(expYear)) {
				years.get(i).click();
				break;
			}
		}

		date.click();

	}

	public void tocalendar(String expMonth, String expYear) {

		todateclick.click();

		for (int i = 0; i < monthYear.size(); i++) {
			System.out.println(monthYear.get(i).getText());
		}

		if (clickOnMonthBox.equals(expMonth)) {
			clickOnMonthBox.click();
		}

		if (clickOnYearBox.equals(expYear)) {
			clickOnYearBox.click();
		}

		for (int i = 0; i < months.size(); i++) {
			String monthname = months.get(i).getText();
			System.out.println(monthname);
			clickOnMonthBox.click();
			if (months.get(i).getText().equals(expMonth)) {
				months.get(i).click();
				break;
			}
		}

		for (int i = 0; i < years.size(); i++) {
			String yearvalue = years.get(i).getText();
			System.out.println(yearvalue);
			clickOnYearBox.click();
			if (years.get(i).getText().equals(expYear)) {
				years.get(i).click();
				break;
			}
		}

		date1.click();

	}

	public void SelectProduct(String product) throws InterruptedException {
		for (int i = 0; i < selectProduct.size(); i++) {
			if (selectProduct.get(i).getText().equals(product)) {
				selectProducttextbox.click();
				Thread.sleep(2000);
				selectProduct.get(i).click();
			}

		}
		clickOnSub.click();

	}

	public void getEntryData() throws InterruptedException {
		for (int i = 0; i < entries.size(); i++) {
			System.out.println(entries.get(i).getText());

			Thread.sleep(3000);

		}
	}

	public void clickOnService() {
		clickOnSettlement.click();

	}

	public void printRecipiet() {
		clickOnPrintRecipiet.click();
	}

}
