import creator.CreatorDieselEngine;
import creator.EngineCreator;
import creator.GenericEnginesFactory;
import engines.Engine;

import java.util.logging.Logger;

public class GenericFactory {
    private static final Logger m_logger = Logger.getLogger(GenericFactory.class.getCanonicalName());

    public static void main(final String[] args) {

        final EngineCreator diesel = new CreatorDieselEngine();
        final EngineCreator electric = new CreatorDieselEngine();

        final GenericEnginesFactory genericEnginesFactory = new GenericEnginesFactory();

        genericEnginesFactory.register("key", diesel);
        genericEnginesFactory.register("key2", electric);

        Engine engine = genericEnginesFactory.create("key");
    }
}