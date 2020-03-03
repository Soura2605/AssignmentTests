package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebElementHelper;
import locators.AmazonLocators;

public class AmazonHomePage {
	
	public WebDriver driver;
	WebElementHelper webElementHelper;
	
	public AmazonHomePage(WebDriver driver) {
		
		this.driver=driver;
		this.webElementHelper=new WebElementHelper(driver);
	}
	
	//---------------Setters-----------------
	
	public void clickOnSearchBox() {
		
		try {
			webElementHelper.clickElement(driver, getSearchBoxField());
		}catch(Exception e) {
			
			Assert.fail("Unable to click on the Element");
		}
		
	}
	
	public void enterIntoSearchBox(String keyword) {
		
		try {
		webElementHelper.enterText(getSearchBoxField(), keyword);
		}catch(Exception e) {
			
			Assert.fail("Unable to enter into the Searchbox");
		}
	}
	
	public AmazonSearchListingPage clickOnSearchButton() {
		
		try {
		webElementHelper.clickElement(driver, getSearchButton());
		}catch(Exception e) {
			
			Assert.fail("Unable to click on the Element");
		}
		
		return new AmazonSearchListingPage(driver);
	}
	
	
	
	//---------------Getters-----------------
	
	public WebElement getSearchBoxField() {
		
		try {
		return driver.findElement(By.xpath(AmazonLocators.Homepage.SEARCHBOX_TEXTFIELD));
		}catch(Exception e) {
			
			Assert.fail("Unable to locate Element");
			return (WebElement) e;
		}
	}
	
public WebElement getSearchButton() {
		
	try {
		return driver.findElement(By.xpath(AmazonLocators.Homepage.SEARCH_BTN));
		
	}catch(Exception e) {
		
		Assert.fail("Unable to locate Element");
		return (WebElement) e;
	}
	}
	

}
