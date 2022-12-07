



import java.util.logging.Level;
import java.util.logging.Logger;

public final class Search {
    public static void main(final String[] args) {
        final Logger logger = Logger.getLogger(Search.class.getCanonicalName());
		
		int arr[] = {1, 0, 2, 1, 1, 0, 3, 1, 0};
		
		logger.log(Level.INFO, " " + Boolean.toString( containsValue(arr , 2) ));
		logger.log(Level.INFO, " " +  containsValue(arr , 7) );
		
    }
	private static boolean containsValue(int[] arr , int value){
	
		 for (int index : arr) {
		 
		 	if (index == value) {
				return true;
			}
		 }
		 return false;
	}

}

