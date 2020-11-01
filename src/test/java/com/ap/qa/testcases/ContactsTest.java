package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.contactsPage;

public class ContactsTest extends TestBase {

	contactsPage contactsPage;
	HomePage homePage;
	
	public ContactsTest(){
		super();
	}
	
	@BeforeMethod
	public void setyp() {
		initialization();
		contactsPage = new contactsPage();
		homePage = new HomePage();
	}
	@Test
	public void testContact() {
		homePage.ClickOnContactLink();
		contactsPage = contactsPage.fillContactForm("Customer Service", "test1@gmail.com", "Test1", "Nothing serious");
		
		contactsPage.submitMesage();
		String successMsg = contactsPage.getMessage();
		Assert.assertEquals(successMsg, "Your message has been successfully sent to our team.");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
