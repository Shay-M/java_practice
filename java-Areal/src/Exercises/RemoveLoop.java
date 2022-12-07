package Exercises;

import Tests2022.Node;

// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
public class RemoveLoop {

    public static Node<Integer> detectLoop(Node<Integer> chain) {
        Node<Integer> slow_p = chain, fast_p = chain;

        while (slow_p != null && fast_p != null && fast_p.getNext() != null) {
            slow_p = slow_p.getNext();
            fast_p = fast_p.getNext().getNext();

            if (slow_p == fast_p) {
                return slow_p;
            }
        }
        return null;
    }

    private static void removeLoop(Node<Integer> loop, Node<Integer> head) {
        Node<Integer> ptr1 = loop;
        Node<Integer> ptr2 = loop;

        // Count the number of nodes in loop
        int k, i;

        for (k = 1; ptr1.getNext() != ptr2; k++)
            ptr1 = ptr1.getNext();

        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++)
            ptr2 = ptr2.getNext();

        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.getNext();
            ptr2 = ptr2.getNext();
        }

        // Get pointer to the last node
        while (ptr2.getNext() != ptr1) {
            ptr2 = ptr2.getNext();
        }

        /* Set the next node of the loop ending node to fix the loop */
        ptr2.setNext(null);
    }

    // Function to print the linked list
    public static void print(Node<Integer> chain) {
        System.out.print("{ ");
        while (chain != null) {
            System.out.print(chain);
            chain = chain.getNext();
        }
        System.out.print(" -> Null }");
    }

    public static void main(String[] args) {
        System.out.println("first");

//        Node<Integer> first = new Node<>(1);
//        Node<Integer> first2 = new Node<>(2);
//        Node<Integer> first3 = new Node<>(3);
//        Node<Integer> first4 = new Node<>(4);
//        first.setNext(first2);
//        first2.setNext(first3);
//        first3.setNext(first4);
//        first4.setNext(first2);

        Node<Integer> first = new Node<>(1);
        Node<Integer> first2 = new Node<>(2);
        Node<Integer> first3 = new Node<>(3);
        Node<Integer> first4 = new Node<>(4);
        Node<Integer> first5 = new Node<>(5);
        first.setNext(first2);
        first2.setNext(first3);
        first3.setNext(first4);
        first4.setNext(first5);
        first5.setNext(first3);

//        print(first); // loop

        if (detectLoop(first) != null) {
            System.out.println("fixLoop(first), Loop Appeared in: " + detectLoop(first) + "node!");
            removeLoop(detectLoop(first), first);

        } else System.out.println("fixLoop(first), Loop not found.");

        print(first);
        ////////////////////////////////////////////
        System.out.println();
        System.out.println("second");

        Node<Integer> second = new Node<>(1);
        Node<Integer> second2 = new Node<>(2);
        Node<Integer> second3 = new Node<>(3);
        Node<Integer> second4 = new Node<>(4);
        second.setNext(second2);
        second2.setNext(second3);
        second3.setNext(second4);

        if (detectLoop(second) != null) {
            System.out.println("fixLoop(second), Loop Appeared in: " + detectLoop(second) + "node!");
            removeLoop(detectLoop(second), second);

        } else System.out.println("fixLoop(second), Loop not found.");

        print(second);

    }

}
