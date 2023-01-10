package creator.engine;

import model.engines.Electric;
import model.engines.Engine;

public class CreatorElectricEngine implements EngineCreator {
    @Override
    public Engine create() {
        return new Electric();
    }
}
