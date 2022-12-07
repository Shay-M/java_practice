import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Locale;

public final class RockpaperScissorsGame {
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
		 	// player1Choose = playerInput(logger , 1);
		 }
		
		logger.log(Level.INFO, "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		try {
			player2Choose = playerInput(logger , 2);
		 } catch (IllegalArgumentException ex) {
			logger.log(Level.INFO,ex.getMessage());
			return;
		 	// player2Choose = playerInput(logger , 2);
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
		
		c playerChoose;
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