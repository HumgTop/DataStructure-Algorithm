package leetcode.editor.cn;


import java.util.Arrays;

public class B_CoinChange2 {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int cnt = 0;

        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];     //dp[i]表示凑成金额i的可选组合数
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = 0; i < dp.length; i++) {
                    if (i - coin >= 0) {
                        dp[i] += dp[i - coin];
                    }
                }
            }

            return dp[amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}