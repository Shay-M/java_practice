import java.util.Iterator;

public class Range implements Iterable<Integer> {
    private final ArrayCollection<Integer> collection = new ArrayCollection<Integer>();

    public Range(int firstNum, int secondNum) {
        for (int i = firstNum; i < secondNum; i++) {
            collection.add(i);
        }
    }

    public Range(int firstNum, int secondNum, final int steps) {
        final int newSteps = (firstNum - secondNum) / steps * -1;
        for (int i = 0, sum = 0; i < newSteps; i++) {
            collection.add(firstNum + sum);
            sum += steps;
        }
    }

    @Override
    public java.util.Iterator iterator() {
        java.util.Iterator<Integer> itr = collection.iterator();
        return itr;
    }
}