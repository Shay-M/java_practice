package inputs;

import shapes.Rectangle;

import java.util.Scanner;

public class GetRectangleFromUser implements getShape {
    private final static Scanner myObj = new Scanner(System.in);

    @Override
    public final Rectangle getShapeSize() {
        System.out.println("Enter width:");
        final double width = getInput();
        System.out.println("Enter high:");
        final double high = getInput();

        return new Rectangle(width, high);
    }

    //@Override
    private final double getInput() {
        final String untruest_RectangleSize = myObj.nextLine();
        if (untruest_RectangleSize.equals("")) {
            throw new IllegalArgumentException("Empty");
        }
        try {
            final double rectangleSize = Double.valueOf(untruest_RectangleSize);
            if (rectangleSize < 0) {
                throw new IllegalArgumentException("Not a valid number: -");
            }
            return rectangleSize;
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Not a valid number");
        }
    }

}
