package leetcode.editor.cn;

import org.junit.Test;


public class B_LongestValidParentheses {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            char[] chs = s.toCharArray();
            int n = chs.length;
            int[] dp = new int[n + 1];  //dp[i]表示以chs中第i个字符结尾的合法括号对的长度

            int res = 0;
            for (int i = 2; i <= n; i++) {
                if (chs[i - 1] == ')') {
                    if (chs[i - 2] == '(') {
                        dp[i] = dp[i - 2] + 2;
                    } else if (chs[i - 2] == ')') {
                        //找到与chs[i-1]匹配的字符
                        int subLen = dp[i - 1]; //前一个合法括号子串的长度
                        int j = i - subLen - 2;
                        if (j < 0) {
                            //如果越界则跳过
                            continue;
                        }
                        if (chs[j] == '(') {
                            //匹配成功
                            //最后需要加上以 chs[j-1]/第j个字符 结尾的有效子串长度
                            dp[i] = dp[i - 1] + 2 + dp[j];
                        }
                    }

                    res = Math.max(res, dp[i]);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}