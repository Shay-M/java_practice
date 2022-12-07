package Tests2022.B97105;

import Tests2022.Stack;

public class Ex2 {

    public static void smallBotBigTop(Stack<Integer> stack) {

        if (stack == null || stack.isEmpty())
            return;

        int theSmallest = stack.pop();
        if (stack.isEmpty()) {
            stack.push(theSmallest);
            return; // was only one element
        }

        Stack<Integer> temp = new Stack<>();

        // O(n),find the Smallest
        while (!stack.isEmpty()) {
            if (stack.top() < theSmallest) {
                temp.push(theSmallest);
                theSmallest = stack.pop();
            } else temp.push(stack.pop());
        }

        stack.push(theSmallest);

        // O(n),find the Biggest
        int theBiggest = temp.pop();

        while (!temp.isEmpty()) {
            if (temp.top() > theBiggest) {
                stack.push(theBiggest);
                theBiggest = temp.pop();
            } else stack.push(temp.pop());
        }

        stack.push(theBiggest);


    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(12);
        stack.push(2);
        stack.push(10);
        stack.push(7);
        stack.push(5);

        System.out.println(stack);
        // -> [5,7,10,2,12,6]|

        smallBotBigTop(stack);
        System.out.println(stack);
        // ->
    }
}
