package com.ap.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LogInPage;

public class LoginPageTest extends TestBase{

	LogInPage loginPage;
	HomePage homePage;
	
	//Constructor
	public LoginPageTest(){
		//Super class
		super();
	}
	@BeforeMethod
	public void setUp() {
		//We need to initialize because we need to trigger the login and homepage in order to start our testing
		initialization();
		loginPage = new LogInPage();
		homePage = new HomePage();
	}
	
	@Test
	public void loginTest() {
		homePage.CicknOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage.logOut();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
