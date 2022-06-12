package Tests2022.Mgan;

import Tests2022.B97105.Ex4;
import Tests2022.Node;

public class Ex1a {

    public static Boolean func(Node<String> chain) {

        int count = 0;

        if (chain == null)
            return true;

        while (chain != null) {

            if (chain.getValue().length() % 2 == count % 2) {
                chain = chain.getNext();
            } else return false;
            count++;

        }

        return true;
    }

    public static void main(String[] args) {

        Node<String> n1 = new Node<>("food"); // 4 V
        Node<String> n2 = new Node<>("is"); // 2 X
        Node<String> n3 = new Node<>("good"); // 4 V
        Node<String> n4 = new Node<>("!");  // 1 V
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);


        System.out.println(func(n1));
    }
}
