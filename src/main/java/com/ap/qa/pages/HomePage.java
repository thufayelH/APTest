package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy (name="login")
	WebElement signInButton;
	
	@FindBy (css="[id='contact-link'] a")
	WebElement contactLink;
	
	@FindBy (id="search_query_top")
	WebElement searchInputBox;
	
	@FindBy (css="[name='submit_search']")
	WebElement submitSearch;
	
	@FindBy (css="[class='logout']")
	WebElement logOutButton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public SearchPage searchProduct(String productName) {
		searchInputBox.sendKeys(productName);
		submitSearch.click();
		return new SearchPage();
	}
	public void CicknOnSignIn() {
		signInButton.click();
	}
	public void ClickOnContactLink() {
		contactLink.click();
	}
	public void logOut() {
		logOutButton.click();
	}

}
