package top.humg.ds04_stack;

import java.util.regex.Pattern;

/**
 * 综合计算器
 */
public class Calculator {
    private ArrayStack operandStack = new ArrayStack(20);  //数栈：存入操作数
    private ArrayStack operatorStack = new ArrayStack(20);  //符号栈：存入运算符

    /**
     * 对表达式进行计算（个位数的运算），并返回计算结果
     *
     * @param expression
     * @return
     */
    public int calculate(String expression) {
        int[] operands = getOperands(expression);  //操作数数组
        int[] operators = getOperators(expression);    //运算符数组
        int num1;
        int num2;
        int operator;
        int calResult;
        //执行入栈操作
        for (int i = 0; i < operators.length; i++) {
            int curOperand = operands[i];   //当前准备入栈操作数
            int curOperator = operators[i]; //当前准备入栈运算符
            operandStack.push(curOperand); //操作数入栈
            //如果符号栈已存入运算符
            //栈为空直接入栈
            if (!operatorStack.isEmpty()) {
                //比较当前运算符与符号栈顶运算符的优先级
                int curPriority = getPriority(curOperator);    //当前运算符优先级
                int topPriority = getPriority(operatorStack.getTopElement());  //获取栈顶运算符的优先级
                //如果当前运算符优先级小于等于栈顶运算符
                if (curPriority <= topPriority) {
                    //数栈出栈2个元素，符号栈出栈一个元素进行运算，结果存入数栈
                    num1 = operandStack.pop();
                    num2 = operandStack.pop();
                    operator = operatorStack.pop();
                    calResult = cal(num1, num2, operator);
                    operandStack.push(calResult);   //计算结果入栈
//                    System.out.println(calResult);
                }
            }
            //因为运算符的个数比操作数少一个
            operatorStack.push(curOperator);    //运算符入栈
        }
        //最后一个操作数入栈
        operandStack.push(operands[operands.length - 1]);
        //当数栈为空时，循环结束
        while (true) {
            //顺序出栈，进行运算
            num1 = operandStack.pop();
            num2 = operandStack.pop();
            operator = operatorStack.pop();
            calResult = cal(num1, num2, operator);
//            System.out.println(calResult);
            //数栈第一次为空时
            if (operandStack.getTop() == -1) {
                break;
            }
            operandStack.push(calResult);   //计算结果入栈
        }
        return calResult;
    }

    /**
     * 从表达式中获取操作数数组
     *
     * @param expression
     * @return
     */
    private int[] getOperands(String expression) {
        //正则表达式，用于匹配非数字串，+号用于匹配出多个非数字串
        String regEx = "\\D+";  //匹配非数字字符串
        Pattern pattern = Pattern.compile(regEx);
        //用定义好的正则表达式拆分字符串，把字符串中的数字留出来
        String[] split = pattern.split(expression);
        //将操作数存入int数组
        int[] operands = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            operands[i] = Integer.parseInt(split[i]); //将操作数转为int类型
        }
        return operands;
    }

    /**
     * 从表达式中获取运算符数组，并返回运算符代号
     * +为1
     * -为2
     * *为3
     * /为4
     *
     * @param expression
     * @return 返回的字符串数组第一个元素为空
     */
    private int[] getOperators(String expression) {
        String regEx = "\\d+";  //匹配数字字符串
        String[] split = expression.split(regEx);
        int[] result = new int[split.length - 1];
        //从索引为1开始遍历
        for (int i = 1; i < split.length; i++) {
            switch (split[i]) {
                case "+":
                    result[i - 1] = 1;
                    break;
                case "-":
                    result[i - 1] = 2;
                    break;
                case "*":
                    result[i - 1] = 3;
                    break;
                case "/":
                    result[i - 1] = 4;
                    break;
            }
        }
        return result;
    }

    /**
     * 传入一个运算符，返回它的优先级
     *
     * @param operator
     * @return
     */
    private int getPriority(int operator) {
        if (operator == 3 || operator == 4) {
            return 1;
        } else if (operator == 1 || operator == 2) {
            return 0;
        } else
            throw new RuntimeException("运算符输入有误");
    }

    /**
     * 分步两两计算计算返回结果
     *
     * @param num1     先出栈的元素：被减数、被除数
     * @param num2
     * @param operator 运算符
     * @return
     */
    private int cal(int num1, int num2, int operator) {
        switch (operator) {
            case 1:
                return num1 + num2;
            case 2:
                return num2 - num1;
            case 3:
                return num1 * num2;
            case 4:
                return num2 / num1;
        }
        throw new RuntimeException("运算符输入出错");
    }
}
