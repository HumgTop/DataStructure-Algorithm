package leetcode.editor.cn;


public class B_LongestPalindromicSubstring {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char[] chs = s.toCharArray();
            int n = s.length();
            boolean[][] dp = new boolean[n][n]; //dp[i][j]表示s[i:j]是否为回文串
            int res = 1;
            int start = 0;
            int end = 0;

            //delta为j-i，delta最大为n-1。
            //回文串总是从短子串向长子串转移的
            for (int delta = 0; delta < n; delta++) {
                //j=i+delta
                int j;
                for (int i = 0; (j = i + delta) < n; i++) {
                    if (delta == 0) {
                        //长度为1的子串都是回文串
                        dp[i][j] = true;
                    } else if (delta == 1 && chs[i] == chs[j]) {
                        //长度为2的子串
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1] && chs[i] == chs[j]) {
                            dp[i][j] = true;
                        }
                    }
                    if (dp[i][j] && delta + 1 > res) {
                        res = delta + 1;
                        start = i;
                        end = j;
                    }
                }
            }

            return s.substring(start, end + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}