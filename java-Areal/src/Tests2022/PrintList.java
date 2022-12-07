package Tests2022;

public class PrintList {

    public static void print(Node<Integer> chain) {
        int count = 0;
        int LOOPS_LIMIT = 12;

        System.out.print("{ ");
        while (chain != null && count++ <= LOOPS_LIMIT) {
            System.out.print(chain);
            chain = chain.getNext();

        }
        if (count <= LOOPS_LIMIT)
            System.out.print(" -> Null }");
        else System.out.print(" -> ..... WE HAVE LOOP !!! }");
    }
}
