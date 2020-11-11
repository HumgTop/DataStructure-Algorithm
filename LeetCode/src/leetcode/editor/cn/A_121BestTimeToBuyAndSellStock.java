package leetcode.editor.cn;

public class A_121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new A_121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1 || prices.length == 0) return 0;
            if (prices.length == 2) {
                return prices[0] > prices[1] ? 0 : prices[1] - prices[0];
            }

            int[] dp = new int[prices.length];
            dp[0] = 0;  //dp[i]表示prices[0:i]区间的最大收益

            int i;
            for (i = 1; i < prices.length; i++) {
                int maxProfit = 0;
                for (int before = 0; before < i; before++) {
                    if (prices[before] < prices[i]) {
                        int cur = prices[i] - prices[before];
                        if (cur > maxProfit) maxProfit = cur;
                    }
                }
                dp[i] = Math.max(maxProfit, dp[i - 1]);
            }

            return dp[i - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}