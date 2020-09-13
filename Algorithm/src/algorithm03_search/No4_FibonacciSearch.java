package algorithm03_search;

import org.junit.Test;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class No4_FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234, 2000, 2000, 2000, 2000, 2000, 2000, 3000};
        int index = search(arr, 89);
        System.out.println(index);
    }

    /**
     * @param arr
     * @param value
     * @return 查找值在数组中的索引
     */
    private static int search(int[] arr, int value) {
        int low = 0;    //左边界
        int high = arr.length - 1;  //右边界
        int k = 0;    //斐波那契数组的下标
        int mid = 0;

        int[] fib = getFib();
        //** 找到一个大于arr数组长度的最小斐波那契数
        while (arr.length > fib[k] - 1) {
            k++;
        }
        //** 此时arr.length<=fib[k]-1，length大多数情况小于fib[k]-1
        int[] temp = Arrays.copyOf(arr, fib[k] - 1);    //** 延伸数组长度到fib[k]-1，延伸位置元素为0
        //将arr的末尾元素填充到延伸部分
        Arrays.fill(temp, arr.length, temp.length, arr[high]);

        while (low <= high) {
            mid = low + fib[k - 1] - 1; //定义mid的索引值
            if (value < temp[mid]) {
                high = mid - 1;
                k--;    //左半部分有fib[k-1]-1个元素，所以将k减1又可以拆分为两个新的斐波那契数之和
            } else if (value > temp[mid]) {
                low = mid + 1;
                //** 右侧有fib[k-2]-1个元素，所以要将k-2
                k -= 2;
            } else {
                //如果在延伸序列中找到value，则返回high
                return Math.min(mid, high);
            }
        }
        return -1;
    }

    /**
     * 获取一个斐波那契数列
     *
     * @return
     */
    public static int[] getFib() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * 复习
     * 2020年8月24日07:58:46
     * 2020年8月28日15:07:56
     * 2020年9月1日17:16:35
     * 2020年9月13日10:15:38
     *
     * @param arr
     * @param value
     * @return
     */
    private static int searchReview(int[] arr, int value) {
        int[] fibs = getFibReview();
        int k = 0;
        //找到比length大的最小fib数
        while (fibs[k] - 1 < arr.length) {
            k++;
        }
        //延伸arr的长度
        int[] temp = Arrays.copyOf(arr, fibs[k] - 1);
        Arrays.fill(temp, arr.length, temp.length, arr[arr.length - 1]);

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = low + fibs[k - 1] - 1;
            if (value < arr[mid]) {
                high = mid - 1;
                k--;
            } else if (value > arr[mid]) {
                low = mid + 1;
                k -= 2;
            } else
                return Math.min(high, mid);
        }
        return -1;
    }

    /**
     * 获取一个斐波那契数列
     *
     * @return
     */
    private static int[] getFibReview() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * 测试复习所写的方法
     */
    @Test
    public void searchReviewTest() {
        int[] arr = {1, 8, 10, 89, 1000, 1234, 2000, 2000, 2000, 2000, 2000, 2000, 3000};
        int index = searchReview(arr, 10);
        System.out.println(index);
    }

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4};
        int[] temp = Arrays.copyOf(arr, 8);
        Arrays.fill(temp, arr.length, temp.length, arr[arr.length - 1]);
        System.out.println(Arrays.toString(temp));
    }
}
