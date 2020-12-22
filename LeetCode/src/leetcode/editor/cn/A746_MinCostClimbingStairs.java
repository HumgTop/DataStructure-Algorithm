package leetcode.editor.cn;


import java.util.Arrays;

public class A746_MinCostClimbingStairs {
    public static void main(String[] args) {

        Solution solution = new A746_MinCostClimbingStairs().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            if (n == 2) {
                return Math.min(cost[0], cost[1]);
            }

            int pre1 = 0;
            int pre2 = 0;
            int res = 0;
            for (int i = 2; i <= n; i++) {
                res = Math.min(pre1 + cost[i - 1], pre2 + cost[i - 2]); //到达第i层台阶的最小体力花费
                pre2 = pre1;
                pre1 = res;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}