package Assignment.EcommWebsiteTesting;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import helper.CommonHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.AmazonHomePage;
import pageFactory.AmazonProductDescriptionPage;
import pageFactory.AmazonSearchListingPage;
import pageFactory.FlipkartHomePage;
import pageFactory.FlipkartProductDescriptionPage;
import pageFactory.FlipkartSearchListingPage;
import resources.Config;
import resources.TestBase;
import testData.ExcelUtils;

public class AssignmentTest1 extends TestBase {
	
	AmazonHomePage amazonHomePage;
	AmazonSearchListingPage searchListingPage;
	AmazonProductDescriptionPage amazonProductDescPage;
	FlipkartHomePage flipkartHomepage;
	FlipkartSearchListingPage flipkartSearchListingPage;
	FlipkartProductDescriptionPage flipkartProductDescriptionPage;
	CommonHelper helper;
	
	public void setup() throws IOException {
		
		driver = initializeDriver();
		amazonHomePage=new AmazonHomePage(driver);
		flipkartHomepage=new FlipkartHomePage(driver);
		helper=new CommonHelper();
		
		
	}
	
	
	@Test(dataProvider="getData")
	public void comparePrices(String keyword) throws IOException {
		
		
		
		setup();
		navigateToUrl(driver, "Amazon");
		amazonHomePage.clickOnSearchBox();
		amazonHomePage.enterIntoSearchBox(keyword);
		searchListingPage = amazonHomePage.clickOnSearchButton();
		amazonProductDescPage=searchListingPage.clickOnTheMatchingProduct(Config.ProductNumber);
		String amazonPrice = amazonProductDescPage.getTheValueOfPrice();
		
		navigateToUrl(driver, "Flipkart");
		flipkartHomepage.clickOnCrossButton();
		flipkartSearchListingPage=flipkartHomepage.enterKeywordInSearchBoxAndHitEnter(keyword);
		flipkartProductDescriptionPage=flipkartSearchListingPage.clickOnTheMatchingProduct(Config.ProductNumber);
		String flipkartPrice = flipkartProductDescriptionPage.getTheValueOfPrice();
		System.out.println("The highest price is : "+helper.compareString(amazonPrice, flipkartPrice));
		
		
	}
	
//	@DataProvider
//	public Object[] getData() throws IOException {
//		
//		return ExcelUtils.fetchData(Config.TestCaseName);
//		
//		
//	}
	
	@DataProvider
	public Object[] getData() throws IOException {
		
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("/Users/souradipgoswami/eclipse-workspace/EcommWebsiteTesting/src/main/java/testData/TestData.properties");
		p.load(file);
		
		Object[] data= {p.getProperty("SearchKeyword")};
		
		return data;
	}
}
