package Tests2022.B97105;

import Tests2022.Node;

public class Ex6 {

    public static class CharInt {
        private char let;
        private int num;

        public CharInt(char let, int num) {
            this.let = let;
            this.num = num;
        }

        public char getLet() {
            return let;
        }

        public void setLet(char let) {
            this.let = let;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "{" +
                    "let=" + let +
                    ", num=" + num +
                    '}';
        }
    }
    ///

    public static Node<CharInt> zip(Node<Character> chain) {

        if (chain == null)
            return null;

        int count = 1;
        char ch = chain.getValue();

        Node<CharInt> newNode = new Node<>();
        Node<CharInt> index = newNode;

        chain = chain.getNext();

        while (chain != null) {
            if (ch != chain.getValue()) {
                index.setNext(new Node<>(new CharInt(ch, count)));
                index = index.getNext();
                count = 1;
                ch = chain.getValue();

            } else count++;

            chain = chain.getNext();
        }

        index.setNext(new Node<>(new CharInt(ch, count)));

        return newNode.getNext();
    }

    public static Node<Character> unZip(Node<CharInt> chain) {

        if (chain == null)
            return null;

        Node<Character> newNode = new Node<>();
        Node<Character> index = newNode;

        while (chain != null) {

            for (int i = 0; i < chain.getValue().num; i++) {
                index.setNext(new Node<>(chain.getValue().let));
                index = index.getNext();
            }
            chain = chain.getNext();
        }
        return newNode.getNext();

    }

    public static void main(String[] args) {

        Node<Character> n1 = new Node<>('k');
        Node<Character> n2 = new Node<>('k');
        Node<Character> n3 = new Node<>('b');
        n1.setNext(n2);
        n2.setNext(n3);


        System.out.println("A.");
        n1.printList();
        Node<CharInt> ziped = zip(n1);
        ziped.printList();

        System.out.println("B.");
        ziped.printList();
        unZip(ziped).printList();
    }
}


