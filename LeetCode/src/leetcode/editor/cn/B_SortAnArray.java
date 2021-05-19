package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;


public class B_SortAnArray {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        //在回溯过程中不断合并
        int[] mergeSort(int[] nums, int left, int right) {
            if (left > right) return nums;

            int mid = (left + right) >> 1;
            int[] leftArr = Arrays.copyOfRange(nums, left, mid);
            int[] rightArr = Arrays.copyOfRange(nums, mid, right);
            return merge(mergeSort(leftArr, left, mid), mergeSort(rightArr, mid + 1, right));
        }

        private int[] merge(int[] left, int[] right) {
            int[] res = new int[left.length + right.length];
            int i = 0, j = 0;
            int p = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j])
                    res[p++] = left[i++];
                else res[p++] = right[j++];
            }
            while (i < left.length)
                res[p++] = left[i++];
            while (j < right.length)
                res[p++] = right[j++];
            return res;
        }

        void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}