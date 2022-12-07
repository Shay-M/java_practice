//(2) Write a function that receives an array of integers and returns a sorted array
//private static int[] printSorted(int[] arr) {
//	...
//}

//int[] a1 = { 5, 12, 1, 8, 4 };
//int[] sorted = printSorted(a1);
//for (int val : sorted) {
//	logger.log(Level.INFO, String.valueOf(val);
//}

//Will output:
//1
//4
//5
//8
//12

//Recommendation: Begin by writing a function for an array with only 2 numbers, then for an array with only 3 numbers, etc.

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.*;
import java.util.Arrays;

public final class ArrSorted {

	public static void main(final String[] args) {
	
		final Logger logger = Logger.getLogger(ArrSorted.class.getCanonicalName());

		final int[] a1 = { 5, 12, 1, 8, 4 };
		final int[] sorted = printSorted(a1);
		
		logger.log(Level.INFO, "Array after sorted: " + Arrays.toString(sorted) );	
	}
	
	private static int[] printSorted(int[] arr) {
	
		if (arr == null) {
			return null;
		}
		
		// final int[] tempArr = new int[arr.length];
		
		int n = arr.length;  
        int temp = 0;  
		
        for (int i = 0; i < n; ++i) {  
	         for(int j = 1 ; j < (n-i) ; ++j){  
                if(arr[j-1] > arr[j]){  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;  
                }  
	          }    
	        }  	
		
		return arr;
	}
}