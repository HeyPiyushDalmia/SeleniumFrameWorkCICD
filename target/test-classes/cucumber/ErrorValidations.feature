@tag
Feature: Errror Validations on the login pgae 
	 

@ErrorValidations
Scenario: Incorrect Deatils while logging 
Given  I landed on Ecommerce Page 
When Logged in with email <email> and password <password>
Then  "Incorrect email or password." message is displayed

Examples:
	| email 				| password  | 
	| piyushdalmia@gmail.com| Piyush123@1|