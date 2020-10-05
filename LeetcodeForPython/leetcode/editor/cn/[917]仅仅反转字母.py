from typing import *


# 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
# 
#  
# 
#  
#  
# 
#  示例 1： 
# 
#  输入："ab-cd"
# 输出："dc-ba"
#  
# 
#  示例 2： 
# 
#  输入："a-bC-dEf-ghIj"
# 输出："j-Ih-gfE-dCba"
#  
# 
#  示例 3： 
# 
#  输入："Test1ng-Leet=code-Q!"
# 输出："Qedo1ct-eeLg=ntse-T!"
#  
# 
#  
# 
#  提示： 
# 
#  
#  S.length <= 100 
#  33 <= S[i].ASCIIcode <= 122 
#  S 中不包含 \ or " 
#  
#  Related Topics 字符串 
#  👍 61 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        temp = []  # 存储去除 - 的字符串
        index = []

        for i, ch in enumerate(S):
            if not ch.isalpha():  # 如果不是字母，记录该字符的索引和字符值
                index.append([i, ch])  # 记录符号 - 的索引
                continue
            temp.append(ch)

        temp.reverse()

        for each in index:
            temp.insert(each[0], each[1])

        return ''.join(temp)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    a = [1, 2, 3]
    a.insert(1, 5)
    print(a)
    pass
