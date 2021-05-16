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
        for (int i = arr.length - 1; i > 0; i--) {
            swap(0, i, arr);    //固定元素排序
            //重新堆化
            heapify(arr, 0, i);
        }
    }

    //初始化建立最大堆
    static void buildMaxHeap(int[] arr) {
        //从非叶节点索引递减进行heapify
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    static void heapify(int[] arr, int idx, int heapSize) {
        //将节点idx下沉到合适的位置
        int temp = arr[idx];
        while (idx * 2 + 1 < heapSize) {
            int childIdx = idx * 2 + 1;
            if (childIdx + 1 < heapSize && arr[childIdx + 1] > arr[childIdx]) {
                childIdx++;
            }
            if (temp < arr[childIdx]) {
                arr[idx] = arr[childIdx];
            } else break;
            idx = childIdx;
        }
        arr[idx] = temp;
    }


    static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
