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
            int n = word1.length();
            int m = word2.length();
            int[][] dp = new int[n + 1][m + 1]; //dp[i][j]表示word1前i个字符转换为word2前j个字符的最小操作次数

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    if (i == 0) {
                        dp[i][j] = j;
                    } else if (j == 0) {
                        dp[i][j] = i;
                    } else {
                        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                            //如果字符相同需要进行修改
                            dp[i][j] = dp[i - 1][j - 1];
                        } else {
                            //如果字符不同，分三种情况
                            //1. word1[:i]转为word2[:j-1]，再添加word2[j]
                            //2. 删除word1[i]，再从word1[:i-1]转为word2[:j]
                            //3. 将word1[i-1]转为word2[j-1]，再将word1[i]修改为word2[j]
                            dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                        }
                    }
                }
            }

            return dp[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}