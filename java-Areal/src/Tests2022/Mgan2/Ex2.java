package Tests2022.Mgan2;

import Tests2022.Queue;
import Tests2022.Stack;

public class Ex2 {

    public static int distance(Stack<Integer> stack, int x, int y) {

        if (stack == null || stack.isEmpty())
            return -1;

        int counter = -1;
        boolean flag = false;
        int varFromStack;

        while (!stack.isEmpty()) {

            varFromStack = stack.pop();

            if ((varFromStack == x || varFromStack == y))
                flag = !flag;

            if (flag)
                counter++;

        }

        return counter;
    }

    public static int distance2(Stack<Integer> stack, int x, int y) {

        if (stack == null || stack.isEmpty())
            return -1;

        int counter = -1;
        boolean flag = false;
        int varFromStack;

        while (!stack.isEmpty()) {

            varFromStack = stack.pop();

            if ((varFromStack == x || varFromStack == y))
                flag = !flag;

            if (flag)
                counter++;

        }

        return counter;
    }


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(12);
        stack.push(2);
        stack.push(10);
        stack.push(7);
        stack.push(5);

        System.out.println(distance(stack, 12, 7));


        /*Queue<Integer> queue1 = new Queue<>();
        queue1.insert(1);
        queue1.insert(2);
        queue1.insert(3);

        System.out.println();
        System.out.println("queue1 before: " + queue1);
        System.out.println();
        System.out.println("queue1:  after " + queue1);
        System.out.println();
        System.out.println(copy(queue1));*/


    }
//////////////////////////////////////
    public static Stack<Integer> copy(Queue<Integer> queue) {

        if (queue == null || queue.isEmpty())
            return null;

        Stack<Integer> temp = new Stack<>();
        Queue<Integer> tempQueue = new Queue<>();

        int var;
        while (!queue.isEmpty()) {
            var = queue.remove();
            temp.push(var);
            tempQueue.insert(var);
        }

        while (!temp.isEmpty())
            queue.insert(temp.pop());

        while (!queue.isEmpty()) {
            var = queue.remove();
            temp.push(var);
        }

        while (!tempQueue.isEmpty())
            queue.insert(tempQueue.remove());

        return temp;
    }


}
