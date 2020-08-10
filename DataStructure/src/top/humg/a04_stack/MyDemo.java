package top.humg.a04_stack;

import org.junit.Test;

import java.util.Scanner;

/**
 * 栈的测试和应用
 */
public class MyDemo {
    /**
     * 测试栈结构的基本方法
     */
    @Test
    public void test1() {
        ArrayStack arrayStack = new ArrayStack(5);
        String key;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);   //  扫描控制台输入
        while (loop) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出");
            System.out.println("push：表示元素入栈");
            System.out.println("pop：表示元素出栈");
            System.out.println("请输入：");
            key = scanner.next(); //控制台输入给key赋值
            switch (key) {
                case "show":
                    arrayStack.list();
                    System.out.println("-------------");
                    break;
                case "exit":
                    System.out.println("程序退出");
                    System.out.println("-------------");
                    loop = false;   //退出循环
                    break;
                case "push":
                    System.out.println("请输入入栈元素：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    System.out.println("显示目前栈空间：");
                    arrayStack.list();
                    System.out.println("-------------");
                    break;
                case "pop":
                    System.out.printf("出栈元素为：%d%n", arrayStack.pop());
                    System.out.println("显示目前栈空间：");
                    arrayStack.list();
                    System.out.println("-------------");
                    break;
            }
        }
    }

    /**
     * 测试list方法
     */
    @Test
    public void test2() {
        ArrayStack arrayStack = new ArrayStack(20);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.list();
        arrayStack.push(40);
        arrayStack.list();
    }

    /**
     * 测试综合计算器
     */
    @Test
    public void testCalculator() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("70+2*6-4");
        System.out.println(result);
    }
}
