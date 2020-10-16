from typing import *


# 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
# 
#  说明：解集不能包含重复的子集。 
# 
#  示例: 
# 
#  输入: [1,2,2]
# 输出:
# [
#   [2],
#   [1],
#   [1,2,2],
#   [2,2],
#   [1,2],
#   []
# ] 
#  Related Topics 数组 回溯算法 
#  👍 326 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        # 回溯算法
        res = [[], nums]
        n = len(nums)

        def recur(rest: int, temp: List[int], start: int = 0):
            if not rest:
                res.append(temp.copy())
                return

            # levelSelect = set()
            for i in range(start, n):
                if i > start and nums[i]==nums[i-1]:continue
                # levelSelect.add(nums[i])
                temp.append(nums[i])
                recur(rest - 1, temp, i + 1)
                temp.pop()

        for i in range(1, n):
            recur(i, [])

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
