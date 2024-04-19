package Sel.Tests;

import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Sel.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest{

@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
public void submitOrder() throws IOException
{
	
	lp.loginApp("immy@gmail.com", "Immy@153");
	Assert.assertEquals("Incorrect email or password..", lp.getErrorMessage()); 
	}		

}
