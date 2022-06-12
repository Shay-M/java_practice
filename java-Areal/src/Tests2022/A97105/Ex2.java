package Tests2022.A97105;

/* כתבו פעולה המקבלת מחסנית של מספרים שלמים. הפעולה תמיין מחדש את האיברים במחסנית
 לפי הסדר הבא: איברים הגדולים מממוצע האיברים במחסנית, יישמרו בחלק העליון של המחסנית
        ואילו איברים קטנים או שווים לממוצע האיברים במחסנית יישמרו בחלק התחתון.*/


import Tests2022.Stack;

public class Ex2 {
    public static void sort(Stack<Integer> stack) {

        if (stack == null || stack.isEmpty())
            return;

        Stack<Integer> temp = new Stack<>();

        double sum = 0;
        int counter = 0;
        double avg;

        //// O(n), Calculating the average
        while (!stack.isEmpty()) {
            counter++;
            sum += stack.top();
            temp.push(stack.pop());
        }
        avg = sum / counter;


        //// O(n), Divide into 2 Stacks
        Stack<Integer> bigAvg = new Stack<>();
        Stack<Integer> smallEqualAvg = new Stack<>();

        while (!temp.isEmpty()) {
            if (temp.top() > avg)
                bigAvg.push(temp.pop());
            else
                smallEqualAvg.push(temp.pop());
        }


        //// O(n), Union the 2 Stacks to 1 , first the small
        while (!smallEqualAvg.isEmpty()) {
            stack.push(smallEqualAvg.pop());
        }
        while (!bigAvg.isEmpty()) {
            stack.push(bigAvg.pop());
        }

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

        sort(stack);
        System.out.println(stack);
        // -> [12,10 | 6,2,7,5]|
    }
}