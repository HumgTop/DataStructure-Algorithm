from typing import *


# 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
# 
#  示例: 
# 
#  输入: 3
# 输出: 5
# 解释:
# 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
# 
#    1         3     3      2      1
#     \       /     /      / \      \
#      3     2     1      1   3      2
#     /     /       \                 \
#    2     1         2                 3 
#  Related Topics 树 动态规划 
#  👍 860 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numTrees(self, n: int) -> int:
        # 记忆化递归
        memory = [0] * (n + 1)
        memory[0] = memory[1] = 1

        def recur(j: int = n) -> int:  # 返回memory[j]的值
            if memory[j] != 0: return memory[j]

            for i in range(1, j + 1):
                memory[j] += recur(i - 1) * recur(j - i)

            # 在返回值的同时，也将值记录在了memory数组中
            return memory[j]

        return recur()

    # 动态规划
    # dp = [0] * (n + 1)
    # dp[0] = dp[1] = 1
    #
    # for i in range(2, n + 1):
    #     for j in range(1, i + 1):
    #         dp[i] += dp[j - 1] * dp[i - j]
    #
    # return dp[n]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
