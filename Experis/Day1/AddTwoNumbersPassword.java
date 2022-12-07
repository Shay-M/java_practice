import java.util.logging.Level;
import java.util.logging.Logger;

public final class AddTwoNumbersPassword {
	public static void main(final String[] args) {
		final Logger logger = Logger.getLogger(HelloSecureWorld.class.getCanonicalName());
		final String passwordNeed = "123abc";

		logger.log(Level.INFO, "Enter the password:");
		final String passwordInput = System.console().readLine();
		
		if (!passwordInput.equals(passwordNeed)){
			logger.log(Level.SEVERE, "Wrong password, calculating denied.");
			
		} else {
			
		logger.log(Level.INFO, "Give me a number...");
		final String value1 = System.console().readLine();
		logger.log(Level.INFO, "Give me another number...");
		final String value2 = System.console().readLine();
		
		final int num1 = Integer.valueOf(value1);
		final int num2 = Integer.valueOf(value2);

		final int result = num1 + num2;
			
		final String printedResult = String.valueOf(result);
		logger.log(Level.INFO, printedResult);
		
		}
			
	}
}
