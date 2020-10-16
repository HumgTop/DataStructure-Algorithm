from typing import *


# 给定一个可包含重复数字的序列，返回所有不重复的全排列。
# 
#  示例: 
# 
#  输入: [1,1,2]
# 输出:
# [
#   [1,1,2],
#   [1,2,1],
#   [2,1,1]
# ] 
#  Related Topics 回溯算法 
#  👍 493 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []

        def recur(used: List[int], level: List[int], rest: int = n):
            if not rest:
                res.append(level.copy())
                return

            levelSelect = set()
            for i in range(n):
                # 元素值不可相同
                # 元素索引不可相同
                if nums[i] not in levelSelect and not used[i]:
                    levelSelect.add(nums[i])
                    used[i] = 1
                    level.append(nums[i])
                    recur(used, level, rest - 1)
                    level.pop()
                    used[i] = 0

        recur([0] * n, [])
        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().permuteUnique([1, 1, 2]))
    pass
