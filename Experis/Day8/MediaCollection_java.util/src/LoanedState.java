public enum LoanedState {
    yes {
        @Override
        public String toString() {
            return "*";
        }
    },
    Loaned, no {
        @Override
        public String toString() {
            return " ";
        }
    }
}
