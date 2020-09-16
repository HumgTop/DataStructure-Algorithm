package leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 131 👎 0

import java.util.Arrays;

public class B40_ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new B40_ZuiXiaoDeKgeShuLcof().new Solution();
        int[] arr = {3, 2, 1, 0, 0};
        int k = 3;
        int[] leastNumbers = solution.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(leastNumbers));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            return quickSort(arr, 0, arr.length - 1, k - 1);
        }

        int[] quickSort(int[] arr, int left, int right, int j) {
            int partitionIndex = partition(arr, left, right);
            if (partitionIndex == j) return Arrays.copyOfRange(arr, 0, j + 1);
            return partitionIndex > j ? quickSort(arr, left, partitionIndex - 1, j) : quickSort(arr, partitionIndex + 1, right, j);
        }

        int partition(int[] arr, int left, int right) {
            int pivot = left;
            int lIndex = left + 1;
            int rIndex;
            for (rIndex = lIndex; rIndex <= right; rIndex++) {
                if (arr[rIndex] < arr[pivot]) {
                    swap(arr, rIndex, lIndex++);    //交换后 lIndex++
                }
            }
            swap(arr, pivot, lIndex - 1);
            return lIndex - 1;
        }

        void swap(int[] arr, int i, int j) {
            int temp;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//    解法一：暴力求解
//    class Solution {
//        public int[] getLeastNumbers(int[] arr, int k) {
//            Arrays.sort(arr);
//            return Arrays.copyOfRange(arr, 0, k);
//        }
//    }
}