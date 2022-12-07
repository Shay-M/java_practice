import java.util.logging.Level;
import java.util.logging.Logger;

public final class ArraysAndChange {
	private static final Logger logger = Logger.getLogger(ArraysAndChange.class.getCanonicalName());

	public static void main(final String[] args) {
	
		final int[] arr = new int[] { 1 };
		final int someValue = 7;

		logger.log(Level.INFO, String.valueOf(someValue));
		
		for(int x : arr) {
			logger.log(Level.INFO, String.valueOf(x));
		}

		logger.log(Level.INFO, "--------------------------");

		changeInt(someValue);
		changeArr(arr);

		logger.log(Level.INFO, String.valueOf(someValue));
		for(int x : arr) {
			logger.log(Level.INFO, String.valueOf(x));
		}
	}

	private static void changeInt(int v) {
		v = 99;
	}

	private static void changeArr(int[] a) {
		a[0] = 99;
	}
}
