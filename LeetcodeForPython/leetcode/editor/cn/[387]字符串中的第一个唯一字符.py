from typing import *

# 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
# 
#  
# 
#  示例： 
# 
#  s = "leetcode"
# 返回 0
# 
# s = "loveleetcode"
# 返回 2
#  
# 
#  
# 
#  提示：你可以假定该字符串只包含小写字母。 
#  Related Topics 哈希表 字符串 
#  👍 270 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def firstUniqChar(self, s: str) -> int:
        counter = collections.Counter(s)
        for i, ch in enumerate(s):
            if counter[ch] == 1: return i

        return -1


# class Solution:
#     def firstUniqChar(self, s: str) -> int:
#         hashMap = {}
#         maxNum = float('inf')
#         for i, ch in enumerate(s):
#             if ch not in hashMap:
#                 hashMap[ch] = i
#             else:
#                 hashMap[ch] = maxNum  # ch出现超过一次，索引置为无穷大
#
#         # 按value排序字典，找到value不为maxNum的key
#         for ch, i in sorted(hashMap.items(), key=lambda item: item[1]):
#             if i != maxNum: return i
#
#         return -1


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    a = float('inf')
    b = float('inf')
    print(a == b)
    pass
