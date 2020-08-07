package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBase.testbase;

public class FlightReviewPage extends testbase{

	@FindBy(xpath="//*[@id=\"travellerForm\"]/div[2]/button")
	public WebElement proceedBtn;
	
	
	@FindBy(id="Adulttitle1")
	public WebElement idDropDown;
	
	@FindBy(id="AdultfirstName1")
	public WebElement firstName;
	
	
	@FindBy(xpath="//*[@id=\"email\"]")
	public WebElement email;
	
	
	@FindBy(id="AdultlastName1")
	public WebElement lastName;
	
	
	@FindBy(xpath="//*[@id=\"mobile\"]")
	public WebElement mobile;
	
	
	@FindBy(xpath="//*[@id=\"risk-trip\"]")
	public WebElement riskRadioBtn;
	
	
	
	public FlightReviewPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void dropDown()
	{
		Select s=new Select(idDropDown);
		s.selectByIndex(0);
	}
	
	public void gh(String args[])
	{
		
		firstName.sendKeys(args[0]);
		lastName.sendKeys(args[1]);
		email.sendKeys(args[2]);
		mobile.sendKeys(args[3]);		
	}
	
	public void clickProceedPayment()
	{
		proceedBtn.click();
	}
}
