package piyushDalmia.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PiyushDalmia.pageobjects.CartPage;
import PiyushDalmia.pageobjects.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement myOrders;
	
	
	public void waitForElementToAppear(By findBy)
	{
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy)
	{
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	
	public void waitForElementToDisappear(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	
	public CartPage goToMyCart()
	{
		
		cart.click();
		return new CartPage(driver);
	}
	
	
	public OrderPage goToMyOrdersPage()
	{
		myOrders.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}

}
