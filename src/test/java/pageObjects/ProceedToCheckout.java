package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProceedToCheckout extends AddingToCart {

	public ProceedToCheckout(WebDriver driver) {
		super(driver);
	}

	By checkout = By.xpath("//button[@id='checkout']");
	By yourInformationPage = By.xpath("//span[contains(@class, 'title')]");
	By firstName = By.xpath("//input[@id='first-name']");
	By lastName = By.xpath("//input[@id='last-name']");
	By postalCode = By.xpath("//input[@id='postal-code']");
	By continueButton = By.xpath("//input[@id='continue']");
	By overviewItem = By.className("inventory_item_name");
	By overviewPage = By.xpath("//span[contains(@class, 'title')]");
	By finishButton = By.xpath("//button[@id='finish']");
	By completePage = By.xpath("//span[contains(@class, 'title')]");
	By error = By.xpath("//h3[@data-test=\"error\"]");

	public void clickProceedButton() {
		// Click on checkout button and validating user is on checkout: your information
		// page
		driver.findElement(checkout).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualResult = driver.findElement(yourInformationPage).getText();
		Assert.assertEquals(ActualResult, "CHECKOUT: YOUR INFORMATION");
		System.out.println("User at Checkout: your information");
	}

	public void setFirstName(String fname) {
		// Entering first name
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		// Entering last name
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(lname);
	}

	public void setpostalCode(String postalcode) {
		// Entering postal code
		driver.findElement(postalCode).clear();
		driver.findElement(postalCode).sendKeys(postalcode);
	}

	public void clickContinue() {
		// Clicking on continue button
		driver.findElement(continueButton).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void navigateToOverviewPage() {

		// Validating user is on checkout: overview page
		String ActualResult = driver.findElement(overviewPage).getText();
		Assert.assertEquals(ActualResult, "CHECKOUT: OVERVIEW");

		// Validating cart items on overview page are same as the ones we selected
		// List of Cart Items at Your Cart page
		List<WebElement> beforeCartItems = driver.findElements(cartItem);

		// List of Cart Items at Overview page
		List<WebElement> afterCartItems = driver.findElements(overviewItem);

		// Comapring the Cart Items from cart page and overview page
		Assert.assertEquals(beforeCartItems, afterCartItems);

		System.out.println("Cart items on overview page are same as the ones we selected");
	}

	public void checkoutComplete() {
		// Clicking on the finish button and validating user is on checkout: complete!
		// page
		driver.findElement(finishButton).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualResult = driver.findElement(completePage).getText();
		Assert.assertEquals(ActualResult, "CHECKOUT: COMPLETE!");
		driver.quit();

	}

	public void error() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (firstName.equals(null) & lastName.equals(null) & postalCode.equals(null)) {
			String ActualResult = driver.findElement(error).getText();
			Assert.assertEquals(ActualResult,"Error: First Name is required");
			System.out.println("User not able to login sucessfully");
		}
		else if (firstName.equals(firstName) & lastName.equals(lastName) & postalCode.equals(null)) {
			String ActualResult = driver.findElement(error).getText();
			Assert.assertEquals(ActualResult,"Error: Postal Code is required");
			System.out.println("User not able to login sucessfully");
		}
		else if (firstName.equals(null) & lastName.equals(lastName) & postalCode.equals(postalCode)) {
			String ActualResult = driver.findElement(error).getText();
			Assert.assertEquals(ActualResult,"Error: First Name is required");
			System.out.println("Error: First Name is required");
		}
		else {
			String ActualResult = driver.findElement(error).getText();
			Assert.assertEquals(ActualResult,"Error: Last Name is required");
			System.out.println("User not able to login sucessfully");
		}
	}
}
