from typing import *


# 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
# 有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。 
# 
#  示例1: 
# 
#  
#  输入："aabcccccaaa"
#  输出："a2b1c5a3"
#  
# 
#  示例2: 
# 
#  
#  输入："abbccd"
#  输出："abbccd"
#  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
#  
# 
#  提示： 
# 
#  
#  字符串长度在[0, 50000]范围内。 
#  
#  Related Topics 字符串 
#  👍 53 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def compressString(self, S: str) -> str:
        n = len(S)  # 原字符串长度
        temp = '0' + S + '0'  # 添加2个哨兵
        res = []
        cur = ''
        count = 0
        for i in range(1, n + 2):
            # 如果遇到新字符，重置cur和count
            if temp[i] != temp[i - 1]:
                # 把S[i-1]添加到res中
                res.append('%s%d' % (cur, count))
                cur = temp[i]
                count = 1
            else:
                count += 1
        res = ''.join(res[1:])
        return res if len(res) < n else S
        pass


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    print(Solution().compressString("abbccd"))
    pass
