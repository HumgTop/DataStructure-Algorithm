from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        n = len(nums)
        mp = {}  # mp[(i,curSum)]表示在一张有向图中，从（i,curSum):第i层的curSum节点，到达终点(n,S)的路径数

        # 返回(i,curSum)到达终点的路径条数
        def dfs(i: int, curSum: int) -> int:
            # 终止条件
            if i == n:
                return 0 if curSum != S else 1

            # 优先从哈希表中取值
            if (i, curSum) not in mp:
                mp[(i, curSum)] = dfs(i + 1, curSum - nums[i]) + dfs(i + 1, curSum + nums[i])
            return mp[(i, curSum)]

        return dfs(0, 0)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().findTargetSumWays([1, 1, 1], 1))
    pass
