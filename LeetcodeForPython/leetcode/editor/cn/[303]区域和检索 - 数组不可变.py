from typing import *


# 给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
# 
#  示例： 
# 
#  给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
# 
# sumRange(0, 2) -> 1
# sumRange(2, 5) -> -1
# sumRange(0, 5) -> -3 
# 
#  说明: 
# 
#  
#  你可以假设数组不可变。 
#  会多次调用 sumRange 方法。 
#  
#  Related Topics 动态规划 
#  👍 189 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.sums = [0]
        for i in range(len(nums)):
            self.sums.append(self.sums[i] + nums[i])

    def sumRange(self, i: int, j: int) -> int:
        return self.sums[j + 1] - self.sums[i]

    # Your NumArray object will be instantiated and called as such:


# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    nums = [-2, 0, 3, -5, 2, -1]
    a = NumArray(nums).sumRange(0, 5)
    pass
