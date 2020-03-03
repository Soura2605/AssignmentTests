package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.WebElementHelper;
import locators.AmazonLocators;
import locators.FlipkartLocators;
import util.WindowStack;

public class FlipkartProductDescriptionPage {

	public WebDriver driver;
	WebElementHelper webElementHelper;
	WindowStack winStack;
	
public FlipkartProductDescriptionPage(WebDriver driver) {
		
		this.driver=driver;
		this.webElementHelper=new WebElementHelper(driver);
		this.winStack=new WindowStack(driver);
	}
	
	


//---------------Setters-----------------

public String getTheValueOfPrice() {
	
	try {
	String finalPrice=webElementHelper.getText(driver, getPrice());
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
	
	return driver.findElement(By.xpath(FlipkartLocators.ProductDescriptionPage.PRICEDISPLAYED));
}
	
}
