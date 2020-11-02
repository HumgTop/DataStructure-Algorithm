from typing import *


# 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
# 
#  如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
# 
#  必须原地修改，只允许使用额外常数空间。 
# 
#  以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
# 1,2,3 → 1,3,2 
# 3,2,1 → 1,2,3 
# 1,1,5 → 1,5,1 
#  Related Topics 数组 
#  👍 717 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        index = 0  # 降序序列的起始下标
        flag = False

        for i in range(n - 1, 0, -1):
            # 此时的[i,n-1]为降序排列
            if nums[i] > nums[i - 1]:
                # 如果降序序列为空
                if i == n - 1:
                    nums[i], nums[i - 1] = nums[i - 1], nums[i]
                    flag = True
                else:
                    for j in range(n - 1, i - 1, -1):
                        # 在降序序列[i,n-1]中找到大于nums[i-1]的最小数
                        if nums[j] > nums[i - 1]:
                            # 交换两数
                            nums[i - 1], nums[j] = nums[j], nums[i - 1]
                            index = i  # 记录降序序列的起始下标
                            break
                break

        # 将[index,n-1]的元素重新置为升序
        k1, k2 = index, n - 1
        while not flag and k1 < k2:
            nums[k1], nums[k2] = nums[k2], nums[k1]
            k1 += 1
            k2 -= 1


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    Solution().nextPermutation([1, 5, 8, 4, 7, 6, 5, 3, 1])
    pass
