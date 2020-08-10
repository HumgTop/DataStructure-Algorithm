package top.humg.a04_stack;

/**
 * 使用数组模拟栈结构
 */
public class ArrayStack {
    private final int maxSize;    //定义栈的大小
    private int[] stack;    //数组模拟栈存储空间
    private int top = -1; //top表示栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize]; //初始化栈空间
    }

    public int getTop() {
        return top;
    }

    /**
     * 判断栈空间是否已满方法
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈空间是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 元素入栈方法
     *
     * @param value
     */
    public void push(int value) {
        //先判断是否栈满
        if (!isFull()) {
            top++;  //指针上移
            stack[top] = value; //存入元素
            return;
        }
        System.out.println("栈空间已满，无法存入元素");
    }

    /**
     * 元素出栈方法
     *
     * @return 出栈元素
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空间为空");
        }
        int temp = stack[top];  //暂存出栈元素
        stack[top] = 0;   //清空栈元素
        top--;  //指针下移
        return temp;
    }

    /**
     * 遍历栈空间元素并打印
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空间为空");
            return;
        }
        //遍历
        int index = top;    //不可直接操作top，否则执行list方法相当于元素出栈
        while (index > -1) {
            System.out.printf("索引为%d的元素：%d%n", index, stack[index]);
            index--;
        }
        System.out.println("------------");
    }

    /**
     * 返回栈顶元素（并不是元素出栈）
     *
     * @return
     */
    public int getTopElement() {
        if (isEmpty()) {
            System.out.println("栈空间为空");
            throw new RuntimeException("栈顶为空");
        }
        return stack[top];
    }
}
