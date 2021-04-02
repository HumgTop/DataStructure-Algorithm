package leetcode.editor.cn;


import java.util.Arrays;

public class B_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = LeetCodeUtils.get1dArr("[10,9,2,5,3,7,101,18]");
        Solution solution = new B_LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(arr));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            //dp[i]表示以nums[i]结尾的最长递增子序列的长度
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int res = 1;
            for (int i = 1; i < nums.length; i++) {
                //dp[i]由dp[j](0<=j<i)转移而来
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}