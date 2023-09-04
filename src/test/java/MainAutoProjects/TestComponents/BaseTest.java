package MainAutoProjects.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import MainAutoProject.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver; // defining a global variable
	public LandingPage landingPage;
	public WebDriver initializedriver() throws IOException
	{
		
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//MainAutoProject//resources//GlobalData.properties");
//		prop.load(fis);
//		String browsename = prop.getProperty("browser");
//		
//		if(browsename.equalsIgnoreCase("Chrome"))
//				{
		System.setProperty("webdriver.chrome.driver", "/Users/sreegesh/Downloads/chromedriver");
		driver = new ChromeDriver();
		
//				}
		
//		else if (browsename.equalsIgnoreCase("safari"))
//		{
//			//code for safari
//		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchapplication() throws IOException
	{
		driver = initializedriver();
		landingPage = new LandingPage(driver);
		landingPage.GoTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void finalstep()
	{
		driver.close();
	}
	

}

