package leetcode.editor.cn;

public class A_221MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new A_221MaximalSquare().new Solution();
        System.out.println(solution.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        }));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximalSquare(char[][] matrix) {
            if (matrix.length == 0) return 0;

            int m = matrix.length;
            int n = matrix[0].length;
            int maxLen = 0;

            int[][] dp = new int[m][n]; //dp[i][j]表示以i,j为右下角顶点的最大正方形的边长
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    //如果当前网格值为1（可以作为正方形右下角顶点的前提）
                    if (matrix[r][c] == '1') {
                        if ((r - 1 < 0 || c - 1 < 0)) {
                            dp[r][c] = 1;  //如果[r,c]在边界上，最大边长只可能为1}
                        } else {
                            //状态转移
                            dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1;
                        }
                        //更新maxLen为dp数组中最大的值
                        maxLen = Math.max(maxLen, dp[r][c]);
                    }
                }
            }
            return maxLen * maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}