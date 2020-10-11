from typing import *


# 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
# 
#  注意: 
# 
#  
#  每个数组中的元素不会超过 100 
#  数组的大小不会超过 200 
#  
# 
#  示例 1: 
# 
#  输入: [1, 5, 11, 5]
# 
# 输出: true
# 
# 解释: 数组可以分割成 [1, 5, 5] 和 [11].
#  
# 
#  
# 
#  示例 2: 
# 
#  输入: [1, 2, 3, 5]
# 
# 输出: false
# 
# 解释: 数组不能分割成两个元素和相等的子集.
#  
# 
#  
#  Related Topics 动态规划 
#  👍 473 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        # 动态规划 | 一维dp数组
        n = len(nums)
        total = sum(nums)
        if n < 2 or total & 1 == 1: return False
        target = total // 2
        if max(nums) > target: return False

        # 初始化dp数组：1行target+1列
        dp = [False] * (target + 1)
        # 处理边界情况
        # 第1列
        dp[0] = True
        # 第1行：target为nums[0]时，dp值为True
        dp[nums[0]] = True

        # 更新dp数组：更新n-1次
        for i in range(1, n):
            # j从大到小计算，需要保证计算dp[j]时，dp[j-nums[i]]还没有更新
            for j in range(target, 0, -1):
                if j >= nums[i]:
                    dp[j] = (dp[j] or dp[j - nums[i]])
                # 如果j<nums[i]，说明nums[i]不可选取，dp[j]无需更新

        return dp[target]

        # 动态规划 | 二维dp数组
        # n = len(nums)
        # total = sum(nums)
        # if n < 2 or total & 1 == 1: return False
        # target = total // 2
        # if max(nums) > target: return False
        #
        # # 初始化dp数组：n行target+1列
        # dp = [[False] * (target + 1) for _ in range(n)]
        # # 处理边界情况
        # # 第1列
        # for i in range(n):
        #     dp[i][0] = True
        # # 第1行：target为nums[0]时，dp值为True
        # dp[0][nums[0]] = True
        #
        # # 处理dp数组
        # for r in range(1, n):
        #     for c in range(1, target + 1):
        #         if c >= nums[r]:  # 2种情况：选和不选
        #             dp[r][c] = dp[r - 1][c] or dp[r - 1][c - nums[r]]
        #         else:
        #             # 改元素不可选，沿用上行的策略
        #             dp[r][c] = dp[r - 1][c]
        #
        # return dp[n - 1][target]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
