package piyushDalmia.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://rahulshettyacademy.com/client/#/auth/login");
String emailid = "piyushdalmia@gmail.com";
String password = "Piyush123@";

String productName = "ZARA COAT 3";
driver.findElement(By.id("userEmail")).sendKeys(emailid);
driver.findElement(By.id("userPassword")).sendKeys(password);
driver.findElement(By.id("login")).click();
List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));

	WebElement product = items.stream().filter(item->item.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("#toast-container")));
		 driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		 
		 List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		 
		 	boolean match = cartProducts.stream().anyMatch(piece->piece.getText().equals(productName));
		 	
		 	Assert.assertTrue(match);
		 	driver.findElement(By.cssSelector(".totalRow button")).click();
		 	
		 	
		 	driver.findElement(By.cssSelector(".form-group input")).sendKeys("Ind");
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group")));
			List<WebElement> options = driver.findElements(By.cssSelector(".list-group button"));

			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase("India")) {
					option.click();
					break;
				}
			}
			
			driver.findElement(By.cssSelector(".actions a")).click();
			
			String confirmMessage = driver.findElement(By.tagName("h1")).getText();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE ORDER"));
			
		
	}

}
