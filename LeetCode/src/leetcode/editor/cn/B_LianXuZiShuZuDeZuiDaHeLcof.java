package leetcode.editor.cn;


import java.util.Arrays;

public class B_LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        int[] input = {-1, -2};
        Solution solution = new B_LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                res = Math.max(res, dp[i]);
            }
            return nums.length == 1 ? nums[0] : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}