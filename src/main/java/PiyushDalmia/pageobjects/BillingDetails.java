package PiyushDalmia.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import piyushDalmia.AbstractComponents.AbstractComponents;

public class BillingDetails extends AbstractComponents{
	WebDriver driver;
	public BillingDetails(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-group input")
	WebElement countryInputs;
	
	By autoSuggestCountry = By.cssSelector(".list-group");
	
	@FindBy(css=".list-group button")
	List<WebElement> countries;
	
	@FindBy(css=".actions a")
	WebElement orderPlace;
	
	public void countryInput(String inputCountry)
	{
		countryInputs.sendKeys(inputCountry);
		waitForElementToAppear(autoSuggestCountry );
	}
	
	public void selectCountry()
	{

		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase("India")) {
				country.click();
				break;
			}
		}
	}
	
 public OrderConfirmationPage placeOrder()
 {
	 orderPlace.click();
	 OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
	 return orderConfirmationPage;
 }

}
