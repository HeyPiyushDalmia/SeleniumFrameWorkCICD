package PiyushDalmia.pageobjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import piyushDalmia.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	
	
	public boolean verifyCartProducts(String productName)
	{
		boolean match = cartProducts.stream().anyMatch(piece->piece.getText().equals(productName));
		return match;
	}
	
	public BillingDetails getCheckOut()
	{
		checkOut.click();
		BillingDetails billingDetails = new BillingDetails(driver);
		return billingDetails;
	}
	
	
	
	
}
