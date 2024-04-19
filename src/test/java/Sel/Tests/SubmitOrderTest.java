package Sel.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.Test;

import Sel.TestComponents.BaseTest;
import Sel.pageobjects.BillPage;
import Sel.pageobjects.CartPage;
import Sel.pageobjects.ConfirmationPage;
import Sel.pageobjects.LandingPage;
import Sel.pageobjects.OrderPage;
import Sel.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	String productname="ZARA COAT 3";

//3	@Test(dataProvider="getData",groups={"Purchase"})
//	public void submitOrder(String email,String password, String productname) throws IOException
//	{
//		
//		ProductCatalogue pg=lp.loginApp(email,password);
//		
//		List<WebElement> items=pg.getItemList();	
//		pg.addProductToCart(productname);
//		CartPage cp=pg.goToCart();
//		
//		Assert.assertTrue(cp.cartList(productname));
//		BillPage bp=cp.checkOut();
//		
//		bp.countrySelect("ind");
//		ConfirmationPage cp1=bp.submit();
//		
//		cp1.getOId();
//		}
//	
	@Test(dataProvider="getData",groups={"Purchase"})
public void submitOrder(HashMap<String,String> input) throws IOException
{
	
	ProductCatalogue pg=lp.loginApp(input.get("email"),input.get("password"));
	
	List<WebElement> items=pg.getItemList();	
	pg.addProductToCart(input.get("product"));
	CartPage cp=pg.goToCart();
	
	Assert.assertTrue(cp.cartList(input.get("product")));
	BillPage bp=cp.checkOut();
	
	bp.countrySelect("ind");
	ConfirmationPage cp1=bp.submit();
	
	cp1.getOId();
	}
	
@Test(dependsOnMethods= {"submitOrder"})
public void OrderHistory() {
	ProductCatalogue pg=lp.loginApp("immy@gmail.com", "Immy@123");
	OrderPage op=pg.goToOrder();
	Assert.assertTrue(op.orderList(productname));
	}

@DataProvider
public Object[][] getData() throws IOException {
	//return new Object[][] {{"immy@gmail.com","Immy@123","ZARA COAT 3"},{"immy@gmail.com","Immy@123","ADIDAS ORIGINAL"}};
	
	List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Sel//Data//PurchaseOrder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
	
}


}
