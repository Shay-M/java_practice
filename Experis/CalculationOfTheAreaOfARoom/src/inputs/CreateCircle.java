package inputs;

import shapes.Circle;

import java.util.Scanner;

public class CreateCircle implements ShapeEngineCreator {
    private final static Scanner scanner = new Scanner(System.in);

    @Override
    public final Circle create() {
        System.out.println("Circle: Enter radius:");
        final String untruest_radius = scanner.nextLine();
        final double radius = ConvertToTrustedInput.validate(untruest_radius);

        return new Circle(radius);
    }


}

