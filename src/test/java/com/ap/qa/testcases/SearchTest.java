package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LogInPage;
import com.ap.qa.pages.SearchPage;

public class SearchTest extends TestBase{

	LogInPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	
	public SearchTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LogInPage();
		homePage = new HomePage();
		searchPage = new SearchPage();
	}
	@Test
	public void testSearchItem() {
		
		String product = "Evening";
		homePage.CicknOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		//Casual, Evening, Summer
		searchPage = homePage.searchProduct("Evening");
		String header = searchPage.getHeader();
		System.out.println(header);
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		homePage.logOut();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
