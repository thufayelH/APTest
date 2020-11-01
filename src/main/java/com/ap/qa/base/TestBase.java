package com.ap.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.qa.util.TestUtil;
import com.ap.qa.util.WebEventListener;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	//Constructor
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "src/main/java/com/ap/qa/config/config.properties");
			prop.load(ip);
			
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		//cross browser testing
		//Method to handle the browser
		//if the browser name is chrome than it will run in chrome browser if its FF than it will run on Firefox
		public static void initialization() {
			String browserName = prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "src/main/java/com/ap/qa/config/config.properties");
				driver = new ChromeDriver();
		
			}
			
			else if(browserName.equalsIgnoreCase("FF")) {
				System.setProperty("webdriver.gecko.driver", "src/main/java/com/ap/qa/config/config.properties");
				driver = new FirefoxDriver();
			}
			
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();//we are not able to find webeventlistener because we didnt finished our webeventlistener class
			e_driver.register(eventListener);
			driver = e_driver;
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);//we need to update the pagetime load in sec
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);//we need to to update the implicit time load in sec.
			driver.get(prop.getProperty("url"));
			
			
	}

	}
