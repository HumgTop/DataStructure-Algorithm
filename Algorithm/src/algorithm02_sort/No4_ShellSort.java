package algorithm02_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 */
public class No4_ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0}; //待排序数组
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
        System.out.printf("希尔排序耗时%d毫秒", after.getTime() - before.getTime());
        //运行结果为14毫秒左右
    }

    /**
     * 移位法
     * 从有序表尾部向前遍历，将元素向后移一位，直到找到insertVal需要插入的正确位置为止
     *
     * @param arr
     * @return
     */
    private static int[] sort(int[] arr) {
        //每轮循环gap都会减少，直至等于1
        //若gap=n，说明数据被分成n个增量序列，每个序列元素下标增量为n
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            /*
            i循环每循环一轮（一轮循环length-gap次），即完成1轮n个增量序列各自的内部排序。
            每个增量序列有arr.length/gap个元素。需要(arr.length/gap-1)*gap=length-gap次操作才能完成一轮n个增量序列的排序（前gap个元素在各自的增量序列中都是第一个元素，视为有序表）
             */
            for (int i = gap; i < arr.length; i++) {
                int insertVal = arr[i];   //暂存待插入元素
                int insertIndex;
                //**插入排序：j循环每循环一轮，即将当前元素与本增量序列之前所有的元素（有序表）进行比较（从后往前比较），插入到正确的位置
                //当insertVal>arr[insertIndex]时，循环结束
                for (insertIndex = i - gap; insertIndex >= 0 && insertVal < arr[insertIndex]; insertIndex -= gap) {
                    //如果待插入元素小于增量序列（有序表）当前下标的元素，将该下标的元素后移gap位
                    arr[insertIndex + gap] = arr[insertIndex];
                }
                //如果insertIndex发生了更新（如果insertVal本身就在正确的位置上则不需要操作）
                if (insertIndex != i - gap) {
                    //因为arr[insertIndex]<insertVal，所以insertVal插入的位置应该在insertIndex+gap
                    arr[insertIndex + gap] = insertVal;
                }
            }
        }
        return arr;
    }

    /**
     * 复习
     * 2020年8月18日11:10:14
     * 2020年9月9日08:50:48
     *
     * @param arr
     * @return
     */
    private static int[] sortReview(int[] arr) {
        //当增量gap缩小至0时，排序完成
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //前gap个元素为有序表，无需操作
            for (int i = gap; i < arr.length; i++) {
                int insertIndex;
                int insertVal = arr[i];
                for (insertIndex = i - gap; insertIndex >= 0 && insertVal < arr[insertIndex]; insertIndex -= gap) {
                    arr[insertIndex + gap] = arr[insertIndex];
                }
                //此时insertVal找到了正确的插入位置，insertIndex==-gap或者insertVal>arr[insertIndex]
                arr[insertIndex + gap] = insertVal;
            }
        }
        return arr;
    }

    @Test
    public void testReview() {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0}; //待排序数组
        int[] sort = sortReview(arr);
        System.out.println(Arrays.toString(sort));
    }
}


