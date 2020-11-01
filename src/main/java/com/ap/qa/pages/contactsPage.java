package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.ap.qa.base.TestBase;

public class contactsPage extends TestBase{
	//Creating an object and holding the locator value.
	@FindBy(id = "id_contact")
	WebElement headingDropdown;
	
	@FindBy(id="email")
	WebElement emailInput;
	
	@FindBy(id="id_order")
	WebElement OrderReference;
	
	@FindBy(id="message")
	WebElement messageTextBox;
	
	@FindBy(id = "submitMessage")//*[@id="submitMessage"]/span
	WebElement SubmitMessageButton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p")
	WebElement successMsg;	
	
public contactsPage() {
		PageFactory.initElements(driver, this);//We need to update the TestBase class to remove the error
}	
			public contactsPage fillContactForm(String heading, String email, String reference, String message) {
			Select select = new Select(headingDropdown);
			select.selectByVisibleText(heading);
			emailInput.sendKeys(email);
			OrderReference.sendKeys(reference);
			messageTextBox.sendKeys(message);
			return this;
		}
		public void submitMesage() {
			SubmitMessageButton.click();
		}
		public String getMessage() {
			return successMsg.getText();
		}
	}
