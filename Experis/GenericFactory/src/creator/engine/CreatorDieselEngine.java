package creator.engine;

import model.engines.Diesel;
import model.engines.Engine;

public class CreatorDieselEngine implements EngineCreator {
    @Override
    public Engine create() {
        return new Diesel();
    }
}
