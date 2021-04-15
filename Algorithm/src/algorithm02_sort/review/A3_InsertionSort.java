package algorithm02_sort.review;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class A3_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 20, 9, 33, 2, 44, 1, 15, 38};
        BiConsumer<Integer, Integer> swap = (i, j) -> {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        };

        //i是无序表的首位索引，将其插入到有序表(0,i-1)中的正确位置
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) continue;
            int temp = arr[i];
            //arr[j]是与arr[i]进行比较的元素
            int j;
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            //此时temp>arr[j]或者j==0
            arr[j + 1] = temp;
        }


        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
