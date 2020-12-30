from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def cuttingRope(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = dp[1] = 0

        for i in range(2, n + 1):
            curMax = 0
            # 将i至少拆分为j,i-j两个整数组成(1<=j<=i-1)
            for j in range(1, i):
                curMax = max(max(j * (i - j), j * dp[i - j]), curMax)  # dp[i]应取在j循环中最大的curMax
            dp[i] = curMax

        return dp[n]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
