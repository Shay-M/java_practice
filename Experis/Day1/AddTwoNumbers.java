import java.util.logging.Level;
import java.util.logging.Logger;

public final class AddTwoNumbers {
	public static void main(final String[] args) {
		final Logger logger = Logger.getLogger(HelloSecureWorld.class.getCanonicalName());

		logger.log(Level.INFO, "Give me a number...");
		final String value1 = System.console().readLine();
		logger.log(Level.INFO, "Give me another number...");
		final String value2 = System.console().readLine();
		
		final int num1 = Integer.valueOf(value1);
		final int num2 = Integer.valueOf(value2);

		final int result = num1 + num2;
		if ( (result <= 0 && ( num1 > 0 && num2 > 0 )) || (result >= 0 && ( num1 < 0 && num2 < 0 ))) {
			logger.log(Level.SEVERE, "wrap around detected");
		}
		else {		
			final String printedResult = String.valueOf(result);
			logger.log(Level.INFO, printedResult);
		}
	}
}

