package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebElementHelper;
import locators.AmazonLocators;
import util.WindowStack;

public class AmazonProductDescriptionPage {

	public WebDriver driver;
	WebElementHelper webElementHelper;
	WindowStack winStack;
	
	public AmazonProductDescriptionPage(WebDriver driver) {
		
		this.driver=driver;
		this.webElementHelper=new WebElementHelper(driver);
		this.winStack=new WindowStack(driver);
	}
	
	
	//---------------Setters-----------------
	
	public String getTheValueOfPrice() {
		
		try {
		String[] price = webElementHelper.getText(driver, getPrice()).trim().split("\\.");
		String finalPrice=price[0];
		finalPrice= finalPrice.replaceAll("[^0-9]", "");
		System.out.println(finalPrice);
		return finalPrice;
		}catch(Exception e) {
			
			Assert.fail();
			return null;
		}
		
	}
	
	//---------------Getters-----------------
	
	public WebElement getPrice() {
		
		try {
		return driver.findElement(By.xpath(AmazonLocators.ProductDescriptionPage.PRICE_DISPLAYED));
		}catch(Exception e) {
			
			Assert.fail();
			return(WebElement) e;
		}
	}
}
