package MainAutoProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import MainAutoProject.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standalonetest {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "/Users/sreegesh/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));//implicit wait
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().fullscreen();
	
		
		//Enter user name and password
		driver.findElement(By.id("userEmail")).sendKeys("sreegeshr@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("@Attra2032");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		Thread.sleep(2000);
		//Using streams to search through the products and find zara coat 3
		WebElement proddetail =products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//		
		proddetail.findElement(By.cssSelector(".btn.w-10.rounded")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container"))); //explicit wait for the popup message
		System.out.println(driver.findElement(By.id("toast-container")).getText());
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartitems = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean Match = cartitems.stream().anyMatch(s->s.getText().equals("ZARA COAT 3")); //Expecting True when a match found
		Assert.assertTrue(Match);
		
		//check out
		driver.findElement(By.cssSelector(".subtotal .btn")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".form-group .input")).sendKeys("Aus");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[1]")).click();
		
//		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.btnn")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Place Order")));
//		driver.findElement(By.linkText("Place Order")).click();
		String Actualmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		String Expected = "Thankyou for the order.";
		
		Assert.assertTrue(Actualmessage.equalsIgnoreCase(Expected));
		driver.close();
	}

}
