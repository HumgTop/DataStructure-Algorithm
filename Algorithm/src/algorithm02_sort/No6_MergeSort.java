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
        //设置递归头
        if (temp.length < 2) {
            return temp;
        }
        //拆分点
        int middle = (int) Math.floor(arr.length / 2.0);    //Math.floor对输入参数进行下舍入
        //拆分为2个数组
        int[] left = Arrays.copyOfRange(temp, 0, middle);
        int[] right = Arrays.copyOfRange(temp, middle, temp.length);
        /*
         * 回溯阶段：一直拆分到temp.length<=1时结束
         * 递推阶段：返回merge后的数组到上一层
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
        if (rightIndex >= right.length) {
            for (int i = leftIndex; i < left.length; i++) {
                result[resultIndex++] = left[i];
            }
        }
        if (leftIndex >= left.length) {
            for (int i = rightIndex; i < right.length; i++) {
                result[resultIndex++] = right[i];
            }
        }
        return result;
    }
}

