package TestCases;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.testbase;
import ObjectRepository.FlightPage;
import ObjectRepository.FlightReviewPage;
import ObjectRepository.HomePage;

public class TC1 extends testbase{

	@BeforeTest
	public void initiate()
	{
		testbase.start();
		testbase.report();
	}
	
	@Test
	public void execute() throws InterruptedException
	{
		test=extentReport.startTest("bewakoof TC1");
		HomePage homepage=new HomePage();
		FlightPage flightPage=new FlightPage();
		FlightReviewPage flightReviewPage=new FlightReviewPage();
	
		//homepage.waitxpath(homepage.returnBtn);
		test.log(LogStatus.INFO, "Step 01 : Go to https://www.goibibo.com");
		test.log(LogStatus.INFO, "Step 02 : Book a flight for round trip (From Delhi to Mumbai)");
		homepage.clickRoundTrip();
		homepage.fillInitials();
		Thread.sleep(5000);
		homepage.searchClk();
		
		
		
		test.log(LogStatus.INFO, "Step 03 : Sort the prices from higher to lower");
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(10000);
		flightPage.dragOwnwardSortPrice();
		Thread.sleep(10000);
		flightPage.dragReturnSortPrice();
		Thread.sleep(8000);
		
		
		test.log(LogStatus.INFO, "Step 04 : Book flight which have highest price");
		flightPage.onwardPrice.click();
		flightPage.returnPrice.click();
		Thread.sleep(5000);
		flightPage.clickBtn();
		Thread.sleep(10000);
		
		
		
		test.log(LogStatus.INFO, "Step 05 : Fill traveller details (details should be passed from command line)");
		flightReviewPage.riskRadioBtn.click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
		Thread.sleep(30000);
		flightReviewPage.dropDown();
		Scanner sc=new Scanner(System.in);
		String s[]=new String[4];
		for(int i=0;i<s.length;i++)
		{
			s[i]=sc.nextLine();
		}
		flightReviewPage.gh(s);
		Thread.sleep(5000);
		flightReviewPage.clickProceedPayment();
		
		
		test.log(LogStatus.INFO, "Step 06 : Choose Payment Method Amazon Pay but do not pay (Stop automation here)");
		
	}
	
	@AfterMethod
	public void generateReport(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "test case failed is " + result.getName() + result.getThrowable());
			
			String screenshotPath=testbase.screenshotCapture(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "test case passed is " + result.getName());
		}
		else
		{
			test.log(LogStatus.SKIP, "" +result.getName()+result.getThrowable());
		}
	}
	
	@AfterTest
	public void end()
	{
		driver.quit();
		extentReport.flush();
		
	}
}
