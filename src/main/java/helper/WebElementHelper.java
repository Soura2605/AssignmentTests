package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class WebElementHelper {

	WebDriver driver;
	WebElement e=null;
	
	public WebElementHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clickElement(WebDriver driver, WebElement ele) {
		
		try {

		ele.click();
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void enterText(WebElement textField, String text) {
		
		textField.clear();
		textField.sendKeys(text);
		
	}
	
	public String getText(WebDriver driver, WebElement ele) {
		
		String text=null;
		
		try {
		
		text = ele.getText();
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return text;
	}
	
	public void mouseHoverOnElement(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}
	
	public void mouseHoverJScript(WebDriver driver, WebElement HoverElement) {
		try {
		

				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				((JavascriptExecutor) driver).executeScript(mouseOverScript,
						HoverElement);

			

			} catch (Exception e) {
				
				e.printStackTrace();
			
		} 
	}
}
