@tag
Feature: Purchase the order from ecommerce application
  I want to use this template for my feature file

	Background:
	Given : I landed on ecommerce page
	
		
  @tag2
  Scenario Outline: Positive test o submitting order
    Given Login with username <name> and password <password>
    When I add product to the cart <productName>
 		And Checkout Productname <productName> and submit the order
    Then " Thankyou for the order. " message is displayed on the confirmation page

    Examples: 
      | name 						 | password 			 | productName |
      | mamsam@gmail.com | Mamatha@123     | ZARA COAT 3 |
     