package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class AddingToCart {

	public WebDriver driver;
	public ProceedToCheckout ptc;
	
	public AddingToCart(ProceedToCheckout ptc) {
		this.ptc = ptc;
	}
	
	public AddingToCart(WebDriver driver) {
		this.driver = driver;
	}
	
	By filterIcon = By.className("product_sort_container");
	By filterOption = By.xpath("//option[text()=\"Price (high to low)\"]");
	By itemPrice = By.className("inventory_item_price");
	By cartItem1 = By.xpath("//button[@id = 'add-to-cart-sauce-labs-backpack']");
	By cartItem2 = By.xpath("//button[@id = 'add-to-cart-sauce-labs-fleece-jacket']");
	By cartItem3 = By.xpath("//button[@id = 'add-to-cart-sauce-labs-bolt-t-shirt']");
	By navigateToCart = By.xpath("//div[@id=\"shopping_cart_container\"]");
	By yourCart = By.xpath("//span[contains(@class, 'title')]");
	By cartItem = By.className("inventory_item_name");

	//Action Methods
	public void clickFilterIcon() {
		//User click on filter Icon
		driver.findElement(filterIcon).click();
	}
	
	public void clickFilterOption() {
		//Validation of sorted list
		
		//List before the filter
		List<WebElement> beforeFilterPrice = driver.findElements(itemPrice);
		
		//Removing $ sign and converting it into double
		List<Double> beforeFilterPriceList = new ArrayList<Double>();
		
		for(WebElement p : beforeFilterPrice) {
			beforeFilterPriceList.add(Double.valueOf(p.getText().replace( "$", "")));
		}
		//filtering the price from filter Option
		driver.findElement(filterOption).click();
		
		//List after the filter
		List<WebElement> afterFilterPrice = driver.findElements(itemPrice);
		
		//Removing $ sign and converting it into double
		List<Double> afterFilterPriceList = new ArrayList<Double>();
		
		for(WebElement p : afterFilterPrice) {
			afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}
		//sorting the beforeFilterPriceList and sorting will be in ascending order
		Collections.sort(beforeFilterPriceList);
		
		//reversing the list into ascending to descending order
		Collections.reverse(beforeFilterPriceList);
		Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
		
		System.out.println("The Items are Sorted correctly");
	}
	
	public void addToCartItem() {
		//Clicking the cart Items
		driver.findElement(cartItem1).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(cartItem2).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(cartItem3).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void clickCartIcon() {
		//Validating the User navigates to your cart 
		driver.findElement(navigateToCart).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ActualResult = driver.findElement(yourCart).getText();
		Assert.assertEquals(ActualResult, "YOUR CART");
		System.out.println("Items are added to the cart Sucessfully");
		
	}
	
}
