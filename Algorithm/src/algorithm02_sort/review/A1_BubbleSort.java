package algorithm02_sort.review;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class A1_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 20, 9, 33, 2, 44, 1, 15, 38};
        BiConsumer<Integer, Integer> swap = (i, j) -> {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        };

        //每次外层循环确定了arr[len-i-1]的元素
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //每次比较判断是否交换相邻排序
                if (arr[j] > arr[j + 1])
                    swap.accept(j, j + 1);
            }
        }

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
