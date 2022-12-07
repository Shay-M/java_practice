package Tests2022;

public class Stack<T> {
    private Node<T> first;

    public Stack() {
        this.first = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void push(T x) {
        this.first = new Node<T>(x, this.first);
    }

    public T pop() {
        T x = this.first.getValue();
        this.first = this.first.getNext();
        return x;
    }

    public T top() {
        return this.first.getValue();
    }

    public String toString() {
        if (this.isEmpty()) {
            return "-> []]|";
        }
        String str = "-> [";
        Node<T> pos = this.first;
        while (pos.hasNext()) {
            str = str + pos.getValue() + ",";
            pos = pos.getNext();
        }
        str = str + pos.getValue() + "]]|";
        return str;
    }

    /*public int size() {
        int counter = 0;
        Node<T> temp = this.first;
        while (temp != null) {
            counter++;
            temp = temp.getNext();
        }
        System.out.println("size:");
        return counter;
    }*/
}
