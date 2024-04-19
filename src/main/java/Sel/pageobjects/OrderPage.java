package Sel.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;

public class OrderPage {
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> itemNames;
	
	
	public Boolean orderList(String itemName) {
		Boolean match=itemNames.stream().anyMatch(ct->ct.getText().equalsIgnoreCase(itemName));
		return match;
	}
	

}
