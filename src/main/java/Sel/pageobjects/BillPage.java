package Sel.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sel.AbstractComponents.AbstractComponent;

public class BillPage extends AbstractComponent {
	WebDriver driver;
	public BillPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By country=By.cssSelector(".form-group .text-validated");
	By clist=By.cssSelector(".ta-results");

	@FindBy(css=".ta-results .ta-item:nth-child(3)")
	WebElement dc;
	@FindBy(className="action__submit")
	WebElement submit;
	
	public void countrySelect(String Cname) {
		Actions a=new Actions(driver);
		
		a.sendKeys(driver.findElement(country), Cname).build().perform();
		waitForElementToAppear(clist);
		a.moveToElement(dc).click().build().perform();
	}
	
	public ConfirmationPage submit() {
		submit.click();
		ConfirmationPage cp1=new ConfirmationPage(driver);
		return cp1;
	}
	
	
	
	
	
	

}
