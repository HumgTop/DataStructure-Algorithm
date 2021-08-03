package leetcode.editor.cn;


import java.util.*;
import java.util.stream.Collectors;

public class B_NgeTouZiDeDianShuLcof {
    public static void main(String[] args) {
        Solution solution = new B_NgeTouZiDeDianShuLcof().new Solution();
        double[] res = solution.dicesProbability(2);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] dicesProbability(int n) {
            int[][] dp = new int[n + 1][6 * n + 1]; //dp[i][j]表示第i次投掷，点数和j出现的次数
            for (int j = 1; j <= 6; j++) {
                dp[1][j] = 1;
            }

            for (int i = 2; i <= n; i++) {
                //遍历第i次投掷可能出现的和
                for (int j = i; j <= i * 6; j++) {
                    for (int k = 1; k <= 6; k++) {
                        if (j - k > 0) dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }

            double allCnt = Math.pow(6, n);
            double[] res = new double[5 * n + 1];
            int idx = 0;
            for (int i = n; i <= 6 * n; i++) {
                res[idx++] = dp[n][i] / allCnt;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}