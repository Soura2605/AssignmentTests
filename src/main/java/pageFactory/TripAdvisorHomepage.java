package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebElementHelper;
import locators.TripAdvisorLocators;

public class TripAdvisorHomepage {

	public WebDriver driver;
	WebElementHelper webElementHelper;
	
	public TripAdvisorHomepage(WebDriver driver) {
		
		this.driver=driver;
		this.webElementHelper=new WebElementHelper(driver);
	}
	
	
	//---------------Setters-----------------
	
	public void clickOnSearchBox() {
		
		try {
			
			webElementHelper.clickElement(driver, getSearchBox());
		}catch(Exception e) {
			
			Assert.fail("Unable to click on Element");
		}
	}
	
	public TripAdvisorSearchListingPage enterIntoSearchFieldAndHitEnter(String Message) {
		
		try {
			
			webElementHelper.enterText(getSearchField(), Message);
			getSearchField().sendKeys(Keys.ENTER);
			return new TripAdvisorSearchListingPage(driver);
		}catch(Exception e) {
			
			Assert.fail("Unable to enter text");
			return null;
		}
	}
	
	
	//---------------Getters-----------------
	
	public WebElement getSearchField() {
		
		try {
			
			return driver.findElement(By.xpath(TripAdvisorLocators.Homepage.SEARCHBOXOVERLAY));
		}catch(Exception e) {
			
			Assert.fail("Unable to Locate Element");
			return (WebElement) e;
		}
	}
	
	public WebElement getSearchBox() {
		
		try {
			
			return driver.findElement(By.xpath(TripAdvisorLocators.Homepage.SEARCHBOX));
		}catch(Exception e) {
			
			Assert.fail("Unable to Locate Element");
			return (WebElement) e;
		}
	}
}
