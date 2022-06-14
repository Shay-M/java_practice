package Tests2022.Mgan;

import Tests2022.Node;

public class Ex8a {


    static void RemoveDuplicates(Node<Integer> first) {
        Node<Integer> current = first;

        while (current != null) {

            current.setNext(RemoveAllValueFromList(current.getNext(), current.getValue()));

            current = current.getNext();
        }
    }


    static Node<Integer> RemoveAllValueFromList(Node<Integer> first, int valueToRemove) {

        if (first == null)
            return null;

        while (first.getValue() == valueToRemove) {
            first = first.getNext();

            if (first == null)
                return null;
        }

        Node<Integer> current = first;

        while (current.getNext() != null) {
            if (current.getNext().getValue() == valueToRemove) {
                Node<Integer> nodeToRemove = current.getNext();
                current.setNext(nodeToRemove.getNext());
                nodeToRemove.setNext(null);
            } else
                current = current.getNext();
        }
        return first;
    }

    public static void main(String[] args) {

        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(2);
        Node<Integer> n4 = new Node<>(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);


        n1.printList();
        System.out.println();
        RemoveDuplicates(n1);
        n1.printList();
        System.out.println();


    }
}
