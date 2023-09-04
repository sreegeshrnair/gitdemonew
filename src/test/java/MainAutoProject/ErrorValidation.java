package MainAutoProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
import MainAutoProject.pageobjects.PaymentPage;
import MainAutoProject.pageobjects.ProductCatalogue;
import MainAutoProjects.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest{

	@Test(groups = {"Errorhandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException
	 {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.Loginapplication("abcd@gmail.com", "@Attra2032");	
		AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrormessage());
	}
	

	@Test
	public void producterrorvalidation() throws IOException, InterruptedException
	 {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.Loginapplication("sree1985@gmail.com", "@Attra2031");
		productCatalogue.addproducttocart(productName);
		MyCartPage mycartpage = productCatalogue.gotocart();
		Boolean Match = mycartpage.cartitemmatch("ZARA COAT 2");
		Assert.assertFalse(Match);
	
	}

}
