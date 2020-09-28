from typing import *

# 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
# 的三元组。 
# 
#  注意：答案中不可以包含重复的三元组。 
# 
#  
# 
#  示例： 
# 
#  给定数组 nums = [-1, 0, 1, 2, -1, -4]，
# 
# 满足要求的三元组集合为：
# [
#   [-1, 0, 1],
#   [-1, -1, 2]
# ]
#  
#  Related Topics 数组 双指针 
#  👍 2626 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import itertools


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []

        for k in range(len(nums) - 2):
            if k > 0 and nums[k] == nums[k - 1]: continue
            # 每次循环固定住k，i指针从k+1向右移动，j从nums尾部向左移动
            if nums[k] > 0: break  # 如果第一个元素>则结果肯定为空
            i = k + 1
            j = len(nums) - 1
            while i < j:
                sums = nums[k] + nums[i] + nums[j]
                # i需要右移，以增大sums
                if sums < 0:
                    i += 1
                    while i < j and nums[i] == nums[i - 1]: i += 1  # 跳过重复nums[i]
                elif sums > 0:
                    # j需要左移，以减小sums
                    j -= 1
                    while i < j and nums[j] == nums[j + 1]: j -= 1
                else:
                    res.append([nums[k], nums[i], nums[j]])
                    # i和j都需要移动
                    i += 1
                    while i < j and nums[i] == nums[i - 1]: i += 1  # 跳过重复nums[i]
                    j -= 1
                    while i < j and nums[j] == nums[j + 1]: j -= 1

        return res

        # 自解：超时
        # res = []
        # for i, j, k in itertools.combinations(nums, 3):
        #     if i + j + k == 0: res.append([i, j, k])
        #
        # temp = set()
        # for i, j in enumerate(res):
        #     j.sort()
        #     temp.add(tuple(j))
        #
        # res.clear()
        # for each in temp:
        #     res.append(list(each))
        #
        # return res
        # pass
        # leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    a = [0, 1, -1]
    b = [1, 0, -1]
    c = ''.join([str(x) for x in sorted(a)])
    print(c)
    pass
