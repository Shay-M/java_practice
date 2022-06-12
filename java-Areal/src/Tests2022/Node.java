package Tests2022;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String toString() {
        return " -> " + this.value + " ";
    }


    public void printList() {
        int count = 0;
        int LOOPS_LIMIT = 12;
        Node<T> chain = this;

        System.out.print("{ ");
        while (chain != null && count++ <= LOOPS_LIMIT) {
            System.out.print(chain);
            chain = chain.getNext();
        }
        if (count <= LOOPS_LIMIT)
            System.out.print(" -> Null } ");
        else System.out.print(" -> ..... WE HAVE LOOP !!! }");

        System.out.println();
    }


}
