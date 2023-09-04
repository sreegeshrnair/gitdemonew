package MainAutoProject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MainAutoProject.pageobjects.ConfirmationPage;
import MainAutoProject.pageobjects.LandingPage;
import MainAutoProject.pageobjects.MyCartPage;
import MainAutoProject.pageobjects.OrdersPage;
import MainAutoProject.pageobjects.PaymentPage;
import MainAutoProject.pageobjects.ProductCatalogue;
import MainAutoProjects.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{
	
	String productName = "ADIDAS ORIGINAL"; //Defining at class level
	
	@Test(dataProvider = "getData", groups = {"purchase"})
	public void SubmitOrde(HashMap<String, String> input) throws IOException, InterruptedException
	 {
//		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.Loginapplication(input.get("email"), input.get("password"));
		productCatalogue.addproducttocart(input.get("productName"));
		MyCartPage mycartpage = productCatalogue.gotocart();
		Boolean Match = mycartpage.cartitemmatch(input.get("productName"));
		Assert.assertTrue(Match);
		PaymentPage paymentpage= mycartpage.checkout();
		paymentpage.selectcountry("Aus");
		ConfirmationPage confirmationpage= paymentpage.placeorder();
		String Actualmessage = confirmationpage.confirmmessage();
		String Expected = "Thankyou for the order.";
		Assert.assertTrue(Actualmessage.equalsIgnoreCase(Expected));		
	}
	
	@Test(dependsOnMethods = {"SubmitOrde"})
	public void orderhistory() 
	{
		ProductCatalogue productCatalogue = landingPage.Loginapplication("sreegeshr@gmail.com", "@Attra2032");
		OrdersPage orderspage = productCatalogue.gotoorderspage();
		Boolean Match = orderspage.verifyorderitems(productName);
		Assert.assertTrue(Match);
	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][] {{"sreegeshr@gmail.com", "@Attra2032", "ZARA COAT 3"}, {"sree1985@gmail.com", "@Attra2031", "ADIDAS ORIGINAL"}};
//	}
	
	@DataProvider
	public Object[][] getData() // Using HashMap
	{
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("email", "sreegeshr@gmail.com");
		map.put("password","@Attra2032" );
		map.put("productName", "ZARA COAT 3");
		
		
		HashMap<String, String> map1= new HashMap<String, String>();
		
		map1.put("email", "sree1985@gmail.com");
		map1.put("password","@Attra2031" );
		map1.put("productName", "ADIDAS ORIGINAL");
		return new Object[][] {{map}, {map1}};
	}
	//Utility for taking screenshot
	public String screenshotutil(String testCaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	
	

}
