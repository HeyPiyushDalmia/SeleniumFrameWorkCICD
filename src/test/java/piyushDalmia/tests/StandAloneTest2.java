package piyushDalmia.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
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
import PiyushDalmia.pageobjects.OrderPage;
import PiyushDalmia.pageobjects.ProductCatalogue;
import piyushDalmia.TestComponents.BaseTest;

public class StandAloneTest2 extends BaseTest {

	@org.testng.annotations.Test(dataProvider = "getData", groups= {"Purchase"})
	//public void orderCreation(String emailid, String password, String productName) throws IOException {
	public void orderCreation(HashMap<String,String> input) throws IOException {
		ProductCatalogue productCatalogue = landingPage.loginAuth(input.get("email"), input.get("password"));
		productCatalogue.getProductList();
		productCatalogue.getProductToCart(input.get("productName"));
		CartPage cartPage = productCatalogue.goToMyCart();
		boolean match = cartPage.verifyCartProducts(input.get("productName"));
		Assert.assertTrue(match);
		BillingDetails billingDetails = cartPage.getCheckOut();
		billingDetails.countryInput("Ind");
		billingDetails.selectCountry();
		OrderConfirmationPage orderConfirmationPage = billingDetails.placeOrder();
		String confirmMessage = orderConfirmationPage.getOrderConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@org.testng.annotations.Test(dependsOnMethods = { "orderCreation" })
	public void oderHistoryTest() {
		// Verify the order history of ZARA coat 3

		ProductCatalogue productCatalogue = landingPage.loginAuth("piyushdalmia@gmail.com", "Piyush123@");
		OrderPage orderPage = productCatalogue.goToMyOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay("ZARA COAT 3"));
	}



	@org.testng.annotations.DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//piyushDalmia//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) },{ data.get(1) } };
		
	}
	
	
	
//	@org.testng.annotations.DataProvider
//	public Object[][] getData() {
//		return new Object[][] { { "rajeshdalmia@gmail.com", "Rajesh@123", "ZARA COAT 3" },
//				{ "piyushdalmia@gmail.com", "Piyush123@", "ZARA COAT 3" } };
	
	
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "rajeshdalmia@gmail.com");
//	map.put("password", "Rajesh@123");
//	map.put("productName", "ZARA COAT 3");
//	
//	HashMap<String,String> map2 = new HashMap<String,String>();
//	map2.put("email", "piyushdalmia@gmail.com");
//	map2.put("password", "Piyush123@");
//	map2.put("productName", "ZARA COAT 3");
//	
//	
//	return new Object[][] { { map },{ map2 } };
//	
//	}
	
	
	
	
	
}
