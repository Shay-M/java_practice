package gameoflife;

import gameoflife.filessave.FrameWriter;
import gameoflife.rules.ClassicLifeRules;

import java.util.logging.Logger;

import static gameoflife.GameOptions.parseArgs;

public class Main {
    private static final String TYPE_FILE = ".pbm";

    public static void main(final String[] args) {
        final var opt = parseArgs(args);
        final LifeT lifeGame;
        final FrameWriter frameWriter = new FrameWriter(opt.m_filePath, TYPE_FILE);
        lifeGame = new LifeT(
                new ClassicLifeRules(),
                frameWriter,
                opt.m_width,
                opt.m_height,
                opt.m_iterations,
                opt.m_numThreads,
                opt.m_initialPopulation
        );
        lifeGame.start();
    }


}
