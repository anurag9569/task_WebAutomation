package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.testbase;

public class HomePage extends testbase{

	@FindBy(xpath="//span[@id='roundTrip']")
	public WebElement returnBtn;
	
	@FindBy(id="gosuggest_inputSrc")
	public WebElement fromTxt;
	
	@FindBy(id="gosuggest_inputDest")
	public WebElement destTxt;
	
	@FindBy(id="departureCalendar")
	public WebElement departureCal;
	
	@FindBy(xpath="//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[5]/div/div")
	public WebElement departureCalDropDown;
	
	@FindBy(xpath="//span[starts-with(@class,'DayPicker-NavButton')]")
	public WebElement departureCalNav;
	
	
	@FindBy(xpath="//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[5]/div/div/div[2]/div[3]/div[5]/div[4]")
	public WebElement departureCalSelectDate;
	
	@FindBy(id="gi_search_btn")
	public WebElement searchBtn;
	
	WebDriverWait wait=new WebDriverWait(driver,20);
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void waitxpath(WebElement e)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""+e+"")));
	}
	
	public void clickRoundTrip()
	{
		returnBtn.click();
	}
	
	public void fillInitials() throws InterruptedException
	{
		Actions a=new Actions(driver);
		fromTxt.sendKeys("Delhi");
		Thread.sleep(5000);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		destTxt.sendKeys("Mumbai (BOM)");
		Thread.sleep(5000);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		departureCal.click();
		if(departureCalDropDown.isDisplayed())
		{
			departureCalNav.click();
			departureCalSelectDate.click();
		}
	}
	
	public void searchClk() throws InterruptedException
	{
		searchBtn.click();
		Thread.sleep(5000);
	}
}
