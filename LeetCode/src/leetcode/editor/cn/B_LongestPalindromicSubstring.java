package leetcode.editor.cn;


public class B_LongestPalindromicSubstring {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char[] chs = s.toCharArray();
            boolean[][] dp = new boolean[s.length()][s.length()];   //dp[i][j]表示索引i到j的子串是否是回文串
            int maxLen = 1;
            int i = 0, j = 0;
            //转移过程：从短子串向长子串转移
            //delta为end-start，子串长度为delta+1
            for (int delta = 0; delta < s.length(); delta++) {
                int end;
                //end越界则结束循环
                for (int start = 0; (end = start + delta) < s.length(); start++) {
                    if (delta == 0)
                        dp[start][end] = true;
                    else if (delta == 1 && chs[start] == chs[end])
                        dp[start][end] = true;
                    else {
                        dp[start][end] = dp[start + 1][end - 1] && (chs[start] == chs[end]);
                    }
                    if (dp[start][end] && delta + 1 > maxLen) {
                        maxLen = delta + 1;
                        i = start;
                        j = end;
                    }
                }
            }

            return s.substring(i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}