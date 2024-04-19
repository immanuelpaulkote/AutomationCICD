package Sel.Tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Sel.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
	
		String productname="ZARA COAT 3";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("immy@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Immy@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> items=driver.findElements(By.cssSelector(".mb-3"));
		WebElement itm=items.stream().filter(item->item.findElement(By.xpath("//h5/b")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		itm.findElement(By.xpath("//div/button[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cart=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match=cart.stream().anyMatch(ct->ct.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector("[class*='subtotal'] button")).click();
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector(".form-group .text-validated")), "ind").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		a.moveToElement(driver.findElement(By.cssSelector(".ta-results .ta-item:nth-child(3)"))).click().build().perform();
		driver.findElement(By.className("action__submit")).click();
		String OId=driver.findElement(By.cssSelector(".em-spacer-1 .ng-star-inserted")).getText();
		System.out.println(OId);
		driver.close();
		
		
	}

}
