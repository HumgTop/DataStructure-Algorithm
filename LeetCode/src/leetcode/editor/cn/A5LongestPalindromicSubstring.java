package leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2827 👎 0

public class A5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new A5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            String res = "";

            //枚举所有子串长度
            for (int l = 0; l < n; l++) {
                //枚举该长度下的所有子串
                //i为子串起始位置
                for (int i = 0; i < n; i++) {
                    int j = i + l; //子串结束位置（可取到）

                    if (j >= n) break; //该长度字符串枚举结束

                    if (l == 0) dp[i][j] = true;
                    else if (l == 1 && s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    }

                    if (dp[i][j] && l + 1 > res.length()) res = s.substring(i, j + 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}