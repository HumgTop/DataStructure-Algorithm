package algorithm03_search;

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
}
