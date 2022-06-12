package Tests2022.Mgan;

import Tests2022.Node;

public class Ex1b {

    public static Boolean func(Node<Integer> chain) {
        int count = 0;

        if (chain == null)
            return true;

        Node head = chain;

        while (chain.hasNext()) {

            Node index = head;
            while (index != null) {

                if (chain.getValue() == index.getValue())
                    count++;

                index = index.getNext();
            }

            if (count == 1) {
                return false;
            } else count = 0;

            chain = chain.getNext();

        }

        return true;
    }

    public static void main(String[] args) {

        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(2);
//        Node<Integer> n3 = new Node<>(1);
        Node<Integer> n4 = new Node<>(1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        System.out.println(func(n1));


    }
}
