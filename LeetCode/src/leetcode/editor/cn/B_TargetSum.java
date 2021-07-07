package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class B_TargetSum {
    public static void main(String[] args) {
        System.out.println(new B_TargetSum().new Solution().findTargetSumWays(LeetCodeUtils.get1dArr("[1,1,1,1,1]"), 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findTargetSumWays(int[] nums, int S) {
            int n = nums.length;
            int[][] dp = new int[n][2001]; //下标[0,i-1]的元素组成和为j的方案数
            for (int i = 0; i < n; i++) {
                //实际和范围[-1000,1000]平移至[0,2000]
                for (int j = 0; j <= 2000; j++) {
                    if (i == 0) {
                        //初始化
                        if (nums[0] + 1000 == j || -nums[0] + 1000 == j) {
                            dp[i][j]++;
                            //nums[0]==0的话，dp[0][1000]应为2
                            if (nums[0] == 0) {
                                dp[i][j]++;
                            }
                        }
                    } else {
                        if (j >= nums[i]) {
                            dp[i][j] += dp[i - 1][j - nums[i]];
                        }
                        if (j + nums[i] <= 2000) {
                            dp[i][j] += dp[i - 1][j + nums[i]];
                        }
                    }
                }
            }


            return dp[n - 1][S + 1000];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}