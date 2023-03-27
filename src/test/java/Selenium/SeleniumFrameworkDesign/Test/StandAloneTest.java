package Selenium.SeleniumFrameworkDesign.Test;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String iteamName="ZARA COAT 3";
		
		 WebDriverManager.chromedriver().setup();
		 
		 WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/client");   
		 driver.findElement(By.id("userEmail")).sendKeys("mamsam@gmail.com");
		 driver.findElement(By.id("userPassword")).sendKeys("Mamatha@123");
		 driver.findElement(By.id("login")).click();
		 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		 
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		 
		 List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		 
		WebElement prod= products.stream().filter(product->
		 product.findElement(By.cssSelector("b")).getText().equals(iteamName)).findFirst().orElse(null);
		
		System.out.println(prod);
		
		prod.findElement(By.xpath("//*[text()=' Add To Cart']")).click();
		

		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		 
		 //ng-animating
		 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		 
		 driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		 

		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".cartSection h3")));
		 	
		List<WebElement> cartItems=  driver.findElements(By.cssSelector(".cartSection h3"));
		 
		Boolean match=cartItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(iteamName));
		 Assert.assertTrue(match);
		 
		 driver.findElement(By.cssSelector(".totalRow button")).click();
		 
		 driver.findElement(By.cssSelector(".user__address .input.txt.text-validated")).sendKeys("ind");
		 
		 Actions a= new Actions(driver);
		 a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india");
		 
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'ta-results')]")));
		 
		driver.findElement(By.xpath("(//*[contains(@class,'ta-results')]/button)[2]")).click();
		
		 Thread.sleep(3000);

		WebElement element = driver.findElement(By.cssSelector(".action__submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		element.click();
		Thread.sleep(3000);
		String name= driver.findElement(By.xpath("//*[@class='hero-primary']")).getAttribute("textContent");
		Assert.assertTrue(name.equals(" Thankyou for the order. ")); 
		 
			 
		 }

	}


