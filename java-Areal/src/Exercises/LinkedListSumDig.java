package Exercises;

import Tests2022.Node;

public class LinkedListSumDig {

    public static Node<Integer> sumList(Node<Integer> chain1, Node<Integer> chain2) {

        if (chain1 == null)
            return chain2;
        else if (chain2 == null)
            return chain1;

        Node<Integer> newSumList = new Node<>();

        Node<Integer> head = newSumList;

        int cary = 0;
        int sum;

        while (chain1 != null && chain2 != null) {
            sum = chain1.getValue() + chain2.getValue() + cary;
//            newSumList.setValue(sum % 10);
            newSumList.setNext(new Node<>(sum % 10));
            newSumList = newSumList.getNext();
            cary = sum / 10;

            chain1 = chain1.getNext();
            chain2 = chain2.getNext();

        }

        while (chain1 != null) {
            sum = cary + chain1.getValue();
//            newSumList.setValue();
            newSumList.setNext(new Node<>(sum % 10));
            newSumList = newSumList.getNext();
            cary = sum / 10;
            chain1 = chain1.getNext();
        }

        while (chain2 != null) {
            sum = cary + chain2.getValue();
//            newSumList.setValue();
            newSumList.setNext(new Node<>(sum % 10));
            newSumList = newSumList.getNext();
            cary = sum / 10;
            chain2 = chain2.getNext();
        }

        if (cary > 0) {
            newSumList.setValue(cary);
        }

        return head.getNext();

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

        Node<Integer> first = new Node<>(3);
        Node<Integer> first2 = new Node<>(5);
        first.setNext(first2);


        Node<Integer> second = new Node<>(2);
        Node<Integer> second2 = new Node<>(6);
        Node<Integer> second3 = new Node<>(8);
        second.setNext(second2);
        second2.setNext(second3);

        print(first);
        System.out.println();
        System.out.println("+");
        print(second);
        System.out.println();
        System.out.println("=");
        print(sumList(first, second));

    }


}
