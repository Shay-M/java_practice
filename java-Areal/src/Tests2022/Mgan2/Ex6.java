package Tests2022.Mgan2;

import Tests2022.Node;

public class Ex6 {

    public static Node<Integer> moveToHead(Node<Integer> chain, int N) {

        if (chain == null)
            return null;

        Node<Integer> head = chain;
        int count = 0;

        while (chain != null) {
            count++;
            chain = chain.getNext();
        }

        N = count - N;
        count = 0;
        chain = head;

        for (int i = 0; i < N; i++)
            chain = chain.getNext();

        Node<Integer> newStart = chain;

        // find the old end
        while (chain.hasNext())
            chain = chain.getNext();

        chain.setNext(head);
        chain = newStart.getNext();
        newStart.setNext(null);

        return chain;
    }

    public static Node<Integer> moveToTail(Node<Integer> chain, int N) {

        if (chain == null)
            return null;

        Node<Integer> head = chain;

        while (chain.hasNext())
            chain = chain.getNext();

        Node<Integer> theEnd = chain;
        chain = head;

        theEnd.setNext(head);

        for (int i = 0; i < N - 1; i++)
            chain = chain.getNext();

        head = chain.getNext();
        chain.setNext(null);

        return head;
    }


    public static void main(String[] args) {

        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n7 = new Node<>(7);
        Node<Integer> n8 = new Node<>(8);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        n1.printList();
        System.out.println();
//        moveToHead(n1, 3).printList();
        moveToTail(n1, 2).printList();
//        n1.printList();


    }
}
