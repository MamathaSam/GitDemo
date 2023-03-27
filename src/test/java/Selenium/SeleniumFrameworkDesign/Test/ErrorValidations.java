package Selenium.SeleniumFrameworkDesign.Test;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.Test;


import Selenium.SeleniumFrameworkDesign.TestComponents.BaseTest;
import Selenium.SeleniumFrameworkDesign.pageobjects.CartPage1;
import Selenium.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest{

	 @Test(groups= {"ErrorHandiling"})
	   public void logInPageErrorValidation() throws InterruptedException, IOException   {
		
		// Validating test with incorrect login Credentials 
		landingpage.loginApplication("mamsam@gmail.com", "Mamatha@@123");
		String actualMsg=landingpage.getErrorText();
		Assert.assertEquals("Incorrect email or password.", actualMsg);
	}
	 
	 @Test(retryAnalyzer=Selenium.SeleniumFrameworkDesign.TestComponents.Retry.class)
	 public void productPageErrorvalidation() throws InterruptedException, IOException   {
			// TODO Auto-generated method stub
			String iteamName = "ZARA COAT 3";
			ProductCatalogue productCatalogue=landingpage.loginApplication("mamsam@gmail.com", "Mamatha@123");
			productCatalogue.getProductList();
			CartPage1 cartPage=productCatalogue.addProductToCart(iteamName);
			cartPage.clickOnCart();
			boolean match = cartPage.getTheCartItems("ZARA COAT 33");
			Assert.assertFalse(match);
		}


}
