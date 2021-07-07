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
            //快速排序
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        void quickSort(int[] nums, int left, int right) {
            if (left >= right) return;
            int partitionIdx = partition(nums, left, right);

            quickSort(nums, left, partitionIdx);
            quickSort(nums, partitionIdx + 1, right);
        }

        int partition(int[] nums, int left, int right) {
            int pivotIdx = left;
            int i = left + 1, j = i;
            while (j <= right) {
                if (nums[j] < nums[pivotIdx]) {
                    swap(nums, i++, j);
                }
                j++;
            }

            swap(nums, pivotIdx, i - 1);
            return i - 1;
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}