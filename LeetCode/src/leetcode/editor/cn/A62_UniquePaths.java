package leetcode.editor.cn;


import java.util.Arrays;

public class A62_UniquePaths {
    public static void main(String[] args) {

        Solution solution = new A62_UniquePaths().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            //维护1个一维dp数组
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < m - 1; i++) {
                for (int j = 1; j < dp.length; j++) {
                    dp[j] += dp[j - 1];
                }
            }

            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}