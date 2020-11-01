package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class OrderSummaryPage extends TestBase {

	@FindBy (css="[class='btn btn-default button button-medium'][title='Proceed to checkout']")
	WebElement proceedCheckOutButton;
	
	@FindBy (css="[name='processAddress']")
	WebElement processAddressButton;
	
	@FindBy (id="cgv")
	WebElement termAndConditionCheckBox;
	
	@FindBy (css="[name='processCarrier']")
	WebElement processCarrierButton;
	
	@FindBy (css="[class='bankwire']")
	WebElement payByBankWire;
	
	@FindBy (css= "[class='button btn btn-default button-medium'][type='submit']")
	WebElement confirmOrder;
	
	@FindBy (xpath="//strong[text()='Your order on My Store is complete.']")
	WebElement orderConfirm;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	public OrderSummaryPage proceedCheckOut() {
		proceedCheckOutButton.click();
		return this;
	}
	public OrderSummaryPage proceedAddressCheckOut() {
		processAddressButton.click();
		return this;
	}
	public OrderSummaryPage proceedShipping() {
		termAndConditionCheckBox.click();
		processCarrierButton.click();
		return this;
	}
	public OrderSummaryPage confirmOrder() {
		payByBankWire.click();
		confirmOrder.click();
		return this;
	}
	public String getConfirmMessage() {
		return orderConfirm.getText();
	}
}
