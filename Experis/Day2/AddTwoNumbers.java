import java.util.logging.Level;
import java.util.logging.Logger;

public final class AddTwoNumbers {
	public static void main(final String[] args) {
		final Logger logger = Logger.getLogger(AddTwoNumbers.class.getCanonicalName());

		logger.log(Level.INFO, "Give me a number...");
		final String untrust_value1 = System.console().readLine();
		logger.log(Level.INFO, "Give me another number...");
		final String untrust_value2 = System.console().readLine();
		
		final int untrust_num1 = Integer.valueOf(untrust_value1);
		final int untrust_num2 = Integer.valueOf(untrust_value2);

		if (willCauseWrapAroundWhenAdded(untrust_num1, untrust_num2)) {
			logger.log(Level.SEVERE, "wrap around detected");
			return;
		}

		final int num1 = untrust_num1;
		final int num2 = untrust_num2;
	
		final int result = num1 + num2;

		final String printedResult = String.valueOf(result);
		logger.log(Level.INFO, printedResult);
	}

	private static boolean willCauseWrapAroundWhenAdded(int untrust_num1, int untrust_num2) {
		return ((untrust_num1 > 0) && (untrust_num2 > 0) 
				&& willCauseWrapAroundWhenAddingPositives(untrust_num1, untrust_num2))
			|| ((untrust_num1 < 0) && (untrust_num2 < 0)
				&& willCauseWrapAroundWhenAddingNegatives(untrust_num1, untrust_num2));
	}

	private static boolean willCauseWrapAroundWhenAddingPositives(final int untrust_positive1, final int untrust_positive2) {
            // max possible 2147483647
			//untrust_positive1 == 3
            // 0 < untrust_positive2 <= 2147483647 - untrust_positive1
			final int maxAllowedForPositive2 = Integer.MAX_VALUE - untrust_positive1;
			return (untrust_positive2 > maxAllowedForPositive2);

			//if (untrust_positive2 > maxAllowedForPositive2) {
			//	return true;
			//}
			//return false;

			//if (untrust_positive2 > maxAllowedForPositive2) {
			//	return true;
			//}
			//else {
			//	return false;
			//}
	}

	private static boolean willCauseWrapAroundWhenAddingNegatives(final int untrust_negative1, final int untrust_negative2) {
            // min possible -2147483648
			//untrust_negative1 == -1
            // -2147483648 - untrust_negative1 <= untrust_negative2 < 0
			final int minAllowedForNegative2 = Integer.MIN_VALUE - untrust_negative1;
			return (untrust_negative2 < minAllowedForNegative2);
	}
}

