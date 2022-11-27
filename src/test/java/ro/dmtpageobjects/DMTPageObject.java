package ro.dmtpageobjects;
 import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
public class DMTPageObject {
	
	public DMTPageObject (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//li[@id='60']/ul/li")
public List<WebElement> DrodownList;

@FindBy(linkText="DMT")
public WebElement DMT;


@FindBy(xpath="//li[@id='58']/a")
public WebElement Aremit;


@FindBy(name="mobile_no")
public WebElement SendermobNo;


@FindBy(name="recipientInput")
public WebElement RecipientMobNo;

@FindBy(xpath="//tr[@class='separator'][2]/td[2]")
public WebElement clickOnSubmit;

@FindBy(xpath="//form[@id='RecipientForm']/table/tbody/tr")
public List<WebElement> tableData;

@FindBy(xpath="//table[@class='particulars']/tbody/tr/td[2]")
public List<WebElement> RecipientName;

@FindBy(xpath="//table[@class='particulars']/tbody/tr/td[7]")
public List<WebElement> PayNowBtn;


public void DMR()
{
	DMT.click();
}

public void getListOfDMT()
{
	for(int i=0; i<DrodownList.size();i++)
	{
		String listValue=DrodownList.get(i).getText();
		System.out.println("Value of dropdown is : " +listValue);
	}
}


public void clickOnAremit()
{
	Aremit.click();
}


public void senderMobNo(String num)
{
	SendermobNo.sendKeys(num);
}

public void recipientMobNo(String num)
{
	RecipientMobNo.sendKeys(num);
}

public void submit()
{
	clickOnSubmit.click();
}

public void tableValue()
{
	for(int i=0; i<tableData.size();i++)
	{
		String TableData=tableData.get(i).getText();
		System.out.println(" "+TableData+" ");
	}
}

public void getRepientText()
{
	for(int i=0; i<RecipientName.size();i++)
	{
		System.out.println(" ");
		System.out.println(RecipientName.get(i).getText());
	}
}


public void clickONPayNowBtn()
{
	for(int i=0; i<RecipientName.size();i++)
	{
		//System.out.println("00000000000000");
		if(RecipientName.get(i).getText().equals("PREETI"))
		{
			//System.out.println("11111111111");
			PayNowBtn.get(i).click();
		}
	}
}




}

