package top.humg.ds04_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    private String suffixExpression;    //待计算的逆波兰表达式（后缀表达式）

    //如果表达式还没有转为后缀表达式，则调用空参构造器
    public PolandNotation() {
    }

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
     * 将infixToSuffix方法返回的后缀表达式作为参数传入并计算
     * @param suffixExpression 传入后缀表达式的list集合
     * @return 计算结果
     */
    public int myCal(List<String> suffixExpression) {
        Stack<Integer> stringStack = new Stack<>(); //运算结果的存储栈
        suffixExpression.forEach(each -> {
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
     *
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

    /**
     * 中缀表达式转为后缀表达式
     *
     * @param infixExpression 待处理的中缀表达式
     * @return 后缀表达式的list集合
     */
    public List<String> infixToSuffix(String infixExpression) {
        char[] chars = infixExpression.toCharArray();   //字符串转为字符数组
        Stack<String> operatorStack = new Stack<>();  //符号栈：存入运算符
        ArrayList<String> s2 = new ArrayList<>();   //存放中间结果

        //1 初始化一个list集合，存放初步解析的中缀表达式（一个字符串拆解为多个元素字符串）
        ArrayList<String> tempList = new ArrayList<>();
        //遍历char数组
        for (int index = 0; index < chars.length; index++) {
            char each = chars[index];
            if (Character.isDigit(each)) {
                //因为operand可能会增加长度，所以使用StringBuilder
                StringBuilder operand = new StringBuilder(String.valueOf(each));    //char转string暂存
                //考虑多位数情况
                //如果数组的下一位是数字，**且不是数组的末尾，持续循环
                while (index < chars.length - 1 && Character.isDigit(chars[index + 1])) {
                    operand.append(chars[index + 1]);
                    index++;    //**index后移因为char[index+1]已经被添加，跳过此次遍历
                }
                tempList.add(operand.toString());   //添加到暂存集合中
            } else { //如果是运算符
                String operator = String.valueOf(each);   //转为字符串
                tempList.add(operator); //添加到暂存集合中
            }
        }

        //2 将中缀表达式list集合转为后缀表达式list
        tempList.forEach(each -> {
            //如果是数字
            if (each.matches("\\d+")) {
                s2.add(each);   //操作数直接存入s2
            } else if (each.equals("(")) {
                operatorStack.push(each);   //如果是左括号，直接入栈
            } else if (each.equals(")")) {
                while (true) {
                    //出栈，直到遇到左括号停止（一对括号丢弃）
                    String pop = operatorStack.pop();
                    if (pop.equals("(")) {
                        break;
                    }
                    s2.add(pop);
                }
            } else { //如果是运算符
                while (true) {
                    //如果栈为空，或者栈顶元素为左括号
                    if (operatorStack.isEmpty() || operatorStack.peek().equals("(")) {
                        operatorStack.push(each);   //运算符入栈
                        break;
                    } else if (getPriority(each) > getPriority(operatorStack.peek())) {
                        //如果each的运算优先级高于栈顶运算符优先级，each入栈
                        operatorStack.push(each);
                        break;
                    } else {
                        s2.add(operatorStack.pop());    //栈顶元素弹出加入到s2中
                    }
                }
            }
        });
        //将栈内剩余元素弹出加入到s2中
        while (!operatorStack.isEmpty()) {
            s2.add(operatorStack.pop());
        }
        return s2;
    }

    /**
     * 获取运算符优先级
     *
     * @param operator
     * @return
     */
    private int getPriority(String operator) {
        if (operator.equals("/") || operator.equals("*")) {
            return 1;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 0;
        } else
            throw new RuntimeException("运算符输入有误");
    }
}

