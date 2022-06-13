package Tests2022.Mgan;

import Tests2022.Queue;
import Tests2022.Stack;

public class Ex5 {

    public static Boolean func(Queue<Integer> queue1, Queue<Integer> queue2) {

        if (queue1 == null || queue2 == null || queue1.isEmpty() || queue2.isEmpty())
            return true;

        boolean flag = true;
        int countQ1 = 0;
        int countQ2 = 0;
        Stack<Integer> stack = new Stack<>();

        while (!queue1.isEmpty()) {
            stack.push(queue1.remove());
            countQ1++;
        }

        while (!queue2.isEmpty()) {
            queue1.insert(queue2.remove());
            countQ2++;
        }

        if (countQ1 != countQ2)
            flag = false;

        for (int i = 0; i < countQ1; i++) {
            int temp1 = queue1.remove();
            queue2.insert(temp1);

            int temp2 = stack.pop();

            if (temp2 != temp1 && flag)
                flag = false;

            queue1.insert(temp2);
        }

        while (!queue1.isEmpty())
            stack.push(queue1.remove());

        while (!stack.isEmpty())
            queue1.insert(stack.pop());


        return flag;
    }

    public static void main(String[] args) {

        Queue<Integer> queue1 = new Queue<>();
        queue1.insert(1);
        queue1.insert(2);
        queue1.insert(3);

        Queue<Integer> queue2 = new Queue<>();
        queue2.insert(3);
        queue2.insert(2);
        queue2.insert(1);


        System.out.println();
        System.out.println("queue1: " + queue1);

        System.out.println();
        System.out.println("queue2: " + queue2);

        System.out.println(func(queue1, queue2));

        System.out.println();
        System.out.println("queue1: " + queue1);

        System.out.println();
        System.out.println("queue2: " + queue2);

    }
}
