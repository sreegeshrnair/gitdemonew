package MainAutoProject.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MainAutoProject.Reusuable.ReusuableComponents;

public class OrdersPage extends ReusuableComponents{		
		
	
		WebDriver driver;
		
		@FindBy(xpath ="//td[2]")
		List<WebElement> productnames;
	
		public OrdersPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		public Boolean verifyorderitems(String productName)
		{
			Boolean Match = productnames.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
			return Match;
		}
		
		public void pnames()
		{
			for (int i=0; i<productnames.size();i++)
			{
				String prdnames = productnames.get(i).getText();
				System.out.println(prdnames);
			}
		}
		
	
}
