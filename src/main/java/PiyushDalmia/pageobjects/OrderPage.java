package PiyushDalmia.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import piyushDalmia.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {

	WebDriver driver;

	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="tbody tr td:nth-child(3)")
	List<WebElement> orderedProductName;
	
//	@FindBy(css=".totalRow button")
//	WebElement checkOut;
	
	
	
	public boolean verifyOrderDisplay(String productName)
	{
		boolean match = orderedProductName.stream().anyMatch(piece->piece.getText().equals(productName));
		System.out.print(match);
		return match;
	}
	

	
	
}