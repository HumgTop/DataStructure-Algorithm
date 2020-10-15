from typing import *

# 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
# 
#  说明：解集不能包含重复的子集。 
# 
#  示例: 
# 
#  输入: nums = [1,2,3]
# 输出:
# [
#   [3],
#   [1],
#   [2],
#   [1,2,3],
#   [1,3],
#   [2,3],
#   [1,2],
#   []
# ] 
#  Related Topics 位运算 数组 回溯算法 
#  👍 838 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import itertools


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # 回溯算法
        res = [[], nums]
        n = len(nums)

        def recur(rest: int, visited: List[int], start: int = 0):
            if rest == 0:
                res.append([nums[x] for x in range(n) if visited[x]])
                return

            for i in range(start, n):
                visited[i] = 1  # 被选元素添加到level中
                recur(rest - 1, visited, i + 1)  # 有rest-1的限制，i+1不会越界>n-1
                visited[i] = 0  # 撤销选择

        for i in range(1, n):
            recur(i, [0] * n)

        return res

    # 内置的排列组合方法


# res = [[], nums]
# for i in range(1, len(nums)):
#     for j in itertools.combinations(nums, i):
#         res.append(j)
#
# return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
