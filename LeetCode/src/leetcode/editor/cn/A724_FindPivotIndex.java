package leetcode.editor.cn;

import java.util.Arrays;

public class A724_FindPivotIndex {
    public static void main(String[] args) {
        Solution solution = new A724_FindPivotIndex().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {
            int total = Arrays.stream(nums).sum();
            int[] preSum = new int[nums.length + 1];
            int curSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (curSum * 2 + nums[i] == total) return i;
                curSum += nums[i];
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}