package algorithm02_sort.review;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Review {
    public static void main(String[] args) {
        int[] arr = {4, 20, 9, 33, 2, 44, 1, 15, 38};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    //对(left,right)内的元素进行分区操作，并返回基准值的索引pivot
    static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int i = left + 1, j = i;
        //(left,i-1)为小于基准值的区域
        while (j <= right) {
            if (arr[j] < arr[pivot])
                swap(arr, j, i++);
            j++;
        }
        swap(arr, pivot, i - 1);
        return i - 1;
    }

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
