package Selenium.SeleniumFrameworkDesign.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class Landingpage extends AbstractComponent {
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
//	WebElement  UserName=driver.findElement(By.id("userEmail"));
//	WebElement  Password=driver.findElement(By.id("userPassword"));
//	WebElement  Submit=driver.findElement(By.id("login"));
	
	@FindBy(id="userEmail")
	WebElement  UserName;
	
	
	@FindBy(id="userPassword")
	WebElement  Password;
	

	@FindBy(id="login")
	WebElement  Submit;
	
	@FindBy(xpath="//*[contains(@class,'flyInOut')]")
	WebElement  ErrorMsg;
	
	
	public ProductCatalogue loginApplication(String Email, String Pw) {
		
		UserName.sendKeys(Email);
		Password.sendKeys(Pw);
		Submit.click();
		return new ProductCatalogue(driver);
	}
	
	 public String getErrorText() throws InterruptedException {
		 Thread.sleep(1000);
		  return ErrorMsg.getText();
		 
	 }
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");    
	}
	
	
		
	
	
}
