package Tests2022.Mgan;

import Tests2022.BinNode;

public class Ex9 {

    static void print_list(BinNode<Integer> list) {
        while (list != null) {
            System.out.println(list.getValue());
            list = list.getLeft();
        }

    }

    public static void main(String[] args) {
        BinNode<Integer> binNode1 = new BinNode<>(1);
        BinNode<Integer> binNode2 = new BinNode<>(2);
        BinNode<Integer> binNode3 = new BinNode<>(3);

        binNode1.setLeft(binNode2);
        binNode2.setLeft(binNode3);

        binNode3.setRight(binNode2);
        binNode2.setRight(binNode1);

        print_list(binNode1);


    }
}
