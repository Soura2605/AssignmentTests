package Assignment.EcommWebsiteTesting;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.TripAdvisorHomepage;
import pageFactory.TripAdvisorReviewPage;
import pageFactory.TripAdvisorSearchDescriptionPage;
import pageFactory.TripAdvisorSearchListingPage;
import resources.Config;
import resources.TestBase;

public class AssignmentTest2 extends TestBase{
	
	
	TripAdvisorHomepage homepage;
	TripAdvisorSearchListingPage searchListingPage;
	TripAdvisorSearchDescriptionPage searchDescriptionPage;
	TripAdvisorReviewPage reviewPage;
	
	public void setup() throws IOException {
		
		driver = initializeDriver();
		homepage=new TripAdvisorHomepage(driver);
		
	}
	

	@Test(dataProvider="getData")
	public void giveRatings(String Message) throws IOException {
		
		setup();
		navigateToUrl(driver, "Tripadvisor");
		homepage.clickOnSearchBox();
		searchListingPage = homepage.enterIntoSearchFieldAndHitEnter(Message);
		searchDescriptionPage=searchListingPage.clickOnTheMatchingProductResult(Config.SearchNumber);
		reviewPage=searchDescriptionPage.clickOnWriteAReviewbutton();
		reviewPage.hoverAndSelectReview();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	@DataProvider
	public Object[] getData() throws IOException {
		
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("/Users/souradipgoswami/eclipse-workspace/EcommWebsiteTesting/src/main/java/testData/TestData.properties");
		p.load(file);
		
		Object[] data= {p.getProperty("Message")};
		
		return data;
	}
}
