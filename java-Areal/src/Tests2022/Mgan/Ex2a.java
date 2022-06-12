package Tests2022.Mgan;

import Tests2022.Stack;

public class Ex2a {

    public static Boolean func(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++)
            stack.push(str.charAt(i));

        for (int i = 0; i < str.length(); i++)
            if (stack.pop() != str.charAt(i))
                return false;

        return true;

    }

    public static void main(String[] args) {

        System.out.println(func("abCba"));
        System.out.println(func("abCbb"));
    }
}
