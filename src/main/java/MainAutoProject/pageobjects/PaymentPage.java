package MainAutoProject.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MainAutoProject.Reusuable.ReusuableComponents;

public class PaymentPage extends ReusuableComponents{		
		WebDriver driver;
		
		//Creating Constructor
		//Constructor has same name as class name
		//First method to execute in class
		public PaymentPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(css=".form-group .input")
		WebElement country;
		
		@FindBy(xpath ="(//button[contains(@class,'ta-item')])[1]")
		WebElement selectedcountry;
		
		@FindBy(css = "a.btnn")
		WebElement Orderplacement;
		
		public void selectcountry(String countryname)
		{
			country.sendKeys(countryname);
			elementtoappear(By.cssSelector(".ta-results"));
			selectedcountry.click();	
		}
		
		public ConfirmationPage placeorder()
		{
			Orderplacement.click();
			ConfirmationPage confirmationpage = new ConfirmationPage(driver);
			return confirmationpage;
		}
		

	
}
