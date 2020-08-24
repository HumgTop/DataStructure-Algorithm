package algorithm03_search;

import org.junit.Test;

/**
 * 插值查找（查找数组需是有序的）
 */
public class No3_InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = mySearch(arr, 1, 0, arr.length - 1);
        System.out.println(index);
    }

    /**
     * 相比二分查找，对mid值的处理做了改进
     *
     * @param arr
     * @param value
     * @param left
     * @param right
     * @return
     */
    private static int mySearch(int[] arr, int value, int left, int right) {
        System.out.println("正在查找");
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (int) (((value - arr[left]) / (float) (arr[right] - arr[left])) * (right - left));
        if (value < arr[mid]) {
            //左递归
            return mySearch(arr, value, left, mid - 1);
        } else if (value > arr[mid]) {
            //右递归
            return mySearch(arr, value, mid + 1, right);
        } else
            return mid;
    }

    /**
     * 复习
     * 2020年8月24日08:45:05
     *
     * @param arr
     * @param value
     * @param low
     * @param high
     * @return
     */
    private static int searchReview(int[] arr, int value, int low, int high) {
        //设置递归头
        if (low > high) {
            return -1;
        }
        //mid根据value的大小动态调整
        int mid = low + (int) ((value - arr[low]) / (float) (arr[high] - arr[low]) * (high - low));

        if (value < arr[mid]) {
            return searchReview(arr, value, low, mid - 1);
        } else if (value > arr[mid]) {
            return searchReview(arr, value, mid + 1, high);
        } else
            return mid;
    }

    /**
     * 测试复习方法
     */
    @Test
    public void test1() {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = searchReview(arr, 89, 0, arr.length - 1);
        System.out.println(index);
    }
}
