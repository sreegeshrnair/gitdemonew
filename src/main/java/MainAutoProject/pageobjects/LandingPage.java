package MainAutoProject.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MainAutoProject.Reusuable.ReusuableComponents;

public class LandingPage extends ReusuableComponents{		
		WebDriver driver;
		
		//Creating Constructor
		//Constructor has same name as class name
		//First method to execute in class
		public LandingPage(WebDriver driver)
		{
			super(driver); //sending the driver to reusablecomponent
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
	
	
		//Using the pagefactory design pattern
		@FindBy(id="userEmail")
		WebElement useremail;
		
		@FindBy(id="userPassword")
		WebElement passwordElement;

		@FindBy(id="login")
		WebElement login;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errormessage;
		
		public ProductCatalogue Loginapplication(String email, String password)
		{
			useremail.sendKeys(email);
			passwordElement.sendKeys(password);
			login.click();
			ProductCatalogue productCatalogue = new ProductCatalogue(driver);
			return productCatalogue;
		}
		

		public void GoTo() {
			// TODO Auto-generated method stub
			
				driver.get("https://rahulshettyacademy.com/client/");
				driver.manage().window().fullscreen();	
		
		}
		
		public String getErrormessage()
		{
			webelementtoappear(errormessage);
			return errormessage.getText();
			
		}
		

}
