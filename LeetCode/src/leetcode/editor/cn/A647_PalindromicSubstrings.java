package leetcode.editor.cn;


//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 425 👎 0


public class A647_PalindromicSubstrings {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            int res = 0;
            boolean[][] dp = new boolean[n][n]; //dp[i][j]为true表示：下标 i 到 j 的子串为回文串

            //初始化子串长度为1,2的dp值
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
                res++;
            }
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    res++;
                }
            }
            //子串长度从3到n
            for (int len = 3; len < n + 1; len++) {
                //i指向子串的首位置
                int j;
                for (int i = 0; i <= n - len; i++) {
                    j = i + len - 1;    //j指向子串的末位置
                    //状态转移
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}