package leetcode.editor.cn;

import java.util.Arrays;

public class A_122BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new A_122BestTimeToBuyAndSellStockIi().new Solution();
        // TO TEST
        System.out.println(solution.maxProfit(new int[]{5, 2, 3, 2, 6, 6, 2, 9, 1, 0, 7, 4, 5, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}