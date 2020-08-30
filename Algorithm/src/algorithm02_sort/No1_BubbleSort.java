package algorithm02_sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序法及其优化
 * 冒泡排序的时间复杂度：O(n^2)（两层嵌套循环）
 */
public class No1_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20}; //待排序数组
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 测试冒泡排序的速度
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
        System.out.printf("冒泡排序耗时%d毫秒", after.getTime() - before.getTime());
    }

    /**
     * 对输入数组进行从小到大排序
     *
     * @param arr 待排序数组
     * @return 经过排序后的新数组
     */
    public static int[] sort(int[] arr) {
        //遍历数组
        //第一层循环，每循环一次（完成一轮从头到尾（不包括已确定位置）的相邻元素比较和交换）确定一个位置（从数组末位到首位）的排序结果（5个元素，确定4个位置即可，所以 i<4）
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;    //默认排序已完成
            //第二层循环，每循环一次即比较一次相邻元素的大小，并将较大元素交换到数组下标较大的位置
            //因为外层每循环一次，数组末尾都会确定一个元素位置，不需要再进行比较，所以j的上限值随着i的增加不断变小
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    //把较大元素交换到后面
                    swap(arr, j - 1, j);
                    flag = false;  //内层每循环一次，只要发生过交换，将flag设置为false，表示排序未完成
                }
            }
            //内层循环1轮后，如果一次交换都没有发生，说明排序已经完成。直接返回arr
            if (flag) {
                return arr;
            }
        }
        return arr;
    }

    /**
     * 交换数组中的两个元素
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 对冒泡排序的复习
     * 2020年8月13日08:54:07
     * 2020年8月18日15:20:50
     * 2020年8月21日19:27:44
     * 2020年8月30日08:55:52
     *
     * @param arr
     * @return
     */
    public static int[] sortReview(int[] arr) {
        /*
        1.将第左向右比较，将较大的值交换到右侧，每次确认一个位置的元素。共需arr.length-1次jiaoh
         */
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            //如果一轮j循环没有发生一次交换，说明排序已经完成，直接返回arr
            if (!flag) {
                return arr;
            }
        }
        return arr;
    }

    @Test
    public void testReview() {
        int[] arr = {3, 9, -1, 20, 10}; //待排序数组
        int[] sort = sortReview(arr);
        System.out.println(Arrays.toString(sort));
    }
}
