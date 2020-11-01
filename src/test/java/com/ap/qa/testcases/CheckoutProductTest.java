package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.datamodel.ProductData;
import com.ap.qa.base.TestBase;
import com.ap.qa.dataprovider.DataProviders;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LogInPage;
import com.ap.qa.pages.OrderSummaryPage;
import com.ap.qa.pages.ProductDetailsPage;
import com.ap.qa.pages.SearchPage;

public class CheckoutProductTest extends TestBase{

	LogInPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;
	OrderSummaryPage orderSummaryPage;
	
	public CheckoutProductTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LogInPage();
		homePage = new HomePage();
		productDetailsPage = new ProductDetailsPage();
		orderSummaryPage = new OrderSummaryPage();
		searchPage = new SearchPage();
	}
	@Test(dataProvider = "ProductData", dataProviderClass = DataProviders.class)
	public void testCheckoutProcess(ProductData data) {
		String product = data.getProductName();
		homePage.CicknOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		searchPage = homePage.searchProduct(product);
		String header = searchPage.getHeader();
		System.out.println(header);
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		productDetailsPage = searchPage.selectProduct(product);
		productDetailsPage.inputQuantity(data.getQuantity());
		productDetailsPage.selectProdutctColor(data.getColor());
		productDetailsPage.selectSize(data.getSize());
		productDetailsPage.clickAddCart();
		
		orderSummaryPage = productDetailsPage.proceedCheckOut();
		orderSummaryPage.proceedCheckOut();
		orderSummaryPage.proceedAddressCheckOut();
		orderSummaryPage.proceedShipping();
		orderSummaryPage.confirmOrder();
		
		String message = orderSummaryPage.getConfirmMessage();
		Assert.assertEquals("Your order on My Store is complete.", message);
		homePage.logOut();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
