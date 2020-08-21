package algorithm02_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 * 算法步骤
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零
 * 从最低位开始，依次进行一次排序
 * 从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
 */
public class No7_RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        int[] sortedArr = sort(arr);
        System.out.println(Arrays.toString(sortedArr));
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
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        Date before = new Date(); //排序前的时间
        sort(arr);
        Date after = new Date();    //排序后的时间
        System.out.printf("归并排序耗时%d毫秒%n", after.getTime() - before.getTime());
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        //运行结果为18毫秒左右
    }

    public static int[] sort(int[] arr) {
        int maxDigit = getMaxDigit(arr);    //该数组的最大值共有maxDigit位
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounter = new int[10];   //记录每个桶存放的元素数

        //按照数字的位数进行排序处理，每一次循环完成一个位数上的排序
        for (int i = 0, n = 1; i < maxDigit; i++, n *= 10) {
            for (int value : arr) {
                //取出对应位数上的值
                int digOfElement = value / n % 10;
                //将元素存入对应的桶中
                bucket[digOfElement][bucketElementCounter[digOfElement]] = value;
                //桶对应的计数器+1
                bucketElementCounter[digOfElement]++;
            }
            int arrIndex = 0; //源数组存入元素的指针
            //依次遍历10个桶，将桶中元素按索引顺序取出，存入源数组中（遍历二维数组）
            for (int j = 0; j < 10; j++) {
                //前提：该桶内有元素
                if (bucketElementCounter[j] != 0) {
                    for (int k = 0; k < bucketElementCounter[j]; k++) {
                        arr[arrIndex++] = bucket[j][k];   //存入元素
                    }
                }
                //** 完成一个位数的排序后（桶元素取出完毕），需要将桶元素计数器归零
                bucketElementCounter[j] = 0;
            }
        }
        return arr;
    }

    /**
     * 数组的最大值有几位
     *
     * @param arr
     * @return
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = arr[0];    //先假定第一位为最大值
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        //对maxValue进行除以10运算，看几次后为0
        int maxDigit = 0;
        for (int i = maxValue; i != 0; i /= 10) {
            maxDigit++;
        }
        return maxDigit;
    }


/**
 * 基本思路：
 * 1.将所有元素从个位开始，根据该位置的大小放入不同的桶中，再依次从桶中取回元素到源数组（桶序号从小到大）
 * 2.从个位开始到数组中最大值的最高位依次执行 1. 步骤
 *
 */
    /**
     * 复习
     * 2020年8月18日08:38:53
     * 2020年8月21日19:28:06
     *
     * @param arr
     * @return
     */
    public static int[] sortReview(int[] arr) {
        //获取arr数组中最大值的位数
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        String maxStr = Integer.toString(max);
        int maxLength = maxStr.length();

        //创建10个桶，长度等于arr.length
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounter = new int[10];   //桶元素计数器

        //共需要maxLength轮完成排序
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //循环arr.length次，把所有元素存入桶中
            for (int value : arr) {
                int bucketIndex = value / n % 10;    //获取该存入的桶索引（即在个位、十位...上的值）
                bucket[bucketIndex][bucketElementCounter[bucketIndex]] = value;
                bucketElementCounter[bucketIndex]++;    //计数器自增
            }
            //按照桶内顺序和桶顺序依次取出元素到arr中
            int arrIndex = 0;
            for (int j = 0; j < 10; j++) {
                //每个桶取bucketElementCounter[j]次
                for (int k = 0; k < bucketElementCounter[j]; k++) {
                    //如果桶内有元素的话
                    if (bucketElementCounter[j] > 0) {
                        arr[arrIndex] = bucket[j][k];
                        arrIndex++;
                    }
                }
                bucketElementCounter[j] = 0;  //桶元素取出后，计数器清零
            }
        }
        return arr;
    }

    @Test
    public void testReview() {
        int[] arr = {53, 3, 542, 748, 14, 214};
        int[] sortedArr = sortReview(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
