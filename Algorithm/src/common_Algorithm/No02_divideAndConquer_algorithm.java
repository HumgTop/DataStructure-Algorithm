package common_Algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 分治算法
 */
public class No02_divideAndConquer_algorithm {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1};
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();

        a.addAll(Arrays.asList(arr));
        myHanoiTower(a, b, c);

    }

    /**
     * a柱上共有num个盘子，将其全部移动到c柱上（游戏规则：小盘上不能放大盘）
     *
     * @param a 表示a柱，其中的元素代表放在柱子上的圆盘，数越大代表盘子越大
     */
    public static void myHanoiTower(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
    }

    /**
     * 使用分治算法求解汉诺塔问题
     *
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        //递归的最底层
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //如果n >= 2 情况， 我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
            //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
            hanoiTower(num - 1, a, c, b);
            //2. 把最下边的盘 A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3. 把 B 塔的所有盘 从 B->C , 移动过程使用到 a 塔
            hanoiTower(num - 1, b, a, c);
        }
    }

    @Test
    public void test1() {
        hanoiTower(3, 'A', 'B', 'C');
    }
}
