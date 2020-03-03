package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	
	public void navigateToUrl(WebDriver driver, String brandName) {
		
		try {
		
			if(brandName.equalsIgnoreCase("Amazon")) {
			
			driver.navigate().to(Config.Amazon_url);
			log.info("Successfully navigated to Amazon Homepage");
			
		}else if(brandName.equalsIgnoreCase("Flipkart")) {
			
			driver.navigate().to(Config.Flipkart_url);
			log.info("Successfully navigated to Flipkart Homepage");
			
		}else if(brandName.equalsIgnoreCase("TripAdvisor")) {
			
			driver.navigate().to(Config.TripAdvisor_url);
			log.info("Successfully navigated to Tripadvisor Homepage");
			
		}
			
	}catch(Exception e) {
		
		Assert.fail("Unable to navigate to Url");
		
	}
	}
	
	@AfterTest
	public void afterMethod(){
		
		driver.quit();
	}
	
	@BeforeTest
	public WebDriver initializeDriver() throws IOException {
		
//		Properties p = new Properties();
//		FileInputStream file = new FileInputStream("/Users/souradipgoswami/eclipse-workspace/EcommWebsiteTesting/src/main/java/resources/Data.properties");
//		p.load(file);
//		String browserName = p.getProperty("browser");
		String browserName=Config.Browser;
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "/Users/souradipgoswami/eclipse-workspace/EcommWebsiteTesting/chromedriver");
			driver = new ChromeDriver();
		
		}
		log.info("Driver is initialized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
}
