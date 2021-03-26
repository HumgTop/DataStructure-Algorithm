package algorithm02_sort.review;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class A2_SelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 20, 9, 33, 2, 44, 1, 15, 38};
        BiConsumer<Integer, Integer> swap = (i, j) -> {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        };

        for (int i = 0; i < arr.length - 1; i++) {
            //记录本次扫描的最大值及索引，将其交换到arr[i]的位置
            int minTemp = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minTemp) {
                    minTemp = arr[j];
                    minIdx = j;
                }
            }
            swap.accept(minIdx, i);
        }


        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
