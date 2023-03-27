package Selenium.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CartPage1 extends AbstractComponent {
	WebDriver driver;
	
	public CartPage1(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartt;
	
	By cartSection=By.cssSelector(".cartSection h3");
	
	
	@FindBy(css=".totalRow button")
	WebElement CheckOut;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
	
	
	

	
	
		public void clickOnCart() {
			cartt.click();
			waitForElementToAppear(cartSection);			
		}
	
		public boolean getTheCartItems(String iteamName) {
			boolean match=cartItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(iteamName));
			return match;
		}
		
		public CheckoutPage clickOnCheckOut() {
			CheckOut.click();
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			return checkoutPage;
		}

	
	
}

