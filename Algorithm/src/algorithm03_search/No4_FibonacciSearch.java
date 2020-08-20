package algorithm03_search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class No4_FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234, 2000, 2000, 2000, 2000, 2000, 2000, 3000};
        int index = search(arr, 3000);
        System.out.println(index);
    }

    private static int search(int[] arr, int value) {
        int low = 0;    //左边界
        int high = arr.length - 1;  //右边界
        int k = 0;    //斐波那契数组的下标
        int mid = 0;

        int[] fib = getFib();
        //** 找到一个比arr数组长度大的最小的斐波那契数
        while (arr.length > fib[k] - 1) {
            k++;
        }
        //** 此时arr.length<=fib[k]-1，length大多数情况小于fib[k]-1
        int[] temp = Arrays.copyOf(arr, fib[k] - 1);    //延伸数组长度到fib[k]-1，延伸位置元素为0
        //将arr的末尾元素填充到延伸部分
        for (int i = high + 1; i < fib[k] - 1; i++) {
            temp[i] = arr[high];
        }

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
}
