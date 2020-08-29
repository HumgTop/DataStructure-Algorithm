package interview.农业银行;

import java.util.Stack;

public class Question1 {
    public static void main(String[] args) {
        String s = new Question1().triCoding(123);
        System.out.println(s);
    }

    public String triCoding(int num) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while (num / 3 != 0) {
            int value = num % 3;
            if (value == 0) {
                stack.push('@');
            } else if (value == 1) {
                stack.push('$');
            } else
                stack.push('&');

            num /= 3;
        }
        if (num == 0) {
            stack.push('@');
        } else if (num == 1) {
            stack.push('$');
        } else
            stack.push('&');

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
