package Tests2022.Mgan;

import Tests2022.Node;

public class Ex3 {

    public static int[][] func(Node<Integer> chain) {
        if (chain == null)
            return new int[0][0];

        int count = 0;
        Node<Integer> temp = chain;

        while (temp != null) {
            count++;
            temp = temp.getNext();
        }

        int[] Column = new int[count];
        temp = chain;

        for (int i = 0; i < count; i++) {

            int[] Row = new int[temp.getValue()];
            Column = Row;
            Column = new int[temp.getValue()];
            for (int j = 0; j < temp.getValue(); j++) {

            }

            temp.getValue();
            temp = temp.getNext();
        }
        while (temp != null) {

        }


    }

    public static void main(String[] args) {

    }


//    int **list_to_powers_of_two (Item *lst, int *rows_num)
//    {
//        int **arr, i, j, size = list_size(lst);
//        arr = (int **)calloc(size, sizeof(int *));
//        for (i=0; i<size; i++)
//        {
//            arr[i] = (int *)calloc(lst->data+1, sizeof(int));
//            arr[i][0] = 1;
//            for (j=1; j < lst->data; j++)
//                arr[i][j] = arr[i][j-1]*2;
//            arr[i][j] = 0;
//            lst = lst->next;
//        }
//	*rows_num = size;
//        return arr;
//    }

}
