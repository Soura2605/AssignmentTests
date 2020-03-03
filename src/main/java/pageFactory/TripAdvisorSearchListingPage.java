package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebElementHelper;
import locators.FlipkartLocators;
import locators.TripAdvisorLocators;
import util.WindowStack;

public class TripAdvisorSearchListingPage {
	
	public WebDriver driver;
	WebElementHelper webElementHelper;
	WindowStack winStack;
	
	public TripAdvisorSearchListingPage(WebDriver driver) {
		
		this.driver=driver;
		this.webElementHelper=new WebElementHelper(driver);
		this.winStack=new WindowStack(driver);
	}
	
	//---------------Setters-----------------
	
		public TripAdvisorSearchDescriptionPage clickOnTheMatchingProductResult(String Choice) {
			
			webElementHelper.clickElement(driver, getAllSearchResultsInGRID().get((Integer.parseInt(Choice))-1));;
			winStack.windowSwitch(driver, 1);
			
			return new TripAdvisorSearchDescriptionPage(driver);
		}
	
	
	//---------------Getters-----------------
	
	
	public List<WebElement> getAllSearchResultsInGRID() {
		
		try {
		return driver.findElements(By.xpath(TripAdvisorLocators.SearchResultPage.SEARCHRESULTS));
	}catch(Exception e) {
		
		Assert.fail("Unable to fetch all the results");
		e.printStackTrace();
		return (List<WebElement>) e;
	}
	}
}


