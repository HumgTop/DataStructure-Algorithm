package top.humg.ds04_stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MyTest {
    @Test
    public void test1() {
        String content = "34+5*6-";
        //正则表达式，用于匹配非数字串，+号用于匹配出多个非数字串
        String regEx = "\\D+";  //匹配非数字字符串
        Pattern pattern = Pattern.compile(regEx);
        //用定义好的正则表达式拆分字符串，把字符串中的数字留出来
        String[] operand = pattern.split(content);
        for (String each : operand) {
            System.out.println(each);
            System.out.println("---");
        }
    }

    @Test
    public void test2() {
        int a = '+';
        int b = '-';
        int c = '*';
        int d = '/';
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        String str = "+";
        System.out.println(str.toCharArray()[0]);
    }

    @Test
    public void test3() {
        String str = "+";
        if (str == "+") {
            System.out.println("匹配成功");
        }
    }

    @Test
    public void test4() {
        String suffixExpression = "3 4 + 5 * 6 -";  //定义一个后缀表达式
        PolandNotation polandNotation = new PolandNotation(suffixExpression);
        List<String> list = polandNotation.getListString();
        System.out.println(list.toString());
    }

    @Test
    public void test5() {
        String str = "hmg";
        char[] chars = str.toCharArray();
//        String s = new String(chars);
        String s = String.valueOf(chars);
        System.out.println(s);
    }

    /**
     * 初始化一个list集合，存放初步解析的中缀表达式（一个字符串拆解为多个元素字符串）
     */
    @Test
    public void test6() {
        String infixExpression = "1+((2+3)*4334)-5555";
        char[] chars = infixExpression.toCharArray();   //字符串转为字符数组
        //初始化一个list集合，存放初步解析的中缀表达式（一个字符串拆解为多个元素字符串）
        ArrayList<String> tempList = new ArrayList<>();
        //遍历char数组
        for (int index = 0; index < chars.length; index++) {
            char each = chars[index];
            if (Character.isDigit(each)) {
                //因为operand可能会增加长度，所以使用StringBuilder
                StringBuilder operand = new StringBuilder(String.valueOf(each));    //char转string暂存
                //考虑多位数情况
                //如果数组的下一位是数字，且不是数组的末尾，持续循环
                while (index < chars.length - 1 && Character.isDigit(chars[index + 1])) {
                    operand.append(chars[index + 1]);
                    index++;    //index后移因为char[index+1]已经被添加，跳过此次遍历
                }
                tempList.add(operand.toString());   //添加到暂存集合中
            } else { //如果是运算符
                String operator = String.valueOf(each);   //转为字符串
                tempList.add(operator); //添加到暂存集合中
            }
        }
        System.out.println(tempList);
    }

    @Test
    public void test7(){

    }
}
