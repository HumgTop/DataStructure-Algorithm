package leetcode.editor.cn;

import org.junit.Test;


public class B_MaximumSubarray {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            //元素连续的子数组
            //dp[i]表示以nums[i-1]结尾的子数组的最大和
            int n = nums.length;
            int[] dp = new int[n + 1];
            int res = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i - 1];
                } else dp[i] = nums[i - 1];
                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}