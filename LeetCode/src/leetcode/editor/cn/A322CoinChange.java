package leetcode.editor.cn;
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 893 👎 0

public class A322CoinChange {
    public static void main(String[] args) {
        Solution solution = new A322CoinChange().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            int[] dp = new int[amount + 1]; //dp[i]表示凑成金额i所需的最小硬币数
            for (int coin : coins) {
                //如果硬币值大于金额，跳过
                if (coin > amount) continue;
                dp[coin] = 1;   //初始化仅需要1枚硬币的金额
            }

            int minCoins;
            for (int i = 1; i < amount + 1; i++) {
                if (dp[i] == 1) continue;
                minCoins = Integer.MAX_VALUE;

                for (int coin : coins) {
                    //更新金额i所需的最小硬币数
                    if (i - coin >= 0 && dp[i - coin] != -1 && dp[i - coin] < minCoins)
                        minCoins = dp[i - coin];
                }

                if (minCoins != Integer.MAX_VALUE) dp[i] = minCoins + 1;
                else dp[i] = -1;
            }

            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}