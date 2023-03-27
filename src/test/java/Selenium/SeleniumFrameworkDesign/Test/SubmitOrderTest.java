package Selenium.SeleniumFrameworkDesign.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Selenium.SeleniumFrameworkDesign.TestComponents.BaseTest;
import Selenium.SeleniumFrameworkDesign.pageobjects.CartPage1;
import Selenium.SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import Selenium.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import Selenium.SeleniumFrameworkDesign.pageobjects.OrderPage;
import Selenium.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

	String iteamName = "ZARA COAT 3";

	@Test(dataProvider= "getData",groups="purchase")
	   public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException   {
		// TODO Auto-generated method stub
		
		ProductCatalogue productCatalogue=landingpage.loginApplication(input.get("Email"), input.get("Pw"));
		productCatalogue.getProductList();
		CartPage1 cartPage=productCatalogue.addProductToCart(iteamName);
		cartPage.clickOnCart();
		boolean match = cartPage.getTheCartItems(iteamName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.clickOnCheckOut();
		checkoutPage.selectCountry();
		ConfirmationPage confirmationPage =checkoutPage.clickOnPlaceOrder();
		Thread.sleep(1000);
		String name = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(name.equals(" Thankyou for the order. "));
	}
	 
	 @Test (dependsOnMethods = {"submitOrder"})
	 public void orderHistory() throws InterruptedException {
			ProductCatalogue productCatalogue=landingpage.loginApplication("mamsam@gmail.com", "Mamatha@123");
			OrderPage orderPage=productCatalogue.clickOnOrders();
			
			Assert.assertTrue(orderPage.getTheProductName(iteamName));
	 }
	 
	 
	 @DataProvider
	  public Object[][] getData() throws IOException {
		 List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Selenium//SeleniumFrameworkDesign//Data//PurchaseOrder.json");
		
		 return new  Object[][] {{data.get(0)} , {data.get(1)}};
		  
		  
	  }
	 
//	 return new  Object[][] {{"mamsam@gmail.com","Mamatha@123"} , {"shetty@gmail.com","Iamking@000"}};
//	  
//	 HashMap<String , String> map= new HashMap<String,String>();
//	 map.put("Email", "mamsam@gmail.com");
//	 map.put("Pw", "Mamatha@123");
//		 
//	 HashMap<String , String> map1= new HashMap<String,String>();
//	 map1.put("Email", "shetty@gmail.com");
//	 map1.put("Pw", "Iamking@000");
		 

}
