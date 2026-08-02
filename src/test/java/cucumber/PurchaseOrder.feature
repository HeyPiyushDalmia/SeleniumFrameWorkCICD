@tag
Feature: Purchase the order from the ECommerce Page 
	I want to use this template for my feature file

Background:
Given  I landed on Ecommerce Page

@Regression
Scenario: Postive Test of Submitting the order 
Given Logged in with email <email> and password <password>
When  I add product <productName> to Cart
And Checkout <productName> and submit the order
Then  "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

Examples:
	| email 				| password  | productName |
	| piyushdalmia@gmail.com| Piyush123@| ZARA COAT 3 |