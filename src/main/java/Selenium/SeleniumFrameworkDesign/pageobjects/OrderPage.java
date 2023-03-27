package Selenium.SeleniumFrameworkDesign.pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath="(//*[@class='ng-star-inserted'])[1]//tr//td[2]")
	List<WebElement> productName;
	

		public boolean getTheProductName(String iteamName) throws InterruptedException {
			Thread.sleep(2000);
			boolean match=productName.stream().anyMatch(product->product.getText().equalsIgnoreCase(iteamName));
			return match;
		}
		
		
	
	
}

