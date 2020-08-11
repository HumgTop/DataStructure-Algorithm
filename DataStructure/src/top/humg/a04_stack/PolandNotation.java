package top.humg.a04_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    private String suffixExpression;    //待计算的逆波兰表达式

    public PolandNotation(String suffixExpression) {
        this.suffixExpression = suffixExpression;
    }

    /**
     * 将逆波兰表达式存入List集合中，并返回list集合
     *
     * @return
     */
    public List<String> getListString() {
        String[] split = suffixExpression.split(" ");   //以空格分割字符串
        return new ArrayList<>(Arrays.asList(split));
    }

    /**
     * 完成对表达式的计算
     * 从左至右扫描表达式
     * 遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 和 栈顶元素），并将结果入栈；
     * 重复上述过程直到表达式最右端
     *
     * @return 计算结果
     */
    public int myCal() {
        List<String> list = getListString();    //获取表达式的list集合
        Stack<Integer> stringStack = new Stack<>(); //运算结果的存储栈
        list.forEach(each -> {
            //如果遍历到运算符
            if (each.charAt(0) == 43 || each.charAt(0) == 45 || each.charAt(0) == 42 || each.charAt(0) == 47) {
                int num1 = stringStack.pop(); //被减数、被除数
                int num2 = stringStack.pop();
                switch (each) {
                    case "+":
                        stringStack.push(num1 + num2);
                        break;
                    case "-":
                        stringStack.push(num2 - num1);
                        break;
                    case "*":
                        stringStack.push(num1 * num2);
                        break;
                    case "/":
                        stringStack.push(num2 / num1);
                }
            } else {
                int operand = Integer.parseInt(each);   //将操作数转为int型
                stringStack.push(operand);  //操作数入栈
            }
        });
        //最后栈中的唯一元素即为计算结果
        return stringStack.pop();
    }

    /**
     * 网课demo
     * @return
     */
    public int cal() {
        List<String> list = getListString();    //获取表达式的list集合
        Stack<Integer> stringStack = new Stack<>(); //运算结果的存储栈
        list.forEach(each -> {
            //如果字符串匹配到数字（使用正则表达式）
            if (each.matches("\\d+")) {
                int operand = Integer.parseInt(each);   //将操作数转为int型
                stringStack.push(operand);  //操作数入栈
            } else {
                int num1 = stringStack.pop(); //被减数、被除数
                int num2 = stringStack.pop();
                switch (each) {
                    case "+":
                        stringStack.push(num1 + num2);
                        break;
                    case "-":
                        stringStack.push(num2 - num1);
                        break;
                    case "*":
                        stringStack.push(num1 * num2);
                        break;
                    case "/":
                        stringStack.push(num2 / num1);
                }
            }
        });
        //最后栈中的唯一元素即为计算结果
        return stringStack.pop();
    }
}
