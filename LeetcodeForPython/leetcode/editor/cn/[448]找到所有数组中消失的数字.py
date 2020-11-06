from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # num[i]-1的区间是[0,n-1]，对应数组的下标区间
        # 修改nums[nums[i]-1]为负值，修改完成后遍历数组，对于nums[nums[i]-1]>0的值，说明不存在num[i]-1==i，消失的数字为i+1
        n = len(nums)
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -nums[index]

        return [i + 1 for i in range(n) if nums[i] > 0]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
