// javac FromThreeComesOneGame.java // java FromThreeComesOneGame

import java.util.logging.Level;
import java.util.logging.Logger;

public final class FromThreeComesOneGameWithArr {

	private static final int NUM_PLAYRRS = 3;
	
    public static void main(final String[] args) {
        final Logger logger = Logger.getLogger(FromThreeComesOneGameWithArr.class.getCanonicalName());

        resatGame(logger);

    }
	private static void resatGame(final Logger logger) {
	
		final int gameMode = GameModesMenu(logger);

        if (gameMode != 0) {
            startNewGame(logger, gameMode);
        } else {
            logger.log(Level.SEVERE, "\nBye!!!\n");
        }
	}

    private static int GameModesMenu(final Logger logger) {

        logger.log(Level.INFO, "Please choose:\n (1) Normal game mode.\n (2) A third player helps Reverse palm.\n (*) Anything else to exit.");
        final String untrust_gameMode = System.console().readLine();

        if (validationInput(untrust_gameMode)) {
            logger.log(Level.SEVERE, "Input isn't 1 or 2\n");
            return 0;
        }
        final int gameMode = Integer.valueOf(untrust_gameMode);
        return gameMode;
    }

    private static void startNewGame(final Logger logger, int gameMode) {
	
		int[] isPlaerHandFacingUp = new int[NUM_PLAYRRS];
		
		for (int playerNum = 0 ; playerNum < NUM_PLAYRRS ; ++playerNum){
			isPlaerHandFacingUp[playerNum] = playerInputHand(logger, playerNum + 1);
			logger.log(Level.INFO, "\n\n\n");
		}
		
        gameEnds(logger, isPlaerHandFacingUp, gameMode);
		
		logger.log(Level.INFO, "\n\n\n");

        resatGame(logger);
    }

    private static int playerInputHand(final Logger logger, int playerNum) {

        logger.log(Level.INFO, "Player " + playerNum + ": Please choose (1) Straight palm or (2) Reverse palm.\n");
        final String untrust_playerChoose = System.console().readLine();

        if (validationInput(untrust_playerChoose)) {
            logger.log(Level.SEVERE, "Player " + playerNum + ": Input isn't 1 or 2 !\n");
            return 0;
        }
        final String playerChoose = untrust_playerChoose;

        return Integer.valueOf(playerChoose - 1);
    }


    private static boolean validationInput(String untrust_char) {
        return !("1".equals(untrust_char) || "2".equals(untrust_char));
    }
	

    private static void gameEnds(final Logger logger, int[] isPlaerHandFacingUp, int gameModePlayer3Help) {
		
		int sum = 0;
		
		for ( PlaerHand: isPlaerHandFacingUp) {
			sum += PlaerHand;
		}

        if (sum == 0 || sum == NUM_PLAYRRS || sum == NUM_PLAYRRS * 2 ||
                gameModePlayer3Help == 2 && (isPlaerHandFacingUp[0] == isPlaerHandFacingUp[1])) {
            logger.log(Level.SEVERE, "It's a draw !\n\n");
            return;
        }
		
		for ( int playerIndex = 0 ; i < NUM_PLAYRRS ; ++playerIndex) {
			
			if (isPlaerHandFacingUp[playerIndex] == isPlaerHandFacingUp[playerIndex + 1]) {
				
			}
		}

        if (player1ChooseHand == player2ChooseHand) {
            logger.log(Level.SEVERE, "Player 3 Won !\n\n");
            return;
			
        } else if (player1ChooseHand == player3ChooseHand == 0) {
            logger.log(Level.SEVERE, "Player 2 Won !\n\n");
            return;
        }

         logger.log(Level.SEVERE, "Player 1 Won !\n\n");
            return;

    }
}