package Tests2022.Mgan;

import Tests2022.Stack;


public class Ex2b {

    public static void func(Stack<Integer> stack) {

        String A = "";
        String B = "";

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            A = temp + " , " + A;
            B += temp + " , ";

        }
        System.out.println();
        System.out.print(A);

        System.out.println();
        System.out.print(B);

    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(4);
        stack.push(8);

        func(stack);
    }
}
