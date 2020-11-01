package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class SearchPage extends TestBase{

	@FindBy (css="[title='Add to cart']")
	WebElement addCartButton;
	
	@FindBy (css="[title='Proceed to checkout']")
	WebElement checkOut;

	@FindBy (css= "[class='page-headingproduct-listing']")
	WebElement searchHeading;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductDetailsPage selectProduct(String productName) {
		//Whatever dress i provide in my excel file i should be able to handle it by getting name, title
		String locator = "[class='product-name'][title='" + productName + "']";
		driver.findElement(By.cssSelector(locator)).click();
		return new ProductDetailsPage();
	}
	public String getHeader() {
		return searchHeading.getText();
	}

}
