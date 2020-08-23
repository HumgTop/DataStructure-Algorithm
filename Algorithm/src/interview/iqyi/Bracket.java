package interview.iqyi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个只有'(','{','[',')','}',']'的字符串判断是否有效
 * 规则：左括号必须使用相同类型的右括号闭合；左括号必须以正确的顺序闭合
 */
public class Bracket {
    public static void main(String[] args) {
        while (true) {
            System.out.println("请输入字符串");
            Scanner scanner = new Scanner(System.in);
            String string = scanner.next();
            boolean flag = solution(string);
            System.out.println(flag);
        }
    }

    public static boolean solution(String string) {
        char[] brackets = string.toCharArray();
        Stack<Character> left = new Stack<>();
        Queue<Character> right = new LinkedList<>();

        for (char bracket : brackets) {
            if (bracket == '(' || bracket == '{' || bracket == '[' || bracket == ')' || bracket == '}' || bracket == ']') {
                if (bracket == '(' || bracket == '{' || bracket == '[') {
                    //入栈
                    left.push(bracket);
                }
                if (bracket == ')' || bracket == '}' || bracket == ']') {
                    //入队列
                    right.add(bracket);
                }
            } else {
                return false;
            }
        }

        //出栈和出队列匹配
        while (!left.isEmpty()) {
            Character leftElement = left.pop();
            Character rightElement = right.remove();
            //如果left已空，right还有元素或者left还有元素，right已空
            if (left.isEmpty() && !right.isEmpty() ||
                    !left.isEmpty() && right.isEmpty()) {
                return false;
            }
            if (leftElement == '(' && rightElement == ')' ||
                    leftElement == '{' && rightElement == '}' ||
                    leftElement == '[' && rightElement == ']') {
                continue;
            }
            //如果不匹配
            return false;
        }

        return true;
    }
}
