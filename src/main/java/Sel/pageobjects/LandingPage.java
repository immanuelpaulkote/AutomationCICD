package Sel.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sel.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	public LandingPage(WebDriver driver) //constructor executes first in code
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement userPass;
	@FindBy(id="login")
	WebElement login;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public ProductCatalogue loginApp(String email,String password)
	{
		userEmail.sendKeys(email);
		userPass.sendKeys(password);
		login.click();
		ProductCatalogue pg=new ProductCatalogue(driver);
		return pg;
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	

}
