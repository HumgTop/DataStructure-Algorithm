package leetcode.editor.cn;


import java.util.Arrays;


public class B_CoinChange {
    public static void main(String[] args) {
        Solution solution = new B_CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1]; //dp[i]表示凑成金额i所需的最少硬币数
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i < dp.length; i++) {
                for (int coin : coins) {
                    //如果不越界，且存在可转移的金额
                    if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                        //刷新最小硬币数
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
            }

            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}