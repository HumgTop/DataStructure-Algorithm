package algorithm02_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 */
public class No3_InsertionSort {
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
                //此时insertIndex=-1或者arr[insertIndex]<insertVal，所以insertVal插入的位置应该在insertIndex+1
                arr[insertIndex + 1] = insertVal;
            }
        }
        return arr;
    }

    /**
     * 复习
     * 2020年8月18日11:42:12
     *
     * @param arr
     * @return
     */
    public static int[] sortReview(int[] arr) {
        /*
        将数组分为有序表（左侧）和无序表（右侧），有序表开始只有1个元素
        遍历无序表，将其元素插入到有序表正确的位置
         */
        for (int i = 1; i < arr.length; i++) {
            //将当前元素arr[i]插入到正确的位置
            int insertVal = arr[i];
            int insertIndex;
            for (insertIndex = i - 1; insertIndex >= 0 && insertVal < arr[insertIndex]; insertIndex--) {
                arr[insertIndex + 1] = arr[insertIndex]; //没有找到正确位置，元素后移一位
            }
            //此时insertIndex==-1或者insertVal>arr[insertIndex]，此时插入insertVal
            arr[insertIndex + 1] = insertVal;
        }
        return arr;
    }

    @Test
    public void testReview() {
        int[] arr = {3, 9, -1, 10, 20}; //待排序数组
        int[] sort = sortReview(arr);
        System.out.println(Arrays.toString(sort));
    }
}
