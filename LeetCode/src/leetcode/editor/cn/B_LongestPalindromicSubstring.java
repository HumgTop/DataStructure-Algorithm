package leetcode.editor.cn;


public class B_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = new B_LongestPalindromicSubstring().new Solution().longestPalindrome("cbbd");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char[] chs = s.toCharArray();
            int n = s.length();
            boolean[][] dp = new boolean[n][n]; //dp[i][j]表示[i,j]子串是否为回文串
            int maxLen = 1;
            int left = 0;
            int right = 0;

            //初始化dp，delta=0的子串都为回文串
            for (int delta = 0; delta < n; delta++) {
                //start为子串的首位字符索引，start+delta为末位字符索引
                int end;
                for (int start = 0; start + delta < n; start++) {
                    end = start + delta;
                    if (delta == 0) {
                        dp[start][end] = true;
                    } else if (delta == 1) {
                        if (chs[start] == chs[end]) dp[start][end] = true;
                    } else {
                        //正常转移
                        if (dp[start + 1][end - 1] && chs[start] == chs[end]) {
                            dp[start][end] = true;
                        }
                    }

                    if (dp[start][end] && end - start + 1 > maxLen) {
                        maxLen = end - start + 1;
                        left = start;
                        right = end;
                    }
                }
            }

            return s.substring(left, right + 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}