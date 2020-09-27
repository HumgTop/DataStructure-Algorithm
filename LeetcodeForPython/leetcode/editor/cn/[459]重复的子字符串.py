from typing import *


# 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
# 
#  示例 1: 
# 
#  
# 输入: "abab"
# 
# 输出: True
# 
# 解释: 可由子字符串 "ab" 重复两次构成。
#  
# 
#  示例 2: 
# 
#  
# 输入: "aba"
# 
# 输出: False
#  
# 
#  示例 3: 
# 
#  
# 输入: "abcabcabcabc"
# 
# 输出: True
# 
# 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
#  
#  Related Topics 字符串 
#  👍 369 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        temp = s * 2
        temp = temp[1:-1]  # 拼接后去掉首尾字符
        # 如果找不到返回false(-1!=-1)
        return temp.find(s) != -1


# class Solution:
#     def repeatedSubstringPattern(self, s: str) -> bool:
#         n = len(s)
#
#         for i in range(1, n // 2 + 1):
#             # 假设重复字符串的长度为i，且i能被n整除
#             if n % i == 0:
#                 for j in range(i, n):
#                     # 只要有一个不匹配就跳出循环
#                     if s[j] != s[j - i]: break
#                 # 如果所有元素都匹配返回true
#                 else:
#                     return True
#         return False


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    a = '1234'
    s = a * 2
    print(s[1:-1])
    pass
