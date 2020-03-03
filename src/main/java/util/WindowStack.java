package util;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class WindowStack {

	private WebDriver driver;
	
	public WindowStack(WebDriver driver) {//, Thread thread) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.driver = driver;
	}
	
	public void windowSwitch(WebDriver driver, int index) {
        ArrayList<String> winHandle = new ArrayList(driver.getWindowHandles());
        if(!winHandle.get(index).isEmpty()) {
            driver.switchTo().window(winHandle.get(index));
        }
	}
}
