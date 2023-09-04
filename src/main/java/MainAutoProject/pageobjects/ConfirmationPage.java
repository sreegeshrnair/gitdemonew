package MainAutoProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MainAutoProject.Reusuable.ReusuableComponents;

public class ConfirmationPage extends ReusuableComponents{
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) 
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
	
	@FindBy(css=".hero-primary")
	WebElement messagedisplayed;
	
	public String confirmmessage()
	{
		String Actualmessage = messagedisplayed.getText();
		return Actualmessage;
	}
	
	}
	

