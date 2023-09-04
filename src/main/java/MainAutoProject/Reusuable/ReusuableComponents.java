package MainAutoProject.Reusuable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MainAutoProject.pageobjects.MyCartPage;
import MainAutoProject.pageobjects.OrdersPage;

public class ReusuableComponents {
	
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement CartIcon;
	WebDriver driver;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement OrderIcon;
	
	
	
	public ReusuableComponents(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void elementtoappear(By fieldval)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(fieldval));
	}
	
public void webelementtoappear(WebElement fieldval)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(fieldval));
	}
	
	public void invisibilityoflement(By fieldval)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(fieldval));
	}
	
	public MyCartPage gotocart()
	{
		CartIcon.click();
		MyCartPage mycartpage = new MyCartPage(driver);
		return mycartpage;
	}
	

	public OrdersPage gotoorderspage()
	{
		OrderIcon.click();
		OrdersPage orderspage = new OrdersPage(driver);
		return orderspage;
	}


}
