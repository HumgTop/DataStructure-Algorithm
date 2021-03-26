package algorithm02_sort.review;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class A6_QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 20, 9, 33, 2, 44, 1, 15, 38};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    /**
     * @param arr
     * @param left
     * @param right
     * @return 分区操作后基准值的索引
     */
    static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int i = pivot + 1, j = i;   //(0,i-1)为小于等于基准值的区域，j为扫描指针，将小于基准值的元素交换到左侧
        while (j <= right) {
            if (arr[j] < arr[pivot])
                swap(arr, i++, j);
            j++;
        }
        swap(arr, pivot, i - 1);
        return i - 1;
    }

    /**
     * 在递归过程中完成排序，不同于归并排序在回溯过程中完成排序
     * @param arr
     * @param left
     * @param right
     */
    static void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = partition(arr, left, right);
        sort(arr, left, pivot);
        sort(arr, pivot + 1, right);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
