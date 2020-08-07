package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.testbase;

public class FlightPage extends testbase{

	@FindBy(xpath="(//*[@id=\"sliderFO\"]/div/div/div[4])[1]")
	public WebElement sortLowPrice;
	
	@FindBy(xpath="//*[@id=\"sliderFO\"]/div/div/div[5]")
	public WebElement sortHighPrice;
	
	@FindBy(xpath="(//*[@id=\"sliderFO\"]/div/div/div[4])[2]")
	public WebElement sortLowPrice1;
	
	@FindBy(xpath="//*[@id=\"sliderFO\"]/div/div/div[5]")
	public WebElement sortHighPrice2;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[5]/div[1]/div/div/div/div[2]/div[2]/div/span[2]/label")
	public WebElement onwardPrice;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div[2]/div[2]/div/span[2]/label")
	public WebElement returnPrice;
	
	
	@FindBy(xpath="//input[@type=\"button\"]")
	public WebElement bookBtn;
	
	public FlightPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void dragOwnwardSortPrice()
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(sortLowPrice, sortHighPrice).build().perform();
	}
	
	
	public void dragReturnSortPrice()
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(sortLowPrice1, sortHighPrice2).build().perform();
	}
	
	public void clickHighestPriceOnwardReturn()
	{
		onwardPrice.click();
		returnPrice.click();
	}
	
	public void clickBtn()
	{
		bookBtn.click();
	}
}
