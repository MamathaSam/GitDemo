package Selenium.SeleniumFrameworkDesign.StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import Selenium.SeleniumFrameworkDesign.TestComponents.BaseTest;
import Selenium.SeleniumFrameworkDesign.pageobjects.CartPage1;
import Selenium.SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import Selenium.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import Selenium.SeleniumFrameworkDesign.pageobjects.Landingpage;
import Selenium.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



// * USE Tidy gerkin plugin to generate methods *//
public class StepdefinitionImplimentation extends BaseTest {
	public Landingpage landingpage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	CartPage1 cartPage;
	
    @Given("I landed on ecommerce page")
	public void i_landed_on_ecommerce_page() throws InterruptedException, IOException {
		
		landingpage=lunchApplication();
	}
	
	  @Given ("^Login with username (.+) and password (.+)$")
	  public void Login_with_username_and_passwwword(String Username , String Password) {
		   productCatalogue=landingpage.loginApplication(Username, Password);
			
	  }
	  
	  @When("^I add product to the cart (.+)$")
	  public void I_add_product_to_the_cart(String ProductName) {
		  productCatalogue.getProductList();
			 cartPage=productCatalogue.addProductToCart(ProductName);
	  }
	  
	  @And("^Checkout Productname (.+) and submit the order$")
	  public void checkout_Submit_Order(String ProductName) throws InterruptedException {
		  cartPage.clickOnCart();
			boolean match = cartPage.getTheCartItems(ProductName);
			Assert.assertTrue(match);
			CheckoutPage checkoutPage=cartPage.clickOnCheckOut();
			checkoutPage.selectCountry();
			confirmationPage =checkoutPage.clickOnPlaceOrder();
			Thread.sleep(1000); 
	  }
	  @Then("^\"([^\"]*)\" message is displayedon confirmatio page$")
	  public void message_displayed_on_confirmationPage(String string) {
		  
		  String name = confirmationPage.getConfirmationMessage();
			Assert.assertTrue(name.equals(string));
		   
	  }
	  @Then("^\"([^\"]*)\" message is displayed$")
	    public void something_message_is_displayed(String strArg1) throws Throwable {
		  Assert.assertEquals(strArg1, landingpage.getErrorText());

	    }

}
