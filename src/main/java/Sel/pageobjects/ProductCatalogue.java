package Sel.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sel.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) //constructor executes first in code
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> items;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By itemsBy=By.cssSelector(".mb-3");
	By addToCart=By.xpath("//div/button[2]");
	By toastMsg=By.id("toast-container");
	
	public List<WebElement> getItemList()
	{
		waitForElementToAppear(itemsBy);
		return items;
	}
	
	public WebElement getItemByName(String itemName) {
		WebElement itm=getItemList().stream().filter(item->item.findElement(By.xpath("//h5/b")).getText().equalsIgnoreCase(itemName)).findFirst().orElse(null);	
		return itm;
	}
	
	public void addProductToCart(String itemName)
	{
		WebElement itm=getItemByName(itemName);
		itm.findElement(addToCart).click();
		waitForElementToAppear(toastMsg);
		waitForElementToDisappear(spinner);
	}
	
	
	

}
