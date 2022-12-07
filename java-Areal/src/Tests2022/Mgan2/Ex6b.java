package Tests2022.Mgan2;

import Tests2022.Node;

public class Ex6b {
    //   {  -> 8  -> 4  -> -1  -> 5  -> -1  -> 1  -> 2  -> 3  -> -1  -> Null } => {  -> 84  -> 5  -> 123  -> Null }
    public static Node<Integer> DigitsToNumber(Node<Integer> lst) {

        if (lst == null)
            return null;

        int sum = 0;
        Node<Integer> newList = new Node<>();
        Node<Integer> head = newList;

        while (lst != null) {
            if (lst.getValue() == -1) {
                newList.setNext(new Node<>(sum));
                newList = newList.getNext();
                sum = 0;
            } else {
                sum *= 10;
                sum += lst.getValue();
            }
            lst = lst.getNext();
        }
        return head.getNext();
    }

    //    {  -> 84  -> 5  -> 123  -> Null } =>  {  -> 8  -> 4  -> -1  -> 5  -> -1  -> 1  -> 2  -> 3  -> -1  -> Null }
   /* public static Node<Integer> NumberToDigits(Node<Integer> lst) {

        Node<Integer> newList = new Node<>();
        Node<Integer> head = newList;

        int num;

        while (lst != null) {
            num = lst.getValue();
            while (num != 0) {

                newList.setNext(new Node<>(num % 10));
                num = num / 10;
                newList = newList.getNext();
            }

            newList.setNext(new Node<>(-1));

            newList = newList.getNext();
            lst = lst.getNext();

        }

        return head;
    }*/

    private static int CountsDigits(Node<Integer> lst) {

        if (lst == null)
            return 0;

        int num, sumDigits = 0;

        while (lst != null) {
            num = lst.getValue();
            while (num != 0) {
                num = num / 10;
                sumDigits++;
            }
            lst = lst.getNext();
        }
        return sumDigits;
    }


    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(8);
        Node<Integer> n2 = new Node<>(4);
        Node<Integer> n3 = new Node<>(-1);
        Node<Integer> n4 = new Node<>(5);
        Node<Integer> n5 = new Node<>(-1);
        Node<Integer> n6 = new Node<>(1);
        Node<Integer> n7 = new Node<>(2);
        Node<Integer> n8 = new Node<>(3);
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

        n1.printList();
        DigitsToNumber(n1).printList();
        Node<Integer> temp = DigitsToNumber(n1);

       /* System.out.println();
        System.out.println("B.");
        temp.printList();
        NumberToDigits(temp).printList();*/

        System.out.println();
        System.out.println("B.");
        temp.printList();
        System.out.println(CountsDigits(temp));


    }


}
