from typing import *


# 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下： 
# 
#  F(0) = 0,   F(1) = 1
# F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
# 
#  斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
# 
#  答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
# 
#  
# 
#  示例 1： 
# 
#  输入：n = 2
# 输出：1
#  
# 
#  示例 2： 
# 
#  输入：n = 5
# 输出：5
#  
# 
#  
# 
#  提示： 
# 
#  
#  0 <= n <= 100 
#  
# 
#  注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/ 
#  Related Topics 递归 
#  👍 62 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    hashMap = {}  # key为n，value为fib[n]

    def fib(self, n: int) -> int:
        # 记忆化递归
        constant = 1000000007
        if n < 2: return n

        # 查找hashMap中有无当前的fib数，有的话直接返回
        if n in Solution.hashMap: return Solution.hashMap[n]
        # 否则计算后存入哈希表
        if n - 1 in Solution.hashMap:
            fib1 = Solution.hashMap[n - 1]
        else:
            fib1 = self.fib(n - 1) % constant
            Solution.hashMap[n - 1] = fib1

        if n - 2 in Solution.hashMap:
            fib2 = Solution.hashMap[n - 2]
        else:
            fib2 = self.fib(n - 2) % constant
            Solution.hashMap[n - 2] = fib2

        Solution.hashMap[n] = (fib1 + fib2) % constant
        return Solution.hashMap[n]

        # 动态规划
        # if n == 0: return 0
        # if n == 1: return 1
        # # 动态规划
        # a = 0
        # b = 1
        # sums = 0
        # for i in range(2, n + 1):
        #     sums = (a + b) % 1000000007
        #     a, b = b, sums  # 更新a，b
        #
        # return sums


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
