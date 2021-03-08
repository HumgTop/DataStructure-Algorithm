from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        nums.sort()
        temp1 = nums[-1] * nums[-2] * nums[-3]
        temp2 = nums[0] * nums[1] * nums[-1]
        return temp1 if temp1 > temp2 else temp2


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
