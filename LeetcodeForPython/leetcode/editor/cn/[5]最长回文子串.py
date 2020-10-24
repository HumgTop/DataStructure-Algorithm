from typing import *


# 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
# 
#  示例 1： 
# 
#  输入: "babad"
# 输出: "bab"
# 注意: "aba" 也是一个有效答案。
#  
# 
#  示例 2： 
# 
#  输入: "cbbd"
# 输出: "bb"
#  
#  Related Topics 字符串 动态规划 
#  👍 2827 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False] * n for _ in range(n)]  # 维护一个二维dp数组
        res = ''

        # 枚举子串长度
        for l in range(n):
            # 枚举此子串长度下所有的子串
            for i in range(n):
                j = i + l  # 子串的结束位置
                if j >= len(s): break  # 如果结束位置越界，结束循环
                # 处理2个边界条件，及l==0和l==1时
                if l == 0:
                    dp[i][j] = True  # 单个字符都是回文串
                elif l == 1:
                    dp[i][j] = (s[i] == s[j])  # 长度为2的子串，只要2个字母相同也是回文串
                else:
                    # 状态转移
                    dp[i][j] = (dp[i + 1][j - 1] and s[i] == s[j])

                # 如果当前子串是回文串，且长度最长，更新res
                if dp[i][j] and l + 1 > len(res): res = s[i:j + 1]

        return res

        # leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print('hi')
    pass
