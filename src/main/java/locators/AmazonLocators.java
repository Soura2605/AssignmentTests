package locators;

public class AmazonLocators {
	
	public class Homepage{
		
		
		public static final String SEARCHBOX_TEXTFIELD="//input[@id='twotabsearchtextbox']";
		public static final String SEARCH_BTN="//div[contains(@class,'submit')]/input[@type='submit']";
	}
	
	public class SearchListingPage{
		
		
		public static final String PRODUCTS_DISPLAYED="//img[contains(@class,'s-image')]";
		public static final String MATCHED_PRODUCT="//img[contains(@class,'s-image') and contains(@alt,'ProductNames')]";
		
	}

	public class ProductDescriptionPage{
		
		
		public static final String PRICE_DISPLAYED="//div[@id='price']//span[contains(@id,'priceblock')]";
		
		
	}
}
