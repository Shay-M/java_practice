//(1) Write a function that receives an array of strings arrStrings and a string toRemove.
//The function returns a new array of Strings that is the same as the input array arrStrings except that all strings that were equal to toRemove are removed.

//example: 
//For strings array { "abc", "def", "hij", "yariv", "abc", "hij", "abc", "def" } and the string value "abc" the function will
//return the array { "def", "hij", "yariv", "hij", "def" }

//If arrStrings does not contain the string toRemove at all - throw an exception.

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.*;

public final class ArrStringToRemove {

	public static void main(final String[] args) {
	
		final Logger logger = Logger.getLogger(ArrStringToRemove.class.getCanonicalName());

		final String[] strArr = {"abc" , "abc" , "eee" , "bbb" , "xxx" , "ooo"};
		final String strToRemove = "ab";
		
		logger.log(Level.INFO, "Original Array: " + Arrays.toString(strArr));
		
		try {
			logger.log(Level.INFO, "Array after remove: " + Arrays.toString(stringToRemove(logger, strArr , strToRemove)));
		 } catch (IllegalArgumentException ex) {
			logger.log(Level.INFO,ex.getMessage());
		} catch (NullPointerException ex) {
			logger.log(Level.INFO,"Empty Arr!");
		}
		
	}
	
	private static String[] stringToRemove( final Logger logger, final String[] strArr ,final String strToRemove ) throws IllegalArgumentException {
		
		final int length = strArr.length;
		int countToRemove = 0;
		

		for (String str : strArr) {
			if (str.equals(strToRemove)) {
				++countToRemove;
			}	
		}
		
		if (countToRemove == 0) {
			throw new IllegalArgumentException("arrStrings does not contain the string toRemove at all!");
			// return null;
		}
		
		final String[] strArrToReturn = new String[length - countToRemove];
		
		logger.log(Level.FINE, "find: " + (length - countToRemove) + " to remove");
				
		for (int i = 0, j = 0 ; i < length ; ++i) {
		
			if (!strArr[i].equals(strToRemove)) {
				 strArrToReturn[j++] = strArr[i];  
			}
			
		}	
		return strArrToReturn;
	}
}