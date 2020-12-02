from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [0] * n
        # 判断第一行有无障碍物
        for i, val in enumerate(obstacleGrid[0]):
            if not val:
                dp[i] = 1  # 初始化dp数组
            else:
                break

        for r in range(1, m):
            # 如果该行第一列有障碍物
            if obstacleGrid[r][0]: dp[0] = 0
            for c in range(1, n):
                # 状态转移
                if obstacleGrid[r][c]:  # 如果有障碍物
                    dp[c] = 0
                else:
                    dp[c] += dp[c - 1]

        return dp[n - 1]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
