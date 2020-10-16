from typing import *


# 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
# 
#  示例: 
# 
#  输入: [1,2,3]
# 输出:
# [
#   [1,2,3],
#   [1,3,2],
#   [2,1,3],
#   [2,3,1],
#   [3,1,2],
#   [3,2,1]
# ] 
#  Related Topics 回溯算法 
#  👍 955 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        # 回溯算法
        n = len(nums)
        res = []

        def recur(visited: List[int], level: List[int], rest: int = n):
            """
            因为是全排列，所以没有start，只需要visited
            :param rest:
            :param visited: 判断某个元素是否已经被使用
            """
            if not rest:
                res.append(level.copy())
                return

            for i in range(n):
                # 同层之间不可选择之前递归已经选择的元素
                if not visited[i]:
                    visited[i] = 1
                    level.append(nums[i])
                    recur(visited, level, rest - 1)
                    level.pop()
                    visited[i] = 0

        recur([0] * n, [])
        return res
        pass


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().permute([1, 2, 3]))
    pass
