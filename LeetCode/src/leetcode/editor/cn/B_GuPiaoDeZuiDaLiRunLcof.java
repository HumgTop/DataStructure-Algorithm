package leetcode.editor.cn;


import org.junit.Test;

import java.util.ArrayDeque;

public class B_GuPiaoDeZuiDaLiRunLcof {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;

            int minPrice = prices[0];
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];   //更新最低买入价
                } else {
                    res = Math.max(res, prices[i] - minPrice);  //优化最大利润
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}