package Selenium.SeleniumFrameworkDesign.pageobjects;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".user__address .input.txt.text-validated")
	WebElement CountryName;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement EnterName;
	
	@FindBy(xpath="(//*[contains(@class,'ta-results')]/button)[2]")
	WebElement SelectResult;
	
	@FindBy(css=".action__submit")
	WebElement PlaceOrder;
	
	
	By results= By.xpath("//*[contains(@class,'ta-results')]");
	
	public void selectCountry() throws InterruptedException {
//		CountryName.sendKeys("ind");
		
		 
         CountryName.sendKeys("ind");
		
		 Actions a= new Actions(driver);
		 a.sendKeys(EnterName, "india");
		 
		 
		 waitForElementToAppear(results);
		 SelectResult.click();
		 Thread.sleep(3000);
		 
	}
	
	
	public ConfirmationPage clickOnPlaceOrder() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		PlaceOrder.click();
		Thread.sleep(3000);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
	
		
}
