package creator.engine;

import model.engines.Engine;

import java.util.HashMap;
import java.util.Optional;

public final class EnginesGenericFactory {
    private final HashMap<String, Engine> m_enginesTypes = new HashMap<>();

    public void register(final String key, final EngineCreator creator) {
        m_enginesTypes.put(key, creator.create());
    }

    public Engine create(final String key) {
        final Optional<Engine> engineCreatorFromMap = Optional.ofNullable(m_enginesTypes.get(key));

        if (engineCreatorFromMap.isEmpty()) {
            throw new IllegalArgumentException("Unknown type: " + key);
        }

        return engineCreatorFromMap.get(); // EnginesTypes.get(key); // return Created Base
    }

}
