
import factory.creates.RectangleCreate;
import factory.ShapeCreator;
import factory.ShapesFactory;

import shapes.Shape;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static util.ClassNamesFromPackage.*;

public class AmountOfDetergent {
    private static final Logger m_logger = Logger.getLogger(AmountOfDetergent.class.getCanonicalName());
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        final AmountOfDetergent amountOfDetergent = new AmountOfDetergent();
        amountOfDetergent.start();
    }

    private final void start() {
        final ShapesFactory shapesFactory = createShapesFactory();
        //final Shape rectangle = shapesFactory.create("Rectangle");

        //m_logger.log(Level.INFO, "" + rectangle.calculateSize());

        // final List<Shape> shapeInsideRoom = new ArrayList<>();

//        final CreateRectangle getRectangleFromUser = new CreateRectangle();
//        final Rectangle rectangle = getRectangleFromUser.create();
//
//
//        createShapesType();
//
//        System.out.println("Enter number of Circles:");
//        final String untruest_numCircles = scanner.nextLine();
//        final int numCircles = (int) ConvertToTrustedInput.validate(untruest_numCircles);
//
//        for (int i = 0; i < numCircles; i++) {
//            final CreateCircle getCircleFromUser = new CreateCircle();
//            final Circle circle = getCircleFromUser.create();
//            shapeInsideRoom.add(circle);
//        }
//
//
//        double roomSize = rectangle.calculateSize();
//        for (Shape shape : shapeInsideRoom) {
//            roomSize += shape.calculateSize();
//        }
//
//        if (roomSize < 0) {
//
//
//        }
//
//        final double detergentNeed = CalculateDetergent.litresOfDetergent(roomSize);
//        m_logger.log(Level.INFO, "" + detergentNeed);

    }

    private ShapesFactory createShapesFactory() {

        final ShapeCreator rec = new RectangleCreate();

        final ShapesFactory shapesFactory = new ShapesFactory();
        // final List<String> classNames = getClassNamesFromPackage("shapes");
        final HashMap<String, ShapeCreator> m_shapesTypes = createClassAndKeysFromFolder(Paths.get("src/factory/creates"));

        // m_shapesTypes.forEach((key, value) -> shapesFactory.register(key, value));
        m_shapesTypes.forEach(shapesFactory::register); // like ^^



        return shapesFactory;


    }

}