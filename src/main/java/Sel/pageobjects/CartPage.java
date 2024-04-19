package Sel.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> items;
	@FindBy(css="[class*='subtotal'] button")
	WebElement submit;
	
	public Boolean cartList(String itemName) {
		Boolean match=items.stream().anyMatch(ct->ct.getText().equalsIgnoreCase(itemName));
		return match;
	}
	
	public BillPage checkOut() {
		submit.click();
		BillPage bp=new BillPage(driver);
		return bp;
		
	}
	
	

}
