@SauceDemoTesting
Feature: SauceDemo testing
	
	@HomePage
	Scenario: Sucessfully navigate to homepage
		Given User navigates to homepage
		
	@InvalidLogin
	Scenario Outline: Login with Invalid credentials
		When User enters Username as "<Username>" and Password as "<Password>"
		And User submit the login Credentials
		Then User not able to login sucessfully
		
		Examples: 
			| Username | Password |
			| user		 | password |
			| user		 |					|
			|					 | password |
			|  				 |					|
		
	@ValidLogin
	Scenario Outline: Sucessful Log in to site
    When User enters Username as "<Username>" and Password as "<Password>"
    And User submit the login Credentials
    Then User sucessfully logged in
    
    Examples: 
			| Username 			| Password 		 |
			| standard_user | secret_sauce |
	
	@AddingToCart
	Scenario: Sucessful adding product to cart
		When User navigate to filter icon
		And User filter the Price as high to low and see the result
		And User add any three product
		Then User navigate to cart icon and visit to cart page
		
	@ProceedToCheckout
	Scenario Outline: Sucessful checking out of product
		When User Checkout the Items
		And User enters FirstName as "<FirstName>", LastName as "<LastName>" and ZipCode as "<ZipCode>"
		And User Continue and proceed to Overview page
		Then User navigates to Finish and checkout completed
		
		Examples: 
		| FirstName | LastName | ZipCode |
		| Standard  | User		 | 96110 	 |
		
		