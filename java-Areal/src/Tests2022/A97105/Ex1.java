package Tests2022.A97105;

import Tests2022.Node;

public class Ex1 {

    // {  -> 1  -> 2  -> 3  -> 4  -> Null }
    // {  -> 1  -> 1  -> 2  -> 2  -> 3  -> 3  -> 4  -> 4  -> Null }
    public static void first(Node<Integer> chain) {

        while (chain != null) {
            Node<Integer> copy = new Node<>(chain.getValue()); // [v]
            copy.setNext(chain.getNext()); //[v]->[c].next
            chain.setNext(copy);

            chain = copy.getNext();
        }
    }

    // {  -> 1  -> 2  -> 3  -> 4  -> Null }
    // {  -> 1  -> 2  -> 3  -> 4  -> 1  -> 2  -> 3  -> 4  -> Null }
    public static void second(Node<Integer> chain) {

        if (chain == null)
            return;

        Node<Integer> copy = new Node<>(chain.getValue());
        Node<Integer> index = copy;
        chain = chain.getNext();

        //Copy chain to 'copy' list
        while (chain.hasNext()) {
            index.setNext(new Node<>(chain.getValue()));
            index = index.getNext();
            chain = chain.getNext();
        }

        index.setNext(new Node<>(chain.getValue()));
        chain.setNext(copy);

    }

    public static void print(Node<Integer> chain) {
        System.out.print("{ ");
        while (chain != null) {
            System.out.print(chain);
            chain = chain.getNext();
        }
        System.out.print(" -> Null }");
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

        print(n1);
        System.out.println();

        System.out.println("first:");
        first(n1);
        print(n1);
        System.out.println();

        System.out.println("second:");
        second(n11);
        print(n11);
        System.out.println();
    }
}
