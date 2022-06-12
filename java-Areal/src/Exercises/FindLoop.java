package Exercises;

import Tests2022.Node;

public class FindLoop {

    public static void detectLoop(Node<Integer> chain) {

        Node slow_p = chain, fast_p = chain;
        boolean flag = false;

        while (slow_p != null && fast_p != null && fast_p.getNext() != null) {
            slow_p = slow_p.getNext();
            fast_p = fast_p.getNext().getNext();

            // If slow and fast meet at same point then loop is present
            if (slow_p == fast_p) {
                flag = true;
                break;
            }
        }

        if (flag)
            System.out.println("Loop found at: " + slow_p.getValue());
        else
            System.out.println("Loop not found.");
    }

    public static void main(String[] args) {

        Node<Integer> first = new Node<>(1);
        Node<Integer> first2 = new Node<>(2);
        Node<Integer> first3 = new Node<>(3);
        Node<Integer> first4 = new Node<>(4);
        first.setNext(first2);
        first2.setNext(first3);
        first3.setNext(first4);
        first4.setNext(first2);

        detectLoop(first);


    }
}
