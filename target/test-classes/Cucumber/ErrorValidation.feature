
@tag
Feature: Error Validation
  I want to use this template for my feature file


   @tag2
  Scenario Outline: Nagative test on login page
    Given I landed on Ecommerce page
    When Login with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

   Examples: 
      | name 						 | password 			| 
      | mamsam@gmail.com | Mamatha@23     |
     