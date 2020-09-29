from typing import *

# 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
# 的字符构成。如果可以构成，返回 true ；否则返回 false。 
# 
#  (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
# 
#  
# 
#  注意： 
# 
#  你可以假设两个字符串均只含有小写字母。 
# 
#  canConstruct("a", "b") -> false
# canConstruct("aa", "ab") -> false
# canConstruct("aa", "aab") -> true
#  
#  Related Topics 字符串 
#  👍 113 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        magMap = collections.Counter(magazine)
        for ch in ransomNote:
            # 如果没有key为ch，默认值为0
            if magMap.get(ch, 0) == 0:
                return False
            else:
                magMap[ch] -= 1

        return True


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
