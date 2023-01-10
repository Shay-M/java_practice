package creator;

import engines.Electric;
import engines.Engine;

public class CreatorElectricEngine implements EngineCreator {


    @Override
    public Engine create() {
        return new Electric();
    }
}
