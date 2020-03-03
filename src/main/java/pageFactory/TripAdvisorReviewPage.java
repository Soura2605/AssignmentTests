package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebElementHelper;
import locators.FlipkartLocators;
import locators.TripAdvisorLocators;
import util.WindowStack;

public class TripAdvisorReviewPage {

	public WebDriver driver;
	WebElementHelper webElementHelper;
	WindowStack winStack;
	
	public TripAdvisorReviewPage(WebDriver driver) {
		
		this.driver=driver;
		this.webElementHelper=new WebElementHelper(driver);
		this.winStack=new WindowStack(driver);
	}
	
	
	//---------------Setters-----------------
	
	public void hoverAndSelectReview() {
		
		try {
		webElementHelper.mouseHoverJScript(driver, getReviewButton());;
		webElementHelper.clickElement(driver, getReviewButton());
		
		}catch(Exception e) {
			
			Assert.fail();
		}
	}
	
	
	
	//---------------Getters-----------------
	
public WebElement getReviewButton() {
		
		try {
			
		return driver.findElement(By.xpath(TripAdvisorLocators.ReviewPage.SELECT_REVIEW));
		}catch(Exception e) {
			
			Assert.fail("Unable to fetch Element");
			return (WebElement) e;
		}
	}
}
