package leetcode.editor.cn;


import java.util.Arrays;

public class A189_RotateArray {
    public static void main(String[] args) {

        Solution solution = new A189_RotateArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;

        public void rotate(int[] nums, int k) {
            this.nums = nums;
            k %= nums.length;

            swap(0, nums.length - 1);   //反转整个数组
            swap(0, k - 1); //反转[0,k-1]
            swap(k, nums.length - 1);   //反转[k,nums.length-1]

        }

        /**
         * 反转数组
         *
         * @return
         */
        void swap(int left, int right) {
            while (left < right) {
                int temp = nums[right];
                nums[right--] = nums[left];
                nums[left++] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}