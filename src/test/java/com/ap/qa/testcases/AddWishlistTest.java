package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LogInPage;
import com.ap.qa.pages.ProductDetailsPage;
import com.ap.qa.pages.SearchPage;

public class AddWishlistTest extends TestBase{
	LogInPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;
	
	public AddWishlistTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LogInPage();
		homePage = new HomePage();
		searchPage = new SearchPage();
		productDetailsPage = new ProductDetailsPage();
	}
	@Test
	public void testAddProducttoWishList() {
		String product = "Printed Chiffon Dress";
		homePage.CicknOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		searchPage = homePage.searchProduct(product);
		String header = searchPage.getHeader();
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		productDetailsPage = searchPage.selectProduct(product);
		
		productDetailsPage.clickAddWishListButton();
		productDetailsPage.verifyAddWishListMsg();
		homePage.logOut();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	}