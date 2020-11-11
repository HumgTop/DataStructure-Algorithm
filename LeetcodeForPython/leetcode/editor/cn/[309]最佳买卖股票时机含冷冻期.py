from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # state为0表示不持有股票，且今天不能买入（昨天卖出）
        # state为1表示持有股票
        # state为2表示不持有股票，今天可以买入
        def dfs(index: int, state: int, profit: int):
            if state == 1:
                # 今天卖出股票
                dfs(index + 1, 0, profit + prices[index])

        for i in range(len(prices)):
            dfs(i, 1, -prices[i])


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
