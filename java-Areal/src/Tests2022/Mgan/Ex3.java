package Tests2022.Mgan;

import Tests2022.Node;

import java.util.Arrays;

public class Ex3 {

    public static int[][] func(Node<Integer> chain) {
        if (chain == null)
            return null;

        int count = 0;
        Node<Integer> temp = chain;

        while (temp != null) {
            count++;
            temp = temp.getNext();
        }

        int[][] arr = new int[count][];

        temp = chain;

        int j, i;

        for (i = 0; i < count; i++) {

            arr[i] = new int[temp.getValue() + 1];
            arr[i][0] = 1;

            for (j = 1; j < temp.getValue(); j++)
                arr[i][j] = arr[i][j - 1] * 2;

            arr[i][j] = 0;

            temp = temp.getNext();
        }

        return arr;
    }

    public static void main(String[] args) {

        Node<Integer> n1 = new Node<>(3);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(2);
        Node<Integer> n4 = new Node<>(1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        System.out.println(Arrays.deepToString(func(n1)));
    }

}
