package PiyushDalmia.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import piyushDalmia.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	// List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));

//	@FindBy(css = ".ng-animating")
//	WebElement spinner;

	
	By spinner = By.cssSelector(".ng-animating");
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toasterMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(item -> item.findElement(By.tagName("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}
	
	public CartPage getProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toasterMessage);
		waitForElementToDisappear(spinner);
		  return new CartPage(driver);
				
	}

}