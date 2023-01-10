package creator;

import engines.Diesel;
import engines.Engine;

public class CreatorDieselEngine implements EngineCreator {


    @Override
    public Engine create() {
        return new Diesel();
    }
}
