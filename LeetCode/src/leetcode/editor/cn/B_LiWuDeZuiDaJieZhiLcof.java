package leetcode.editor.cn;


public class B_LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            //dp[i][j]表示在(i,j)网格处累计可拿到最大价值的礼物
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (r - 1 >= 0 && c - 1 >= 0) {
                        dp[r][c] = Math.max(dp[r - 1][c] + grid[r][c], dp[r][c - 1] + grid[r][c]);
                    } else if (r - 1 >= 0) {
                        dp[r][c] = dp[r - 1][c] + grid[r][c];
                    } else if (c - 1 >= 0) {
                        dp[r][c] = dp[r][c - 1] + grid[r][c];
                    }
                }
            }

            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}