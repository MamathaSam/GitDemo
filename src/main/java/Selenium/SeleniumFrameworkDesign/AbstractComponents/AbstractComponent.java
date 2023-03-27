package Selenium.SeleniumFrameworkDesign.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.SeleniumFrameworkDesign.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	OrderPage orderPage;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	
	 
	
	 public void waitForElementToAppear(By findBy) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

		}
	 public void waitForWebElementToAppear(WebElement findBy) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(findBy));

		}
		
	 public void waitForElementToDissapier(WebElement ele) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			 wait.until(ExpectedConditions.invisibilityOf(ele));
			 
		}
		

}
