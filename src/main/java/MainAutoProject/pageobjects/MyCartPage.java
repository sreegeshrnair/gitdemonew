package MainAutoProject.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MainAutoProject.Reusuable.ReusuableComponents;

public class MyCartPage extends ReusuableComponents{		
		WebDriver driver;
		
		//Creating Constructor
		//Constructor has same name as class name
		//First method to execute in class
		public MyCartPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(css = ".cartSection h3")
		List<WebElement> cartitems;
		
		@FindBy(css = ".subtotal .btn")
		WebElement Checkout;
		
		public Boolean cartitemmatch(String productName)
		{
			Boolean Match = cartitems.stream().anyMatch(s->s.getText().equals(productName));
			return Match;
		}
		
		public PaymentPage checkout()
		{
			Checkout.click();
			PaymentPage paymentpage = new PaymentPage(driver);
			return paymentpage;
		}
	
}
