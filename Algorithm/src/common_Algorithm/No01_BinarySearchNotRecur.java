package common_Algorithm;

/**
 * 二分查找非递归实现
 */
public class No01_BinarySearchNotRecur {
    public static void main(String[] args) {
        int[] array = {1, 8, 10, 89, 1000, 1234};
        int index = mySearch(array, 89);
        System.out.println(index);
    }

    /**
     * 二分查找非递归实现
     *
     * @param arr
     * @param findVal
     * @return
     */
    private static int mySearch(int[] arr, int findVal) {
        //不需要递归调用，left和right变量可以写在方法内部
        int left = 0;
        int right = arr.length;
        int mid;
        int midVal;

        while (left <= right) {
            mid = (left + right) / 2;
            midVal = arr[mid];
            if (findVal < midVal) {
                //更新right，进入下次循环在左侧查找
                right = mid - 1;
            } else if (findVal > midVal) {
                //更新left，进入下次循环在右侧查找
                left = mid + 1;
            } else
                return mid;
        }
        //当查找完所有元素仍未找到，返回-1
        return -1;
    }
}
