package com.ap.qa.ExtentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 

public class ExtentReporterNG implements IReporter{

	private ExtentReports extent;
	
	//to run diiferent script like (login, homepage, contactsPage etc)
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outPutDirectory) {
		extent = new ExtentReports(outPutDirectory + File.separator + "Extent.html", true);
		
		for(ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			
			//This will capture the result.If its passed than it will say passed. If it fails and theres any error it will also appear in the report
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				
				//Create a method. inside the method we created a object. Each methods will hold result of different status (Pass/Fail/Skip)
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		//After each execution it will clear the captured information
		extent.flush();
		//It closes the event
		extent.close();
	}
	//It referring to the buildTestNodes on the top where it maps the result.
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		
		//Means there should be atleast 1 test case or more in order to execute
		if(tests.size()>0) {
			//Records all test results
			for(ITestResult result : tests.getAllResults()) {
				//Test object is holding the result of the method that will be executed and the name of the method
				test = extent.startTest(result.getMethod().getMethodName());
				//(Line 60-61)Its for recording purpose so we know which file was executed in what time.
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				//This is going to group all the methods so the report is not redundent. For example log in has 3 methods rather than going through all of them it will create a group with the 3 methods and show result.
				for(String group : result.getMethod().getGroups())
				test.assignCategory(group);
				//If statement: if theres any exception it will capture the exception
				if(result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				}
				//if theres no exception than it will check the status of the test and will add ed at the end (line 39-41). so the result will Test is Passed/Failed/Skipped
				else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}
				//this end the test
				extent.endTest(test);
			}
		}
	}
	//
	private Date getTime(long millis) {
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(millis);
		return calender.getTime();
	}
}
