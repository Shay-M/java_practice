package Tests2022;

public class Queue<T> {

    private Node<T> end, first;

    public Queue() {
        this.end = null;
        this.first = end;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void insert(T x) {

        if (isEmpty()) {
            end = new Node<T>(x);
            this.first = end;
        } else {
            Node<T> temp = new Node<T>(x);
            this.end.setNext(temp);
            this.end = temp;

        }


//        this.end = new Node<T>(x);


    }

    public T pop() {
        T x = this.first.getValue();
        this.first = this.first.getNext();
        return x;
    }

    public T remove() {
        if (!isEmpty()) {

            T x = this.first.getValue();
            if (this.first.hasNext())
                this.first = this.first.getNext();
            else
                first = null;
            return x;

        } else {

            return null;
        }
    }

    public T head() {
        return this.end.getValue();
    }

    public String toString() {

        if (this.isEmpty())
            return "<- <-";

        String str = "<- ";
        Node<T> pos = this.first;
        while (pos.hasNext()) {
            str = str + pos.getValue() + " , ";
            pos = pos.getNext();
        }
        str = str + pos.getValue() + " <-";
        return str;
    }

}


