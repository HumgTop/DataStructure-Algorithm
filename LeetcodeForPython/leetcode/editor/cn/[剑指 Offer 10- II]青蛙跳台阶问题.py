from typing import *


# 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
# 
#  答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
# 
#  示例 1： 
# 
#  输入：n = 2
# 输出：2
#  
# 
#  示例 2： 
# 
#  输入：n = 7
# 输出：21
#  
# 
#  示例 3： 
# 
#  输入：n = 0
# 输出：1 
# 
#  提示： 
# 
#  
#  0 <= n <= 100 
#  
# 
#  注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
# 
#  
#  Related Topics 递归 
#  👍 73 👎 0

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numWays(self, n: int) -> int:
        # 动态规划，只需要3个变量来维护dp数组
        if n == 0 or n == 1: return 1
        fir = 1
        sec = 1

        res = 0
        for i in range(2, n + 1):
            res = (fir + sec) % 1000000007
            fir, sec = sec, res

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    print(Solution().numWays(7))
    pass
