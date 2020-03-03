package helper;

public class CommonHelper {

	
	public String compareString(String firstString, String secondString) {
		
		if(Integer.parseInt(firstString)>Integer.parseInt(secondString)) {
			
			return firstString;
		}else {
			
			return secondString;
		}
	}
}
