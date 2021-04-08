package algorithm02_sort.review;

import java.util.Arrays;
import java.util.stream.Collectors;

public class A8_HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 20, 9, 33, 2, 44, 1, 15, 38};
        sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort(int[] arr) {
        buildMaxHeap(arr);  //建堆
        //固定最大值，重新堆化（只需要调整根节点）
        for (int size = arr.length; size > 1; size--) {
            swap(arr, 0, size - 1);
            heapify(arr, 0, size - 1);
        }
    }

    /**
     * 首次初始化为最大堆
     *
     * @param arr
     */
    static void buildMaxHeap(int[] arr) {
        //从最后一个非叶节点索引n/2-1开始
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    /**
     * 完成一次堆化操作
     *
     * @param arr
     * @param idx 需调整的节点索引
     * @param len 需调整的数组长度范围
     */
    static void heapify(int[] arr, int idx, int len) {
        int temp = arr[idx];    //保存节点值副本
        //类似插入排序，将当前索引为idx的节点下沉到正确的位置
        while (idx * 2 + 1 < len) {
            int childIdx = idx * 2 + 1; //左子节点索引
            //保证不越界的情况下，childIdx指向子节点中值较大的节点
            if (childIdx + 1 < len && arr[childIdx] < arr[childIdx + 1]) {
                childIdx++;
            }
            if (temp < arr[childIdx]) {
                arr[idx] = arr[childIdx];
            } else break;
            idx = childIdx;  //!!指针指向子节点
        }
        //1.temp>arr[childIdx]导致循环中止，将temp插入到arr[idx]满足最大堆性质
        //2.idx的左子节点已经越界，此时temp插入堆的底部，满足最大堆性质
        arr[idx] = temp;    //将本节点值插入到正确的位置
    }
}
