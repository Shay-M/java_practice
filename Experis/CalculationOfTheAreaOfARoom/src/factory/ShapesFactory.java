package factory;

import shapes.Shape;

import java.util.HashMap;
import java.util.Optional;

public final class ShapesFactory {
    private final HashMap<String, Shape> m_shapesTypes = new HashMap<>();


    public void register(final String key, final ShapeCreator creator) {
        m_shapesTypes.put(key, creator.create());
    }

    public final Shape create(final String key) {
        final Optional<Shape> shapeCreatorFromMap = Optional.ofNullable(m_shapesTypes.get(key));

        if (shapeCreatorFromMap.isEmpty()) {
            throw new IllegalArgumentException("Unknown type: " + key);
        }

        return shapeCreatorFromMap.get();
    }


}
