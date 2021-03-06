package algorithm02_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 */
public class No6_MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
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
        arr = sort(arr);
        Date after = new Date();    //排序后的时间
        System.out.printf("归并排序耗时%d毫秒%n", after.getTime() - before.getTime());
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        //运行结果为21毫秒左右
    }

    /**
     * 对数组进行归并排序
     *
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length); //拷贝源数组
        //设置递归头，递归到left和right数组仅有一个元素时结束
        if (temp.length < 2) {
            return temp;
        }
        //拆分点
        int middle = (int) Math.floor(arr.length / 2.0);    //Math.floor对输入参数进行下舍入
        //拆分为2个数组
        int[] left = Arrays.copyOfRange(temp, 0, middle);
        int[] right = Arrays.copyOfRange(temp, middle, temp.length);
        /*
         * 回溯阶段：一直拆分到temp.length>=2时结束
         * 递推阶段：返回merge后（按大小重新排序）的合并数组到上一层
         */
        return merge(sort(left), sort(right));
    }

    /**
     * 排序中的合并操作
     *
     * @param
     * @return 返回合并后的数组
     */
    private static int[] merge(int[] left, int[] right) {
        /*
        按照大小顺序依次从2个数组中取出元素到result中（将2个数组合并为一个从小到大排序的有序数组）
         */
        int[] result = new int[left.length + right.length]; //新建一个result数组保存合并的结果
        int resultIndex = 0;    //result数组的指针
        int leftIndex = 0;
        int rightIndex = 0;
        //当left和right数组都未排序完，循环持续
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else
                result[resultIndex++] = right[rightIndex++];
        }
        //如果其中一个数组已经排序完，指针指向length。则将另外一个非空数组的剩下的元素拷贝到result中
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        return result;
    }

    /**
     * 复习
     * 2020年8月23日09:12:05
     * 2020年8月27日12:38:29
     * 2020年8月31日08:44:07
     * 2020年9月13日09:45:55
     * 2020年9月22日08:56:27
     *
     * @param arr
     * @return
     */
    public static int[] sortReview(int[] arr) {
        int mid = arr.length / 2;
        if (mid < 1) {
            return arr;
        }

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        return mergeReview(sortReview(left), sortReview(right));
    }

    /**
     * 复习
     *
     * @param left
     * @param right
     * @return
     */
    private static int[] mergeReview(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int resIndex = 0;
        int lIndex = 0;
        int rIndex = 0;

        while (lIndex < left.length && rIndex < right.length) {
            if (left[lIndex] < right[rIndex]) {
                result[resIndex++] = left[lIndex++];
            } else {
                result[resIndex++] = right[rIndex++];
            }
        }
        while (lIndex < left.length) {
            result[resIndex++] = left[lIndex++];
        }
        while (rIndex < right.length) {
            result[resIndex++] = right[rIndex++];
        }

        return result;
    }

    /**
     * 测试复习写的方法
     */
    @Test
    public void testReview() {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2, 222};
        arr = sortReview(arr);
        System.out.println(Arrays.toString(arr));
    }
}

