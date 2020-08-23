package algorithm02_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序法
 */
public class No2_SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20}; //待排序数组
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 测试选择排序的速度
     */
    @Test
    public void test1() {
        //对80000个元素进行冒泡排序
        int[] arr = new int[80000];
        //给数组注入随机数
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);    //Math.random方法产生的是0~1之间的小数
        }
        Date before = new Date(); //排序前的时间
        sort(arr);
        Date after = new Date();    //排序后的时间
        System.out.printf("选择排序耗时%d毫秒", after.getTime() - before.getTime());
        //运行结果为2秒左右，比冒泡排序快很多
    }

    /**
     * 对待排序数组arr进行排序
     *
     * @param arr
     * @return 已排序数组
     */
    public static int[] sort(int[] arr) {
        //经过arr.length-1轮交换确定元素的正确位置（从数组左到右每轮确定一个位置的元素）
        for (int i = 0; i < arr.length - 1; i++) {
            //每一轮进行比较大小的元素数是在递减的，从arr.length个递减到2个。
            //每一轮j的下限递增
            //** 每一轮循环都设置辅助变量：index存储最小值的下标
            int minIndex = i;   //先假定为最小值，记录下标
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;    //与后面所有元素进行比较，将index更新为较小元素的下标
                }
            }
            //** 如果index的值发生更新，得到最小值的下标后，交换两者元素
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
        return arr;
    }

    /**
     * 复习
     * 2020年8月18日15:08:15
     * 2020年8月23日11:16:07
     *
     * @param arr
     * @return
     */
    public static int[] sortReview(int[] arr) {
        /*
        经过arr.length-1轮排序，每轮确定一个位置的元素（从左往右）
        每轮在后n-i个元素中找到最小值，放到下标为i+1的位置
         */
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }

    /**
     * 对数组中2个位置的元素进行交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void testReview() {
        int[] arr = {3, 9, -1, 10, 20}; //待排序数组
        int[] sort = sortReview(arr);
        System.out.println(Arrays.toString(sort));
    }
}
