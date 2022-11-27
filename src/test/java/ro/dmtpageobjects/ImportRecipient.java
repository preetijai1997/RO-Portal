package ro.dmtpageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportRecipient {

	public ImportRecipient(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='import']")
	public WebElement clickOnImportRecp;

	@FindBy(id = "senderImportId")
	public WebElement SenderMobNo;

	@FindBy(xpath = "//input[@onclick='importPageCall();']")
	public WebElement clickOnSubmit;

	@FindBy(xpath = "//table[@class='particulars']/tbody/tr")
	public List<WebElement> ImportFromTableFetchData;

	@FindBy(id = "senderImportToId")
	public WebElement senderNum;

//	@FindBy(xpath = "//input[@value='AES_64375327']")
//	public WebElement selectedCheckbox;

	@FindBy(xpath = "//table[@class='particulars']/tbody/tr/td/input[@name='recipientIds']")
	public List<WebElement> checkboxList;

	@FindBy(xpath = "//table[@class='particulars']/tbody/tr/td[2]")
	public List<WebElement> RecipientName;
	
	@FindBy(xpath="//input[@onclick='importSelected();']")
	public WebElement importSelected;

	public void clickOnImport() {
		clickOnImportRecp.click();
	}

	public void formImportFrom(String num) {
		SenderMobNo.sendKeys(num);
		clickOnSubmit.click();
	}
	/*
	 * public void ImportTo() { selectedCheckbox.click(); boolean value =
	 * selectedCheckbox.isSelected(); System.out.println(value); }
	 */
//	public void selectedCheckbox() {
//		String[] Recipient_Name = { "Preeti", "Afroz", "Test", "Preeti Jaiswal" };
//		for (int i = 0; i < Recipient_Name.length; i++) {
//			if (Recipient_Name[i] == "Preeti" || Recipient_Name[i] == "Test") {
//				//System.out.println("====================");
//				checkboxList.get(i).click();
//				System.out.println(checkboxList.get(i));
//			boolean checkbox=	checkboxList.isSelected();
//			System.out.println(checkbox);
//			}
//		}
//
//	}
	
	public void getRecipientName()
	{
		for(int i=0;i<RecipientName.size();i++)
		{
			System.out.println(RecipientName.get(i).getText());
		}
	}

	public void selectbox(String num) {
		for (int i = 0; i < RecipientName.size(); i++) {
			//System.out.println("Print =============");
			if (RecipientName.get(i).getText().equals("PREETI") || RecipientName.get(i).getText().equals("TEST"))

			{
				//System.out.println("output============");
				checkboxList.get(i).click();
				System.out.println(" ");
				System.out.println(RecipientName.get(i).getText());
			boolean checklistName=	checkboxList.get(i).isSelected();
			System.out.println("Selected value is =="+checklistName);
			senderNum.sendKeys(num);
			importSelected.click();
			
			}
		}
	}

}
