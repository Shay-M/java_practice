import engines.Diesel;
import engines.Electric;
import engines.Engine;
import wheels.OffRoad;
import wheels.Road;
import wheels.Snow;
import wheels.Wheel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class NormalWayToSaveClassToFile {
    private static final Logger m_logger = getLogger(NormalWayToSaveClassToFile.class.getCanonicalName());
    private static final int CAR_INDEX = 0;
    private static final int ENGINE_INDEX = 1;
    private static final int WHEEL_INDEX = 2;

    private static final int NAME_OBJ = 0;
    private static final int COLOR_OBJ = 1;
    private static final int NUM_DOORS = 2;

    public static final String ROAD_WHEEL = "RoadWheel";
    public static final String SNOW_WHEEL = "SnowWheel";
    public static final String OFF_ROAD_WHEEL = "OffRoadWheel";
    public static final String ELECTRIC = "Electric";
    public static final String DIESEL = "Diesel";

    public static void main(final String[] args) {
        final List<String[]> listOfCarsObj = ClassFromFileText.getListOfCarParts();
        assert listOfCarsObj.size() == 3;

        String[] lineOfCarsPrats = listOfCarsObj.get(WHEEL_INDEX);
        Optional<Wheel> wheel = Optional.empty();
        switch (lineOfCarsPrats[NAME_OBJ]) {
            case ROAD_WHEEL -> wheel = Optional.of(new Road());
            case SNOW_WHEEL -> wheel = Optional.of(new Snow());
            case OFF_ROAD_WHEEL -> wheel = Optional.of(new OffRoad());
            default -> throw new WheelNotSupported();
        }
        assert wheel.isPresent();

        Optional<Engine> engine = Optional.empty();
        lineOfCarsPrats = listOfCarsObj.get(ENGINE_INDEX);
        switch (lineOfCarsPrats[NAME_OBJ]) {
            case ELECTRIC -> engine = Optional.of(new Electric());
            case DIESEL -> engine = Optional.of(new Diesel());
            default -> throw new EngineNotSupported();
        }
        assert engine.isPresent();

        final Car car = new Car(
                listOfCarsObj.get(CAR_INDEX)[NAME_OBJ],
                listOfCarsObj.get(CAR_INDEX)[COLOR_OBJ],
                Integer.valueOf(lineOfCarsPrats[NUM_DOORS]),
                wheel.get(),
                engine.get()
        );

        m_logger.log(Level.INFO, "\nCar Details From File:" + car);

        /*Class<?> clazz = null;
        try {
            clazz = Class.forName("Car");//lineOfPram[0]
            Constructor<?> ctor = clazz.getConstructor(String.class);
            Object object = ctor.newInstance();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }*/


    }
}