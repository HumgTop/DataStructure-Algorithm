package algorithm02_sort.review;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class A5_MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 20, 9, 33, 2, 44, 1, 15, 38};
        arr = sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    /**
     * 在回溯过程完成排序，不同于快排在递归过程中完成排序
     * @param arr 源数组
     * @return 排序好的数组
     */
    static int[] sort(int[] arr) {
        if (arr.length < 2) return arr;
        //对数组进行拆分
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        //分治
        return merge(sort(left), sort(right));
    }

    /**
     * 将left和right合并成有序数组
     *
     * @param left
     * @param right
     */
    static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0;
        int p = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                res[p++] = left[i++];
            else res[p++] = right[j++];
        }
        while (i < left.length)
            res[p++] = left[i++];
        while (j < right.length)
            res[p++] = right[j++];
        return res;
    }
}
