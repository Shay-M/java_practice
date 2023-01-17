package gameoflife;

import gameoflife.filessave.FrameWriter;
import gameoflife.rules.ClassicLifeRules;

import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger m_logger = Logger.getLogger(LifeT.class.getCanonicalName());
    private static final String TYPE_FILE = ".pbm";
    private static final String DEFAULT_OUTPUT_FOLDER = "output";
    private static final String DEFAULT_FILE_NAME = "generation_";
    private static final int DEFAULT_ITERATIONS = 20;
    private static final int DEFAULT_THREADS = 2;
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 800;
    private static final double INITIAL_POPULATION = 0.4; // <- todo


    public static void main(final String[] args) {
        int index = 0;
        try {
            final LifeT lifeGame;
            final var filePath = Path.of(args[index++]);
            final var iterations = Integer.parseInt(args[index++]);
            final var numThreads = Integer.parseInt(args[index++]);
            final var width = Integer.parseInt(args[index++]);
            final var height = Integer.parseInt(args[index++]);
            final var initialPopulation = 0.6;//Integer.parseInt(args[index++]);
            final var gameRules = new ClassicLifeRules(); // todo Rules from args !! do in Class ALL of THIS

            assert args.length == index;

            //final FrameWriter frameWriter = new FrameWriter(filePath , TYPE_FILE , DEFAULT_FILE_NAME , DEFAULT_OUTPUT_FOLDER);
            final FrameWriter frameWriter = new FrameWriter(filePath, TYPE_FILE);

            lifeGame = new LifeT(gameRules, frameWriter, width, height, iterations, numThreads, initialPopulation);
            lifeGame.start();
        }
        catch (NumberFormatException ex) {
            m_logger.log(Level.INFO, "Use Default.");
        }
    }
}
