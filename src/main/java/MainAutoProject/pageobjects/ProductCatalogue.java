package MainAutoProject.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MainAutoProject.Reusuable.ReusuableComponents;

public class ProductCatalogue extends ReusuableComponents{		
		WebDriver driver;
		
		//Creating Constructor
		//Constructor has same name as class name
		//First method to execute in class
		public ProductCatalogue(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		//Using the pagefactory design pattern
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		public List<WebElement> getProductList()
		{
			elementtoappear(By.cssSelector(".mb-3"));
			return products;
		}
		
		public WebElement getproduct(String productName)//searching for zara
		{
		WebElement proddetail =getProductList().stream().filter(s->s.findElement
				(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return proddetail;
		
		}
		
		public void addproducttocart(String productName) throws InterruptedException//click on add to cart
		{
			WebElement proddetail = getproduct(productName);
			proddetail.findElement(By.cssSelector(".btn.w-10.rounded")).click();
			elementtoappear(By.id("toast-container"));
			System.out.println(driver.findElement(By.id("toast-container")).getText());
			Thread.sleep(1000);
//			invisibilityoflement(By.cssSelector(".ng-animating"));
		}
		
		

}
