package Tests2022.B97105;

import Tests2022.Queue;
import Tests2022.Stack;

public class Ex7 {
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();
        queue.insert(6);
        queue.insert(12);
        queue.insert(2);
        queue.insert(10);
        queue.insert(7);
        queue.insert(5);

        System.out.println(queue);
        System.out.println(queue.head());
        queue.remove();
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }

}

//class DoubleQueue {
// private


