package PiyushDalmia.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import piyushDalmia.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement loginErrorMessage;



	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	public String getLoginErrorMessage()
	{
		waitForWebElementToAppear(loginErrorMessage);
		return loginErrorMessage.getText();
	}

	
	public ProductCatalogue loginAuth(String email, String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
}
