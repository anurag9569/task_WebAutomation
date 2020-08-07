package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import util.utility;

public class testbase {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extentReport;
	public static ExtentTest test;
	
	
	public testbase()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis= new FileInputStream("C:\\Users\\Anurag\\eclipse-workspace1\\goIbibo\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void start()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver =new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(utility.implicitWait,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(utility.pageload, TimeUnit.MINUTES);
	}
	
	public static void report()
	{
		extentReport = new ExtentReports("C:\\Users\\Anurag\\eclipse-workspace1\\goIbibo\\test-output\\extentreport.html",true);
	}
	
	public static String screenshotCapture(WebDriver driver,String screenshot) throws IOException
	{
		driver=testbase.driver;
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File a=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="C:\\Users\\Anurag\\eclipse-workspace1\\goIbibo\\test-output\\"+screenshot+date+".png";
		FileHandler.copy(a, new File(destination));
		return destination;
	}
}
