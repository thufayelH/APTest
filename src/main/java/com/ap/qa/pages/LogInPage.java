package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ap.qa.base.TestBase;

public class LogInPage extends TestBase {

	@FindBy (id="email")
	WebElement username;
	
	@FindBy (id="passwd")
	WebElement password;
	
	@FindBy (id="SubmitLogin")
	WebElement submitLogin;
	
	public LogInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String email, String pwd) {
		username.sendKeys(email);
		password.sendKeys(pwd);
		submitLogin.click();
		return new HomePage();
	}
	

}
