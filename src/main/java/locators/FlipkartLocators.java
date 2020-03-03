package locators;

public class FlipkartLocators {
	
	public class Homepage{
		
		public static final String LOGINPOPUP_CROSS_BTN="//button[text()='✕']";
		public static final String SEARCHBOX_TEXTFIELD="//form[contains(@action,'search')]//input[@type='text']";
		
	}
	
	public class SearchListingPage{
		
		public static final String DISPLAYEDPRODUCT = "//img[contains(@alt,'') and contains(@src,'iphone')]";
		
	}

	public class ProductDescriptionPage{
		
		
		public static final String PRICEDISPLAYED = "//div[contains(@class,'_1vC4OE _3qQ9m1')]";
		
		
	}

}
