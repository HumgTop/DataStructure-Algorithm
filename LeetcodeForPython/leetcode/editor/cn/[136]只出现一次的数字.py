from typing import *

# 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
# 
#  说明： 
# 
#  你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
# 
#  示例 1: 
# 
#  输入: [2,2,1]
# 输出: 1
#  
# 
#  示例 2: 
# 
#  输入: [4,1,2,1,2]
# 输出: 4 
#  Related Topics 位运算 哈希表 
#  👍 1504 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
from functools import reduce


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return reduce(lambda x, y: x ^ y, nums)


# class Solution:
#     def singleNumber(self, nums: List[int]) -> int:
#         numSet = set()
#         for num in nums:
#             if num not in numSet:
#                 numSet.add(num)
#             else:
#                 numSet.remove(num)
#
#         # 最后set中只剩下一个元素
#         for res in numSet:
#             return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
