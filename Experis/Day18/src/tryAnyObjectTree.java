import java.util.Comparator;

public final class tryAnyObjectTree<U> {

    public final static class ComplexNumbers {
        private final double real;
        private final double imagination;

        public ComplexNumbers() {
            this.real = 0;
            this.imagination = 0;
        }

        public ComplexNumbers(final double real, final double imagination) {
            this.real = real;
            this.imagination = imagination;
        }
    }

    public tryAnyObjectTree() {
        final Comparator<U> m_comparator = new Comparator<>() {
            @Override
            public int compare(final U o1, final U o2) {
                return 0;
            }
        };

        final AnyObjectTree<ComplexNumbers> tree = new AnyObjectTree<ComplexNumbers>(m_comparator < ComplexNumbers >);
        tree.add(new ComplexNumbers());

        dog();

    }
}
