package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebElementHelper;
import locators.FlipkartLocators;
import locators.TripAdvisorLocators;
import util.WindowStack;

public class TripAdvisorSearchDescriptionPage {

	public WebDriver driver;
	WebElementHelper webElementHelper;
	WindowStack winStack;
	
	public TripAdvisorSearchDescriptionPage(WebDriver driver) {
		
		this.driver=driver;
		this.webElementHelper=new WebElementHelper(driver);
		this.winStack=new WindowStack(driver);
	}
	
	//---------------Setters-----------------
	
	public TripAdvisorReviewPage clickOnWriteAReviewbutton() {
		
		try {
			
			webElementHelper.clickElement(driver, getWriteReviewButton());
			winStack.windowSwitch(driver, 2);
			return new TripAdvisorReviewPage(driver);
			
			
		}catch(Exception e) {
			
			Assert.fail();
			return null;
		}
	}
	
	
	
	//---------------Getters-----------------
	
	
	
	public WebElement getWriteReviewButton() {
		
		try {
			
		return driver.findElement(By.xpath(TripAdvisorLocators.SearchDescriptionPage.WRITEREVIEW));
		}catch(Exception e) {
			
			Assert.fail("Unable to fetch Element");
			return (WebElement) e;
		}
	}
}
