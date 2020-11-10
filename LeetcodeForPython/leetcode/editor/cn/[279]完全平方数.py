from typing import *
import math


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numSquares(self, n: int) -> int:
        square_nums = set([i * i for i in range(1, int(n ** 0.5) + 1)])

        # 判断n能由cnt个完全平方数组合
        def isDividedBy(n, cnt):
            # 终止条件
            if cnt == 1: return n in square_nums

            for num in square_nums:
                # 状态转移
                if isDividedBy(n - num, cnt - 1): return True

            return False

        # 贪心的从最优结果 -> 最差结果遍历判断
        for cnt in range(1, n + 1):
            if isDividedBy(n, cnt): return cnt


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().numSquares(13))
    pass
