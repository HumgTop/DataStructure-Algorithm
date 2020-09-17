from typing import *


# 给定一个整数数组，找出总和最大的连续数列，并返回总和。
# 
#  示例： 
# 
#  输入： [-2,1,-3,4,-1,2,1,-5,4]
# 输出： 6
# 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
#  
# 
#  进阶： 
# 
#  如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
#  Related Topics 数组 分治算法 动态规划 
#  👍 42 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]
        pre_sum = nums[0]
        max_sum = pre_sum
        for i in nums[1:]:
            cur_sum = max(pre_sum + i, i)
            pre_sum = cur_sum
            if cur_sum > max_sum: max_sum = cur_sum

        return max_sum


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
