# Day 1
Dealing with inputs from the user, management and separation into functions

* javac fileName.java - compile
* java fileName - run application


## untrust_
```java
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AddTwoNumbers {
    public static void main(final String[] args) {
        final Logger logger = Logger.getLogger(HelloSecureWorld.class.getCanonicalName());

        logger.log(Level.INFO, "Give me a number...");
        final String untruest_value1 = System.console().readLine();
        logger.log(Level.INFO, "Give me another number...");
        final String untruest_value2 = System.console().readLine();

        final int untruest_num1 = Integer.valueOf(untruest_value1);
        final int untruest_num2 = Integer.valueOf(untruest_value2);

        final int untruest_result = untruest_num1 + untruest_num2;
        if ((untruest_result < 0 && (untruest_num1 > 0 && untruest_num2 > 0)) ||
                (untruest_result >= 0 && (untruest_num1 < 0 && untruest_num2 < 0))) {
            logger.log(Level.SEVERE, "wrap around detected");
        }

        else {
            // ** At this point i can trust the result **

            final int result = untruest_result; // dont afraid to us a new val
            final String printedResult = String.valueOf(result);
            logger.log(Level.INFO, printedResult);
        }
    }
}
```

We want the work itself to be free of correctness,
To understand and separate the work from the tests checks so :
```java
        ...
        final int untruest_num1 = Integer.valueOf(untruest_value1);
        final int untruest_num2 = Integer.valueOf(untruest_value2);

        if ((untruest_num1 > 0) && (untruest_num2 > 0)) {
            final int maxAllowedForNum2 = Integer.MAX_VALUE - untruest_num1;
            if (untruest_num2 > maxAllowedForNum2) {
                logger.log(Level.SEVERE, "wrap around detected");
                return;
            }
        }

        if ((untruest_num1 < 0) && (untruest_num2 < 0)) {
            final int maxAllowedForNum2 = Integer.MIN_VALUE - untruest_num1;
            if (untruest_num2 < maxAllowedForNum2) {
                logger.log(Level.SEVERE, "wrap around detected");
                return;
            }
        }

        // ** At this point i can trust the result **

        final int num1 = untruest_num1;
        final int num2 = untruest_num2;
        final int result = num1 + num2;

        final String printedResult = String.valueOf(result);
        logger.log(Level.INFO, printedResult);
    }
}
```


But right now it's long, it should be divided into parts - functions:
We will also update the variable names of the function to be clearer
```java
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
        // untrust_positive1 == 3
        // 0 < untrust_positive2 <= 2147483647 - untrust_positive1
        final int maxAllowedForPositive2 = Integer.MAX_VALUE - untrust_positive1;
        return (untrust_positive2 > maxAllowedForPositive2);
    }

    private static boolean willCauseWrapAroundWhenAddingNegatives(final int untrust_negative1, final int untrust_negative2) {
        final int minAllowedForNegative2 = Integer.MIN_VALUE - untrust_negative1;
        return (untrust_negative2 < minAllowedForNegative2);
    }
}
```


### Rock-Paper-Scissors game
    
```java
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Locale;

public final class RockPaperScissorsGame {
private static final String ROCK = "r";
private static final String PAPER = "p";
private static final String SCISSORS = "s";

    public static void main(final String[] args) {
        final Logger logger = Logger.getLogger(RockpaperScissorsGame.class.getCanonicalName());
        
        String player1Choose = "";
        String player2Choose = "";
        
        try {
            player1Choose = playerInput(logger , 1);
         } catch (IllegalArgumentException ex) {
            logger.log(Level.INFO,ex.getMessage());
         }
        
        logger.log(Level.INFO, "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
        try {
            player2Choose = playerInput(logger , 2);
         } catch (IllegalArgumentException ex) {
            logger.log(Level.INFO,ex.getMessage());
            return;
         }
                
        gameEnds( player1Choose,  player2Choose);
    }
    
    
    private static String playerInput(final Logger logger, int playerNum) throws IllegalArgumentException{
        logger.log(Level.INFO, "player" + playerNum + ": Please choose (r)ock ,(p)aper,(s)cissors");
        final String untrust_playerChoose = System.console().readLine();
        
        if (validationInputIsRPS(untrust_playerChoose)) {
            throw new IllegalArgumentException("player" + playerNum + ": Input isnt r , p or s !");
        }
        final String playerChoose = untrust_playerChoose;
        
        return playerChoose;
    }
    
    
    private static boolean validationInputIsRPS(String untrust_char) {
        return ! ( ROCK.equals(untrust_char) || PAPER.equals(untrust_char) || SCISSORS.equals(untrust_char) );
    }

    
    private static boolean checkerPlayer1Won(String player1Choose, String player2Choose) {
        if (player1Choose.equals(ROCK)) {
                return player2Choose.equals(SCISSORS);
            } else if (player1Choose.equals(PAPER)) {
                return player2Choose.equals(ROCK);
            } else {
                return player2Choose.equals(PAPER);
        }
    }
    
    
    private static void gameEnds(String player1Choose, String player2Choose) {
        final Logger logger = Logger.getLogger(RockpaperScissorsGame.class.getCanonicalName());
        
        if (player1Choose.equals(player2Choose)) {
            logger.log(Level.INFO, "It's a draw !");
            return;
        }
        
        if ( checkerPlayer1Won(player1Choose,player2Choose) ) {	
            logger.log(Level.INFO, "Player 1 Won !");
            } else {
                logger.log(Level.INFO, "Player 2 Won !");
            }
        }
}
```








