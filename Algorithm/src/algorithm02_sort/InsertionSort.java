package algorithm02_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20}; //待排序数组
        int[] sort = sort(arr);
//        int[] sort = sortReview(arr);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 测试插入排序的速度
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
        System.out.printf("插入排序耗时%d毫秒", after.getTime() - before.getTime());
        //运行结果为500毫秒左右
    }

    /**
     * 使用插入排序法对数组进行排序
     *
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        //**需要进行arr.length-1轮插入
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];   //定义待插入值
            int insertIndex;
            //**将待插入值与有序表元素进行比较（从后往前），如果待插入值较小，则将参加比较的有序表元素后移
            //insertIndex>=0条件为了防止数组下标越界
            //该循环执行到arr[insertIndex]<insertVal时结束
            for (insertIndex = i - 1; insertIndex >= 0 && insertVal < arr[insertIndex]; insertIndex--) {
                arr[insertIndex + 1] = arr[insertIndex];    //将有序表元素后移
            }
            //如果insertIndex发生了变化
            if (insertIndex != i - 1) {
                //因为arr[insertIndex]<insertVal，所以insertVal插入的位置应该在后一位
                arr[insertIndex + 1] = insertVal;
            }
        }
        return arr;
    }
}
