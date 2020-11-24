from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        for r in range(1, n):
            m = len(triangle[r]) - 1
            # 处理该行的头部和尾部元素
            triangle[r][0] += triangle[r - 1][0]
            triangle[r][m] += triangle[r - 1][m - 1]
            # 处理该行其他元素
            for c in range(1, m):
                triangle[r][c] += min(triangle[r - 1][c - 1], triangle[r - 1][c])

        return min(triangle[n - 1])


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
