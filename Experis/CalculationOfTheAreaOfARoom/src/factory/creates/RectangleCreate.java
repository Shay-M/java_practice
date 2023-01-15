package factory.creates;

import factory.ShapeCreator;
import util.ConvertToTrustedInput;
import shapes.Rectangle;

import java.util.Scanner;

public class RectangleCreate implements ShapeCreator {
    private final static Scanner scanner = new Scanner(System.in);

    @Override
    public final Rectangle create() {
        System.out.println("Rectangle: Enter width:");
        final String untruest_width = scanner.nextLine();
        final double width = ConvertToTrustedInput.validate(untruest_width);

        System.out.println("Rectangle: Enter high:");
        final String untruest_high = scanner.nextLine();
        final double high = ConvertToTrustedInput.validate(untruest_high);

        return new Rectangle(width, high);
    }

}
