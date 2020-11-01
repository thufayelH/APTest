package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.qa.base.TestBase;

public class ProductDetailsPage extends TestBase {

	@FindBy  (id="quantity_wanted")
	WebElement quantityInput;
	
	@FindBy  (id="group_1")
	WebElement sizeDropDown;

	@FindBy  (id="add_to_cart")
	WebElement addCartButton;
	
	@FindBy (css="[title='Proceed to checkout']")
	WebElement proceedCheckOut;
	
	@FindBy (css = "[title='Add to my wishlist']")
	WebElement addtoWishListButton;
	
	@FindBy (css= "[class='fancybox-error']")
	WebElement addWishListMsg;
	
	@FindBy (css="[class='fancybox-item fancybox-close']")
	WebElement addWishListMsgCloseButton;
	
	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	public void verifyAddWishListMsg() {
		Assert.assertEquals(addWishListMsg.getText(), "Added to your wishlist." );
		addWishListMsgCloseButton.click();
	}
	public ProductDetailsPage selectProdutctColor(String color) {
		String locator ="[name='"+color+"']";
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	}
	//clearing the qty field first than entering the qty
	public ProductDetailsPage inputQuantity(String quantity) {
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		return this;
	}
	//selecting the size from dropdown
	public ProductDetailsPage selectSize(String size) {
		Select select = new Select(sizeDropDown);
		select.selectByVisibleText(size);
		return this;
	}
	//Clicking on the add to card button
	public ProductDetailsPage clickAddCart() {
		addCartButton.click();
		return this;
	}
	//Clicking on add to wishlist button
	public ProductDetailsPage clickAddWishListButton() {
		addtoWishListButton.click();
		return this;
	}
	//Clicking on proceed checkout
	public OrderSummaryPage proceedCheckOut() {
		proceedCheckOut.click();
		return new OrderSummaryPage();
	}
}
