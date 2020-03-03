package locators;

public class TripAdvisorLocators {

	public class Homepage{
		
		public static final String SEARCHBOX="//input[@type='search']/parent::form";
		public static final String SEARCHBOXOVERLAY="//input[@type='search']/parent::form/input[contains(@title,'Search')]";
	}
	
	public class SearchResultPage{
		
		
		public static final String SEARCHRESULTS="//div[contains(@class,'result-title')]/span[contains(text(),'Club Mahindra')]";
	}
	
	public class SearchDescriptionPage{
		
		public static final String WRITEREVIEW="//a[text()='Write a review']";
	}
	
	public class ReviewPage{
		
		public static final String SELECT_REVIEW="//div[contains(@class,'bigRatingParent')]";
		//public static final String SELECT_REVIEW="//div[contains(@class,'bigRatingParent')]/span[contains(@class,'bubble_50')]";
	}
}
