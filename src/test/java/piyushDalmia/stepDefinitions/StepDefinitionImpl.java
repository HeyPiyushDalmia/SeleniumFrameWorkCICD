package piyushDalmia.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import PiyushDalmia.pageobjects.BillingDetails;
import PiyushDalmia.pageobjects.CartPage;
import PiyushDalmia.pageobjects.LandingPage;
import PiyushDalmia.pageobjects.OrderConfirmationPage;
import PiyushDalmia.pageobjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piyushDalmia.TestComponents.BaseTest;

public class StepDefinitionImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public BillingDetails billingDetails;
	public OrderConfirmationPage orderConfirmationPage;

	@Given("I landed on Ecommerce Page")
	public void i_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with email (.+) and password (.+)$")
	public void logged_in_with_email_and_password(String email, String password) {
		productCatalogue = landingPage.loginAuth(email, password);
	}

	@When("^I add product (.+) to Cart$")
	public void add_product_to_cart(String productName) {
		productCatalogue.getProductList();
		productCatalogue.getProductToCart(productName);
	}

	@And("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		cartPage = productCatalogue.goToMyCart();
		boolean match = cartPage.verifyCartProducts(productName);
		Assert.assertTrue(match);
		billingDetails = cartPage.getCheckOut();
		billingDetails.countryInput("Ind");
		billingDetails.selectCountry();
		orderConfirmationPage = billingDetails.placeOrder();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void displayed_Confirmation_Message(String string) {
		String confirmMessage = orderConfirmationPage.getOrderConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	

	@Then("{string} message is displayed")
	public void displayed_login_Error(String stringArgs2) {
		Assert.assertEquals(stringArgs2, landingPage.getLoginErrorMessage());
		driver.close();
	}
}
