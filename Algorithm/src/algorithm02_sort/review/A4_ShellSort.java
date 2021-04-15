package algorithm02_sort.review;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class A4_ShellSort {
    public static void main(String[] args) {
        int[] arr = {4, 20, 9, 33, 2, 44, 1, 15, 38};
        BiConsumer<Integer, Integer> swap = (i, j) -> {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        };

        //gap最小为1
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                if (arr[i] > arr[i - gap]) continue;
                //进行插入排序
                int temp = arr[i];
                int j;
                for (j = i - gap; j >= 0 && temp < arr[j]; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                //此时arr[j]<temp或者j<0
                arr[j + gap] = temp;
            }
        }


        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
