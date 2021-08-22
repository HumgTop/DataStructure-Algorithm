package leetcode.editor.cn;

import org.junit.Test;


public class B_MaximalSquare {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n]; //dp[i][j]表示以[i,j]为右下角的正方形的最大边长
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        //边界处理
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                        }
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }

            return res * res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}