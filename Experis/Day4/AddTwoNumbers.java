import java.util.logging.Level;
import java.util.logging.Logger;


// If both numbers are in meters - the result is in meters.
// If both numbers are in km - the result is in km
// If one number is in meters and the other is in km - the result is in meters.
public final class AddTwoNumbers {

	final static String METERS = "Meters";
	final static String KMETERS = "K'Meters";
	
	public static void main(final String[] args) {
		
		final Logger logger = Logger.getLogger(AddTwoNumbers.class.getCanonicalName());

		logger.log(Level.INFO, "Give me distance:");
		final String untrust_value1 = System.console().readLine();
		logger.log(Level.INFO, "What units is the distance? (km, m)");
		final String untrust_units1 = System.console().readLine();

		logger.log(Level.INFO, "Give me another distance in meters");
		final String untrust_value2 = System.console().readLine();
		logger.log(Level.INFO, "What units is the distance? (km, m)");
		final String untrust_units2 = System.console().readLine();
		
		final int untrust_num1 = Integer.valueOf(untrust_value1);
		final int untrust_num2 = Integer.valueOf(untrust_value2);

		if (WrapAroundDetection.willCauseWrapAroundWhenAdded(untrust_num1, untrust_num2)) {
			logger.log(Level.SEVERE, "wrap around detected");
			return;
		}

		final int num1 = untrust_num1;
		final int num2 = untrust_num2;
		String units = METERS;
		
		if (untrust_units1.equals("km") && untrust_units2.equals("m")){
			untrust_units1 /= 1000;
		} else if (untrust_units1.equals("m") && untrust_units2.equals("km")){
			untrust_units2 *= 1000;	
		} else if (untrust_units1.equals("km1") && untrust_units2.equals("km")){
			untrust_units2 *= 1000;	
		}
	
		final int result = addNumbers(num1, num2);

		final String printedResult = "The total distance is " + result + " " + units;
		logger.log(Level.INFO, printedResult);
	}

	private static int addNumbers(final int num1, final int num2) {
		return num1 + num2;
	}

	private static int subtractNumbers(final int num1, final int num2) {
		return num1 - num2;
	}

}

