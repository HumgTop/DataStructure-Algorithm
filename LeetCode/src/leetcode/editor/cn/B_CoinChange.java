package leetcode.editor.cn;


import java.util.Arrays;


public class B_CoinChange {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1]; //dp[i]表示凑成金额i所需的最小硬币数
            Arrays.fill(dp, Integer.MAX_VALUE - 100);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i >= coin) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);  //在本轮硬币选择中，选择最少可达成金额i的硬币数
                    }
                    //如果i<coins[j]，说明此硬币面值不能构成该金额
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}