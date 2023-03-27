package Selenium.SeleniumFrameworkDesign.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	
	@FindBy(css = ".ng-animating")
	WebElement animating;
	
	By productsBy=By.cssSelector(".mb-3");
	By AddToCart= By.xpath("//*[text()=' Add To Cart']");
	By toast=By.cssSelector("#toast-container");
	
	@FindBy(xpath="//*[contains(@routerlink,'myorders')]")
	WebElement orderButton;
	
	public OrderPage clickOnOrders() throws InterruptedException {
		Thread.sleep(2000);
		orderButton.click();;
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
		
	}
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getTheProduct(String iteamName) {
		WebElement prod= getProductList().stream().filter(product->
		 product.findElement(By.cssSelector("b")).getText().equals(iteamName)).findFirst().orElse(null);
		return prod;
		
	}
	
	public CartPage1 addProductToCart(String iteamName) {
		
		WebElement prod=getTheProduct(iteamName);
		prod.findElement(AddToCart).click();
		waitForElementToAppear(toast);
		waitForElementToDissapier(animating);
		 return new CartPage1(driver);

		 
		
	}
	
	
	
	

}
