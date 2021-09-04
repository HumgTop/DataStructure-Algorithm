package leetcode.editor.cn;

import org.junit.Test;


public class B_EditDistance {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            //用 D[i][j] 表示 A 的前 i 个字母和 B 的前 j 个字母之间的编辑距离。
            //需要考虑word1或者word2为空的情况
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0) {
                        dp[i][j] = j;
                    } else if (j == 0) {
                        dp[i][j] = i;
                    } else {
                        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else {
                            dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                        }
                    }
                }
            }

            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}