import java.text.DecimalFormat;

public final class CalculateDetergent {


    public static final int CUBIC_CENTIMETRES = 1000;

    public static double litresOfDetergent(final double roomSize) {
        // new DecimalFormat("##.##").format(roomSize / CUBIC_CENTIMETRES);
        return roomSize / CUBIC_CENTIMETRES;

    }

    //
}
