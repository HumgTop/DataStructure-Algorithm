package leetcode.editor.cn;

import org.junit.Test;


public class B_BestTimeToBuyAndSellStock {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int minBuyPrice = prices[0];
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > minBuyPrice) {
                    res = Math.max(res, prices[i] - minBuyPrice);
                } else {
                    //更新买入价格
                    minBuyPrice = prices[i];
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}