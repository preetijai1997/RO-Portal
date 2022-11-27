package ro.myaccountpageobject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountStatementPageObject {

	public MyAccountStatementPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(@class,'dropdown-toggle')]")
	public WebElement clickOnMyAccountStatement;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu ')]/li")
	public List<WebElement> listOfAccStatement;

	@FindBy(xpath = "//a[@href='doAccountStatement.do?param=accountStatementPage']")
	public WebElement clickOnStatement;
	
	@FindBy(xpath="//input[@name='fromDate']")
	public WebElement clickOnFromDate;
	
	@FindBy(xpath="//select[@data-handler='selectMonth']")
	public WebElement clickOnSelectMonth;
	
	@FindBy(xpath="//select[@data-handler='selectMonth']/option")
	public List<WebElement> selectMonths;
	
	//selectYear
	@FindBy(xpath="//select[@data-handler='selectYear']")
	public WebElement clickOnSelectYear;
	
	@FindBy(xpath="//select[@data-handler='selectYear']/option")
	public List<WebElement> selectYears;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody/tr/td")
	public List<WebElement> dateSelect;

	
	@FindBy(xpath="//input[@id='toDate']")
	public WebElement clickOnTodate;
	
	@FindBy(xpath="//select[@id='product']")
	public WebElement clickOnProduct;
	
	@FindBy(xpath="//select[@id='product']/option")
	public List<WebElement> selectProduct;
	
	@FindBy(xpath="//input[@value='Submit']")
	public WebElement clickOnSub;
	
	@FindBy(xpath="//table[contains(@class,'table-fixed')]/tbody/tr/td")
	public List<WebElement> tableData; 
	
	@FindBy(xpath="//table[contains(@class,'table-fixed')]/tbody/tr/td[4]")
	public List<WebElement> clickOnParticulars;
	
	public void MyAccount() {
		clickOnMyAccountStatement.click();
	}
//	   for(int i=0; i<listOfAccStatement.size();i++)
//	   {
//		String ListOfMyAcc=listOfAccStatement.get(i).getText();
//		System.out.println(ListOfMyAcc);   
//          
//	   }
	
	public void clickOnStatementToGetReport()
	{
		for (int j = 0; j < listOfAccStatement.size(); j++) {
			if (listOfAccStatement.get(j).getText().equalsIgnoreCase("My Account Statement")) {
				clickOnStatement.click();
			}
		}
	}
	public void clickFromDate()
	{
		clickOnFromDate.click();
	}
	public void clickSelectMonth()
	{
		clickOnSelectMonth.click();
	}

	
	public void getMonths()
	{
		for(int k=0; k<selectMonths.size();k++)
		{
			String month= selectMonths.get(k).getText();
			System.out.println("month is======" +month);
			//String ele=driver.findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='8']")).getText();
			if(month.equalsIgnoreCase("Nov"))
			{
				//System.out.println("000000000");
				selectMonths.get(k).click();;
				//clickOnSelectMonth.click();
				break;
			}
		}
	}
	
	public void getYear()
	{
		for(int l=0; l<selectYears.size();l++)
		{
			String year= selectYears.get(l).getText();
			System.out.println("Year is======" +year);
			//String ele=driver.findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='8']")).getText();
			if(year.equalsIgnoreCase("2022"))
			{
				//System.out.println("000000000");
				selectYears.get(l).click();;
				//clickOnSelectMonth.click();
				break;
			}
		}
	}
	
	public void datePicker()
	{
		for(int m=0; m<dateSelect.size();m++)
		{
			String date= dateSelect.get(m).getText();
			System.out.println("Date is======" +date);
			//String ele=driver.findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='8']")).getText();
			if(date.equalsIgnoreCase("1"))
			{
				//System.out.println("000000000");
				dateSelect.get(m).click();;
				//clickOnSelectMonth.click();
				break;
			}
		}
	}
	
	public void clicTODATE()
	{
		clickOnTodate.click();
	}
	
	public void getToMonths()
	{
		for(int k=0; k<selectMonths.size();k++)
		{
			String month= selectMonths.get(k).getText();
			System.out.println("month is======" +month);
			//String ele=driver.findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='8']")).getText();
			if(month.equalsIgnoreCase("Nov"))
			{
				//System.out.println("000000000");
				selectMonths.get(k).click();;
				//clickOnSelectMonth.click();
				break;
			}
		}
	}
	
	public void getToYear()
	{
		for(int l=0; l<selectYears.size();l++)
		{
			String year= selectYears.get(l).getText();
			System.out.println("Year is======" +year);
			//String ele=driver.findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='8']")).getText();
			if(year.equalsIgnoreCase("2022"))
			{
				//System.out.println("000000000");
				selectYears.get(l).click();;
				//clickOnSelectMonth.click();
				break;
			}
		}
	}
	
	public void dateToPicker()
	{
		for(int m=0; m<dateSelect.size();m++)
		{
			String date= dateSelect.get(m).getText();
			System.out.println("Date is======" +date);
			//String ele=driver.findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='8']")).getText();
			if(date.equalsIgnoreCase("17"))
			{
				//System.out.println("000000000");
				dateSelect.get(m).click();;
				//clickOnSelectMonth.click();
				break;
			}
		}
	}
	public void clickOnSelectProd()
	{
		clickOnProduct.click();
	}
	
	public void selectProductFromDropdown()
	{
		for(int m=0; m<selectProduct.size();m++)
		{
			String prod= selectProduct.get(m).getText();
			System.out.println("Product is======" +prod);
			//String ele=driver.findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='8']")).getText();
			if(prod.equalsIgnoreCase("AEPS"))
			{
				
				//System.out.println("000000000");
				selectProduct.get(m).click();;
				//clickOnSelectMonth.click();
				break;
			}
		}
	}
	
	public void ClickOnSub()
	{
		clickOnSub.click();
	}
	
	public void tableElement()
	{
		for(int n=0;n<tableData.size();n++)
		{
			System.out.println(tableData.get(n).getText());
		}
	}
	
	public void particulars()
	{
		for(int p=0;p<clickOnParticulars.size();p++)
		{
			String serviceName=clickOnParticulars.get(p).getText();
			System.out.println("Service Name is==="+serviceName);
			if(serviceName.equalsIgnoreCase("AEPS-Mini Statement"))
			{
				System.out.println("11111111111");
				clickOnParticulars.get(p).click();
			}
		}
	}
	}


