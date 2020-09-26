from typing import *

# 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
# 
#  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
# 
#  
# 
#  示例: 
# 
#  给定 nums = [2, 7, 11, 15], target = 9
# 
# 因为 nums[0] + nums[1] = 2 + 7 = 9
# 所以返回 [0, 1]
#  
#  Related Topics 数组 哈希表 
#  👍 9216 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import itertools


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 先将nums的下标和对应的元素值转为HashMap
        numMap = dict(zip(nums, range(len(nums))))
        # 查找target-nums[i]的值是否在Map中
        for i, num in enumerate(nums):
            complement = target - num
            if complement in numMap and numMap[complement] != i:
                return [i, numMap[complement]]


# class Solution:
# def twoSum(self, nums: List[int], target: int) -> List[int]:
#     n = len(nums)
#     for i in range(n):
#         for j in range(i + 1, n):
#             if nums[i] + nums[j] == target: return [i, j]
#
#
# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         """
#         组合问题nums.length个元素中随机取2个数并求和，结果==target，则返回这两个元素下标
#         :param nums:
#         :param target:
#         :return:
#         """
#         for i, j in itertools.combinations(nums, 2):
#             if i + j == target:
#                 index = nums.index(i)
#                 return [index, nums.index(j, index + 1)]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    pass
