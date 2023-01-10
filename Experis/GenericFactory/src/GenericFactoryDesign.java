import creator.engine.CreatorDieselEngine;
import creator.engine.CreatorElectricEngine;
import creator.engine.EngineCreator;
import creator.engine.EnginesGenericFactory;
import model.Car;
import model.engines.Engine;
import model.wheels.OffRoad;
import util.ClassFromFileText;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class GenericFactoryDesign {
    private static final Logger m_logger = Logger.getLogger(GenericFactoryDesign.class.getCanonicalName());
    private static final int CAR_INDEX_LINE = 0;
    private static final int NAME_OBJ = 0;
    private static final int COLOR_OBJ = 1;
    private static final int NUM_DOORS = 2;
    private static final int ENGINE_INDEX_LINE = 1;
    private static final int ENGINE_TYPE = 0;
    private static final int ENGINE_PRA1 = 1;
    private static final int ENGINE_PRA2 = 1;
    private static final int WHEEL_INDEX_LINE = 2;
    public static final String DIESEL = "Diesel";
    public static final String ELECTRIC = "Electric";

    public static void main(final String[] args) {
        final EnginesGenericFactory enginesGenericFactory = createEngineFactory();
        // get all line
        final List<String[]> listOfCarsObj = ClassFromFileText.getListOfCarParts();
        assert listOfCarsObj.size() == 3; // 3 line represent a car.

        final String[] enginePrats = listOfCarsObj.get(ENGINE_INDEX_LINE);
        final Engine engine = enginesGenericFactory.create(enginePrats[ENGINE_TYPE]);

        final Car car = new Car(
                listOfCarsObj.get(CAR_INDEX_LINE)[NAME_OBJ],
                listOfCarsObj.get(CAR_INDEX_LINE)[COLOR_OBJ],
                Integer.parseInt(listOfCarsObj.get(CAR_INDEX_LINE)[NUM_DOORS]),
                new OffRoad(), // wheel.get()
                engine
        );

        m_logger.log(Level.INFO, "\nCar Details From File:" + car);

    }

    private static EnginesGenericFactory createEngineFactory() {
        final EngineCreator diesel = new CreatorDieselEngine();
        final EngineCreator electric = new CreatorElectricEngine();
        final EnginesGenericFactory enginesGenericFactory = new EnginesGenericFactory();
        enginesGenericFactory.register(DIESEL, diesel);
        enginesGenericFactory.register(ELECTRIC, electric);

        return enginesGenericFactory;
    }

}