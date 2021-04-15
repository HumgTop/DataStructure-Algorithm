package algorithm02_sort.review;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Review {
    public static void main(String[] args) {
        int[] arr = {4, 20, 9, 33, 2, 44, 1, 15, 38};
        sort(arr);

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    static void sort(int[] arr) {
        buildMaxHeap(arr);
        //固定最大值，重新调整头节点
        for (int size = arr.length; size > 1; size--) {
            swap(arr, 0, size - 1);
            heapify(arr, 0, size - 1);
        }
    }

    static void buildMaxHeap(int[] arr) {
        int size = arr.length;
        //从最后一个非叶节点开始堆化
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, i, size);
        }
    }

    //将节点idx下沉到正确的位置
    static void heapify(int[] arr, int idx, int heapSize) {
        int temp = arr[idx];    //保存副本
        while (idx * 2 + 1 < heapSize) {
            int childIdx = idx * 2 + 1;
            if (childIdx + 1 < heapSize && arr[childIdx] < arr[childIdx + 1]) childIdx++;

            if (temp < arr[childIdx]) {
                arr[idx] = arr[childIdx];
            } else break;
            idx = childIdx;
        }
        arr[idx] = temp;
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
