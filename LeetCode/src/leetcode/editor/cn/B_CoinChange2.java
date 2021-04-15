package leetcode.editor.cn;


import java.util.Arrays;

public class B_CoinChange2 {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int cnt = 0;

        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1]; //dp[i]表示凑成金额i有多少种不同的组合方案
            dp[0] = 1;
            //完全背包的选择方案的组合
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }

            return dp[amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}