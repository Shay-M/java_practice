// javac FromThreeComesOneGame.java // java FromThreeComesOneGame

import java.util.logging.Level;
import java.util.logging.Logger;

public final class calculator {
    public static void main(final String[] args) {
        final Logger logger = Logger.getLogger(calculator.class.getCanonicalName());

       	final String number1 = inputNumber(logger, 1);
		if ("".equals(number1)) {
			return;
		}// Integer.valueOf(
		
        logger.log(Level.INFO, "\n\n\n");

        final String number2 = inputNumber(logger, 2);
		if ("".equals(number2)) {
			return;
		}// 

        logger.log(Level.INFO, "\n\n\n");

        final String operator = inputoperator(logger);
		if ("".equals(operator)) {
			return;
		}
		
		logger.log(Level.INFO, "\n\n\n");

        startCalculator(logger,Integer.valueOf(number1), Integer.valueOf(number2), operator);

    }
	private static void resatCalculator(final Logger logger) {
		
		 
	}

    private static String inputNumber(final Logger logger, int numCount) {

        logger.log(Level.INFO, "Please enter number " + numCount + ":\n");
        final String untrust_number = System.console().readLine();

        if (validationInputIsNumber(untrust_number)) {
            logger.log(Level.SEVERE, "number " + numCount + ": Input isn't a number!\n");
            return "";
        }
        final String number = untrust_number;

        return number;
    }
	
	private static String inputoperator(final Logger logger) {

        logger.log(Level.INFO, "Please enter operator: ( + - * / )\n");
        final String untrust_operator = System.console().readLine();

        if (validationInputIsoperator(untrust_operator)) {
            logger.log(Level.SEVERE, "operator Input isn't a ( + - * / )!\n");
            return "";
        }
        final String operator = untrust_operator;

        return operator;
    }


    private static boolean validationInputIsNumber(String untrust_stringNumber) {
        return !( untrust_stringNumber.matches("-?\\d+(\\.\\d+)?") );
    }
	
	private static boolean validationInputIsoperator(String untrust_operator) {
        return !("-".equals(untrust_operator) || "+".equals(untrust_operator) || "*".equals(untrust_operator) || "/".equals(untrust_operator) );
    }


	 private static void startCalculator(final Logger logger, int number1, int number2, String operator) {
	 
	 int result = 0;
	 
	 switch (operator) {

      case "+":
        result = number1 + number2;
        logger.log(Level.SEVERE, number1 + " + " + number2 + " = " + result);
        break;

      case "-":
        result = number1 - number2;
        logger.log(Level.SEVERE, number1 + " - " + number2 + " = " + result);
        break;

      case "*":
        result = number1 * number2;
        logger.log(Level.SEVERE, number1 + " * " + number2 + " = " + result);
        break;

      case "/":
        result = number1 / number2;
        logger.log(Level.SEVERE, number1 + " / " + number2 + " = " + result);
        break;

      default:
       logger.log(Level.SEVERE,"Invalid operator!");
        break;
    }
	 	
		
	 }
	 
	private static void print(final Logger logger, int num1, int num2, int numCalculator , String operator) {

       
    }
	
	
}