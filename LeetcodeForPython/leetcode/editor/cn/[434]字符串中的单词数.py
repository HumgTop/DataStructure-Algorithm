from typing import *

# 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
# 
#  请注意，你可以假定字符串里不包括任何不可打印的字符。 
# 
#  示例: 
# 
#  输入: "Hello, my name is John"
# 输出: 5
# 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
#  
#  Related Topics 字符串 
#  👍 60 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import re


class Solution:
    def countSegments(self, s: str) -> int:
        return len(s.split())

        # if len(s) == 0: return 0
        # pattern = re.compile('\s')
        #
        # string = re.split(pattern, s)
        # n = len(string)
        # for ch in string:
        #     if ch == '': n -= 1
        # return n


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    print(Solution().countSegments('            '))
    pass
