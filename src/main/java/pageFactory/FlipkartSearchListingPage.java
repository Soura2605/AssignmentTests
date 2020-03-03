package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebElementHelper;
import locators.AmazonLocators;
import locators.FlipkartLocators;
import util.WindowStack;

public class FlipkartSearchListingPage {

	
	public WebDriver driver;
	WebElementHelper webElementHelper;
	WindowStack winStack;
	
	public FlipkartSearchListingPage(WebDriver driver) {
		
		this.driver=driver;
		this.webElementHelper=new WebElementHelper(driver);
		this.winStack=new WindowStack(driver);
	}
	
	//---------------Setters-----------------
	
	public FlipkartProductDescriptionPage clickOnTheMatchingProduct(String ProductNumber) {
		
		webElementHelper.clickElement(driver, getAllProductsInGRID().get((Integer.parseInt(ProductNumber))-1));
		winStack.windowSwitch(driver, 2);
		
		return new FlipkartProductDescriptionPage(driver);
	}
	
	
	
	//---------------Getters-----------------
	
	
	public List<WebElement> getAllProductsInGRID() {
		
		try {
		return driver.findElements(By.xpath(FlipkartLocators.SearchListingPage.DISPLAYEDPRODUCT));
	}catch(Exception e) {
		
		Assert.fail("Unable to fetch all the products");
		e.printStackTrace();
		return (List<WebElement>) e;
	}
	}
}
