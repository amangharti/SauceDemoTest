package pageObjects;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//input[@id=\"user-name\"]");
	By password = By.xpath("//input[@id=\"password\"]");
	By loginButton = By.xpath("//input[@id=\"login-button\"]");
	By homepage = By.className("peek");
	By error = By.xpath("//h3[@data-test=\"error\"]");

	// Action Methods
	public void setUserName(String uname) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void setPassword(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void homepage() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement expectedOutput = driver.findElement(homepage);
		Assert.assertEquals(true, expectedOutput.isDisplayed());
		System.out.println("Sucessfully logged in");
	}

	public void error() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(username.equals(username) & password.equals(password)) {
			String ActualResult = driver.findElement(error).getText();
			Assert.assertEquals(ActualResult, "Epic sadface: Username and password do not match any user in this service");
			System.out.println("User not able to login sucessfully");
			}
		else if(username.equals(username)) {
			String ActualResult = driver.findElement(error).getText();
			Assert.assertEquals(ActualResult, "Epic sadface: Password is required");
			System.out.println("User not able to login sucessfully");
		}
		else if(password.equals(password)) {
			String ActualResult = driver.findElement(error).getText();
			Assert.assertEquals(ActualResult, "Epic sadface: Username is required");
			System.out.println("User not able to login sucessfully");
		}
		else {
			String ActualResult = driver.findElement(error).getText();
			Assert.assertEquals(ActualResult, "Epic sadface: Username is required");
			System.out.println("User not able to login sucessfully");
		}
	}
}
