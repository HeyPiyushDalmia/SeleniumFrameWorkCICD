package PiyushDalmia.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import piyushDalmia.AbstractComponents.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents {
	
	WebDriver driver;
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="h1")
	WebElement orderMessage;
	
	
	public String getOrderConfirmationMessage()
	{
		String message = orderMessage.getText();
		System.out.println(message);
		return message;
	}

}
