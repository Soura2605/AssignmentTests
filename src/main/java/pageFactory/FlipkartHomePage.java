package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebElementHelper;
import locators.AmazonLocators;
import locators.FlipkartLocators;

public class FlipkartHomePage {

	public WebDriver driver;
	WebElementHelper webElementHelper;
	
	public FlipkartHomePage(WebDriver driver) {
		
		this.driver=driver;
		this.webElementHelper=new WebElementHelper(driver);
	}
	
	//---------------Setters-----------------
	
	public void clickOnCrossButton() {
		
		try {
		webElementHelper.clickElement(driver, getPopUpCloseButton());
}catch(Exception e) {
			
			Assert.fail();
			
		}
	}
	
	public FlipkartSearchListingPage enterKeywordInSearchBoxAndHitEnter(String keyword) {
		
		try {
		webElementHelper.enterText(getSearchTextField(), keyword);
		getSearchTextField().sendKeys(Keys.ENTER);
		
		
		return new FlipkartSearchListingPage(driver);
		}catch(Exception e) {
			
			Assert.fail();
			return null;
		}
	}
	
	
	
	//---------------Getters-----------------
	
	public WebElement getPopUpCloseButton() {
		
		try {
		return driver.findElement(By.xpath(FlipkartLocators.Homepage.LOGINPOPUP_CROSS_BTN));
		
		}catch(Exception e) {
			
			Assert.fail();
			return (WebElement) e;
		}
	}
	
	public WebElement getSearchTextField() {
		
		try {
		return driver.findElement(By.xpath(FlipkartLocators.Homepage.SEARCHBOX_TEXTFIELD));
		
		}catch(Exception e) {
			
			Assert.fail("Unable to fetch all the products");
			e.printStackTrace();
			return (WebElement) e;
	}
	
	}

}
