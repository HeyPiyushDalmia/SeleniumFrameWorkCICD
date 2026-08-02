package piyushDalmia.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import PiyushDalmia.pageobjects.BillingDetails;
import PiyushDalmia.pageobjects.CartPage;
import PiyushDalmia.pageobjects.LandingPage;
import PiyushDalmia.pageobjects.OrderConfirmationPage;
import PiyushDalmia.pageobjects.ProductCatalogue;
import piyushDalmia.TestComponents.BaseTest;
import piyushDalmia.TestComponents.Retry;

public class ErrorValidations extends BaseTest {
	
	@org.testng.annotations.Test(retryAnalyzer = Retry.class)
	public void validEmailIdorPassword() throws IOException{
		
		String emailid = "piyushdalmia@gmail.com";
		String password = "Piyush123@1";
		landingPage.goTo();
		landingPage.loginAuth(emailid, password);
		Assert.assertEquals("Incorrect email or password.", landingPage.getLoginErrorMessage());
		

	}
	
	@org.testng.annotations.Test
	public void verifyProduct() throws IOException{
		

		String emailid = "piyushdalmia@gmail.com";
		String password = "Piyush123@";
		String productName = "ZARA COAT 3";
		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginAuth(emailid, password);

		productCatalogue.getProductList();
		productCatalogue.getProductToCart(productName);
		productCatalogue.goToMyCart();
		CartPage cartPage = new CartPage(driver);
		boolean match = cartPage.verifyCartProducts("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}


}
