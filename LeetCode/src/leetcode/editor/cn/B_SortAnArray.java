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
            //归并排序
            return sort(nums);
        }

        //在回溯过程中，对返回的子数组进行归并排序
        int[] sort(int[] nums) {
            //终止条件
            if (nums.length == 1) return nums;

            int mid = nums.length / 2;
            int[] left = Arrays.copyOfRange(nums, 0, mid);
            int[] right = Arrays.copyOfRange(nums, mid, nums.length);

            return merge(sort(left), sort(right));
        }

        int[] merge(int[] left, int[] right) {
            int[] res = new int[left.length + right.length];
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    res[k++] = left[i++];
                } else {
                    res[k++] = right[j++];
                }
            }
            while (i < left.length) {
                res[k++] = left[i++];
            }
            while (j < right.length) {
                res[k++] = right[j++];
            }
            return res;
        }


        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}