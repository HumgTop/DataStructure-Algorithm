package leetcode.editor.cn;


public class B_JianShengZiLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            //dp[i]表示长度为i的数组，剪成m段后的最大乘积
            int[] dp = new int[n + 1];
            dp[2] = 1;
            //对长度为i的绳子进行动态规划
            for (int i = 3; i <= n; i++) {
                //第一段截取的长度（遍历第一段所有可能截取的长度，选取最优的dp[i]结果)
                for (int j = 2; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }

            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}