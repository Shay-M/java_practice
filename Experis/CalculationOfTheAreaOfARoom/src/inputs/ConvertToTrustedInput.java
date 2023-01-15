package inputs;

public class ConvertToTrustedInput {
    public static double validate(final String untruest_input) {
        if (untruest_input.trim().equals("")) {
            throw new IllegalArgumentException("Empty");
        }
        try {
            final double rectangleSize = Double.valueOf(untruest_input);
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
