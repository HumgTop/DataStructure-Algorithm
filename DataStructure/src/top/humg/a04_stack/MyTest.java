package top.humg.a04_stack;

import org.junit.Test;

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
}
