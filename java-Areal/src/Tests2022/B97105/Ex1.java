package Tests2022.B97105;

import Tests2022.Node;
import Tests2022.PrintList;

public class Ex1 {
    // {  -> 1  -> 2  -> 3  -> 4  -> Null }
    // {  -> 1  -> 2  -> 3  -> 4  -> 1  -> 2  -> 3  -> 4  -> 1  -> 2  -> 3  -> 4  -> 1  -> ..... WE HAVE LOOP !!! }
    public static void toCircle(Node<Integer> chain) {
        if (chain == null)
            return;

        Node<Integer> index = chain;

        while (index.getNext() != null) {
            index = index.getNext();
        }
        index.setNext(chain);

    }


    public static void toLine(Node<Integer> chain) {

        if (chain == null)
            return;

        Node<Integer> index = chain;

        while (index.getNext() != chain) {
            index = index.getNext();
        }
        index.setNext(null);

    }


    public static void main(String[] args) {

        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        Node<Integer> n11 = new Node<>(1);
        Node<Integer> n22 = new Node<>(2);
        Node<Integer> n33 = new Node<>(3);
        Node<Integer> n44 = new Node<>(4);
        n11.setNext(n22);
        n22.setNext(n33);
        n33.setNext(n44);
        n44.setNext(n11);

        n1.printList();
        System.out.println();

        System.out.println("first:");
        toCircle(n1);
        n1.printList();
        System.out.println();

        System.out.println("second:");
        n11.printList();
        System.out.println();

        toLine(n11);
        n11.printList();
        System.out.println();

    }
}
