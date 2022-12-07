// javac FromThreeComesOneGame.java // java FromThreeComesOneGame

import java.util.logging.Level;
import java.util.logging.Logger;

public final class FromThreeComesOneGame {
    public static void main(final String[] args) {
        final Logger logger = Logger.getLogger(FromThreeComesOneGame.class.getCanonicalName());

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

        final int player1ChooseHand = playerInputHand(logger, 1);
		
        logger.log(Level.INFO, "\n\n\n");

        final int player2ChooseHand = playerInputHand(logger, 2);

        logger.log(Level.INFO, "\n\n\n");

        final int player3ChooseHand = playerInputHand(logger, 3);

        logger.log(Level.INFO, "\n\n\n");

        gameEnds(logger, player1ChooseHand, player2ChooseHand, player3ChooseHand, gameMode);
		
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

        return Integer.valueOf(playerChoose);
    }


    private static boolean validationInput(String untrust_char) {
        return !("1".equals(untrust_char) || "2".equals(untrust_char));
    }


    private static void gameEnds(final Logger logger, int player1ChooseHand, int player2ChooseHand, int player3ChooseHand, int gameModePlayer3Help) {

        if (player1ChooseHand + player2ChooseHand + player3ChooseHand == 0 ||
                player1ChooseHand + player2ChooseHand + player3ChooseHand == 3 ||
                gameModePlayer3Help == 2 && 
				(player1ChooseHand + player2ChooseHand == 2 || player1ChooseHand + player2ChooseHand == 0)) {
            logger.log(Level.SEVERE, "It's a draw !\n\n");
            return;
        }

        if (player1ChooseHand - player2ChooseHand == 0) {
            logger.log(Level.SEVERE, "Player 3 Won !\n\n");
            return;
        }

        if (player1ChooseHand - player3ChooseHand == 0) {
            logger.log(Level.SEVERE, "Player 2 Won !\n\n");
            return;
        }

        if (player2ChooseHand - player3ChooseHand == 0) {
            logger.log(Level.SEVERE, "Player 1 Won !\n\n");
            return;
        }

    }
}