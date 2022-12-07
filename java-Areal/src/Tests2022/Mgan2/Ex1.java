package Tests2022.Mgan2;

import Tests2022.Node;

public class Ex1 {

    public static void shrink(Node<Integer> chain) {

        if (chain == null)
            return;

        while (chain != null) {

            chain.setValue(chain.getValue() + chain.getNext().getValue());

            chain.setNext(chain.getNext().getNext());

            chain = chain.getNext();
        }
    }

    ////////////////////////////////////////////
    public static Boolean even(Node<Integer> chain) {

        if (chain == null)
            return false;
        int count = 0;

        while (chain != null) {
            count++;

            if (chain.getValue() % 2 != 0)
                return false;

            chain = chain.getNext();
        }

        return count % 2 == 0;
    }
//.....

    static Node deleteNode(Node<Integer> head_ref, Node<Integer> del) {
        Node<Integer> temp = head_ref;

        // If node to be deleted is head node
        if (head_ref == del)
            head_ref = del.getNext();

        while (temp.getNext() != del)
            temp = temp.getNext();

        temp.setNext(del.getNext());

        return head_ref;
    }

    public static Node<Integer> fixToEven(Node<Integer> chain) {

        if (chain == null)
            return null;

        Node<Integer> head = chain;
        int count = 0;

        while (chain != null) {

            if (chain.getValue() % 2 != 0)
                deleteNode(head, chain);
            else count++;

            chain = chain.getNext();
        }

        if (count % 2 != 0)
            return null;

        return head;
    }

  /*  public static Node<Integer> fixToEven(Node<Integer> chain) {

        if (chain == null)
            return null;

        Node<Integer> head = chain;
        int count = 0;

        while (chain.getNext() != null) {

            if (chain.getValue() % 2 != 0)
                deleteNode(head, chain);
            else count++;

            chain = chain.getNext();
        }

        if (count % 2 != 0 || chain.getValue() % 2 != 0)
            deleteNode(head, chain);

        return head;
    }*/


    public static void main(String[] args) {

//        Node<Integer> n1 = new Node<>(2);
//        Node<Integer> n2 = new Node<>(6);
//        Node<Integer> n3 = new Node<>(8);
//        Node<Integer> n4 = new Node<>(2);
//        Node<Integer> n5 = new Node<>(4);
//        Node<Integer> n6 = new Node<>(8);
//        Node<Integer> n7 = new Node<>(2);
//        Node<Integer> n8 = new Node<>(6);
//        n1.setNext(n2);
//        n2.setNext(n3);
//        n3.setNext(n4);
//        n4.setNext(n5);
//        n5.setNext(n6);
//        n6.setNext(n7);
//        n7.setNext(n8);
//
//        System.out.println("A");
//        n1.printList();
//        System.out.println();
//        shrink(n1);
//        n1.printList();
//
//        System.out.println("---------------------");
//        System.out.println("B");
//
////        Node<Integer> n11 = new Node<>(1);
//        Node<Integer> n11 = new Node<>(8);
//
//        Node<Integer> n22 = new Node<>(2);
//        Node<Integer> n33 = new Node<>(6);
//        Node<Integer> n44 = new Node<>(4);
//        n11.setNext(n22);
//        n22.setNext(n33);
//        n33.setNext(n44);
//
//
//        n11.printList();
//        System.out.println();
//
//        System.out.println("even(n11): " + even(n11));

        System.out.println("---------------------");
        System.out.println("BB");

        Node<Integer> n111 = new Node<>(8);
        Node<Integer> n222 = new Node<>(3);
        Node<Integer> n333 = new Node<>(6);
//        Node<Integer> n444 = new Node<>(7);
        Node<Integer> n444 = new Node<>(4);

        n111.setNext(n222);
        n222.setNext(n333);
        n333.setNext(n444);

        n111.printList();
        System.out.println();
        fixToEven(n111);

        while (n111 != null) {
            System.out.println(n111);
            n111 = n111.getNext();
        }



    }
}

