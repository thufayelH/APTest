package com.ap.qa.util;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to : '" + url + "'");

	}
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After navigating to : '" + url + "'");

	}
	public void beforeChangeValueof(WebElement element, WebDriver driver) {
		System.out.println("Before Element value change to : '" + element.toString());

	}
	public void afterChangeValueof(WebElement element, WebDriver driver) {
		System.out.println("After Element value change to : '" + element.toString());

	}
	public void beforeClickon(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on : '" + element.toString());

	}
	public void afterClickon(WebElement element, WebDriver driver) {
		System.out.println("Clicked on : '" + element.toString());

	}
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After navigating page");
	}
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigating after to next page");
	}
		public void onException(Throwable error, WebDriver driver) {
			System.out.println("Exception Occured: " + error);
			try {
				TestUtil.takeScreenShotAtEndofTest();//We need to work on the TestUtil
			} catch (IOException e) {
				e.printStackTrace();
				
				
			}
		}
		public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println("Trying to find Element By: " + by.toString());
		}
		public void afterFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println("Found Element By: " + by.toString());
		}
		public void beforeScript(String script, WebDriver driver) {
			
		}
		public void afterScript(String script, WebDriver driver) {
			
		}
		@Override
		public void beforeAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void afterAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void afterAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void beforeAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void beforeNavigateRefresh(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void afterNavigateRefresh(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void beforeClickOn(WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void afterClickOn(WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void beforeSwitchToWindow(String windowName, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void afterSwitchToWindow(String windowName, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public <X> void beforeGetScreenshotAs(OutputType<X> target) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void beforeGetText(WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void afterGetText(WebElement element, WebDriver driver, String text) {
			// TODO Auto-generated method stub
			
		}

}
