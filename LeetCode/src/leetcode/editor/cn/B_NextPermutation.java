package leetcode.editor.cn;

import org.junit.Test;


public class B_NextPermutation {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2;
            //找到第一个升序对
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                //从右向左查找，找到第一个比nums[i]大的元素，并交换
                int j = n - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            //反转[i+1:n]区间
            reverse(nums, i + 1);
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        void reverse(int[] nums, int idx) {
            int i = idx;
            int j = nums.length - 1;
            while (i < j) {
                swap(nums, i++, j--);
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}