package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddingToCart;
import pageObjects.LoginPage;
import pageObjects.ProceedToCheckout;

public class stepDefinition {
	
	public static WebDriver driver;
	public LoginPage lp;
	public AddingToCart atc;
	public ProceedToCheckout ptc;
	
	

	@Given("User navigates to homepage")
	public void user_navigates_to_homepage() {
		driver=browserconfig.BrowserConfig.open("chrome");
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

    @When("^User enters Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void user_enters_username_as_and_password_as(String userName, String passWord){
    	lp = new LoginPage(driver);
    	lp.setUserName(userName);
		lp.setPassword(passWord);
    }

    @When("User navigate to filter icon")
    public void user_navigate_to_filter_icon() {
    	atc = new AddingToCart(driver);
    	atc.clickFilterIcon();
    }

    @When("User Checkout the Items")
    public void user_checkout_the_items() {
    	ptc = new ProceedToCheckout(driver);
    	ptc.clickProceedButton();
    }
    
    @Then("User not able to login sucessfully")
    public void user_not_able_to_login_sucessfully() {
    	lp.error();
    }

    @Then("User sucessfully logged in")
    public void user_sucessfully_logged_in()  {
		lp.homepage();
    }
    
    @Then("User navigate to cart icon and visit to cart page")
    public void user_navigate_to_cart_icon_and_visit_to_cart_page() {
    	atc.clickCartIcon();
    }
  
    @Then("User navigates to Finish and checkout completed")
    public void user_navigates_to_finish_and_checkout_completed() {
    	ptc.checkoutComplete();
    }

    @And("User submit the login Credentials")
    public void user_submit_the_login_credentials(){
    	lp.clickLogin(); 
    }

    @And("User filter the Price as high to low and see the result")
    public void user_filter_the_price_as_high_to_low_and_see_the_result() {
    	atc.clickFilterOption();
    }

    @And("User add any three product")
    public void user_add_any_three_product() {
    	atc.addToCartItem();
    }

    @And("^User enters FirstName as \"([^\"]*)\", LastName as \"([^\"]*)\" and ZipCode as \"([^\"]*)\"$")
    public void user_enters_first_name_as_last_name_as_and_zip_code_as(String firstname, String lastname, String postalcode) {
    	ptc.setFirstName(firstname);
		ptc.setLastName(lastname);
		ptc.setpostalCode(postalcode);
    }

    @And("User Continue and proceed to Overview page")
    public void user_continue_and_proceed_to_overview_page() {
    	ptc.clickContinue();
    	ptc.navigateToOverviewPage();
    }
    
    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
    	if(scenario.isFailed()) {
    		TakesScreenshot ts = (TakesScreenshot) driver;
    		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
    		scenario.attach(src,"image/png", "screenshot");
    	}
    	
    	/*if (scenario.isFailed()) {
          final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
          scenario.attach(screenshot, "image/png", "src"); 
        }*/
    }
}
