from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        Max = nums[0]  # 以当前元素结尾的子数组的最大乘积
        Min = nums[0]  # 以当前元素结尾的子数组的最小乘积
        res = nums[0]

        for i in range(1, len(nums)):
            maxTemp = Max
            minTemp = Min
            Max = max(nums[i] * maxTemp, nums[i] * minTemp, nums[i])
            Min = min(nums[i] * maxTemp, nums[i] * minTemp, nums[i])
            # 更新res为状态转移过程中最大的Max值
            res = max(res, Max)

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
