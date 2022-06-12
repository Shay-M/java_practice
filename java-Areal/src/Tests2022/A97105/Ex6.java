package Tests2022.A97105;

import Tests2022.Node;

public class Ex6 {

    public static Node<Double> averageList(Node<Integer> lst) {
        int counter = 0;
        double sum = 0;

        Node<Double> newList = new Node<>();
        Node<Double> head = newList;

        while (lst != null) {
            if (lst.getValue() == -1) {
                newList.setNext(new Node<>(sum / counter));
                newList = newList.getNext();
                counter = 0;
                sum = 0;
            } else {
                counter++;
                sum += lst.getValue();
            }
            lst = lst.getNext();
        }
        return head.getNext(); // []->[v]
    }

    public static void print(Node<Integer> lst) {
        int counter = 0;
        double sum = 0;
        int id = 1;
        int minGrade = 101; // can also use Integer.MAX_VALUE;

        while (lst != null) {
            if (lst.getValue() == -1) {

                if (counter > 1)
                    System.out.println(id + "\t" + (sum / counter) + "\t" + (sum - minGrade) / (counter - 1));
                else
                    System.out.println(id + "\t" + (sum / counter) + "\t" + (sum / counter));

                counter = 0;
                sum = 0;
                minGrade = 101;
                id++;

            } else {
                if (lst.getValue() < minGrade)
                    minGrade = lst.getValue();

                counter++;
                sum += lst.getValue();
            }
            lst = lst.getNext();
        }
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(80);
        Node<Integer> n2 = new Node<>(40);
        Node<Integer> n3 = new Node<>(90);
        Node<Integer> n4 = new Node<>(-1);
        Node<Integer> n5 = new Node<>(95);
        Node<Integer> n6 = new Node<>(-1);
        Node<Integer> n7 = new Node<>(85);
        Node<Integer> n8 = new Node<>(80);
        Node<Integer> n9 = new Node<>(-1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);

        System.out.println("A.");
        Node<Double> chain = averageList(n1);

        while (chain != null) {
            System.out.print("{ ");
            while (chain != null) {
                System.out.print(chain);
                chain = chain.getNext();
            }
            System.out.print(" -> Null }");
        }

        System.out.println();

        System.out.println("B.");
        print(n1);
    }
}