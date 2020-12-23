from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        n = len(nums)
        nums.sort()
        if n == 3: return sum(nums)
        res = nums[0] + nums[1] + nums[2]

        i = 0
        while i < n - 2:  # 固定第一个元素，遍历第二和第三个元素的组合
            left = i + 1
            right = n - 1
            while left < right:
                cursum = nums[i] + nums[left] + nums[right]

                if cursum == target: return cursum

                if abs(cursum - target) < abs(res - target): res = cursum  # 维护res为目前为止最接近target的值
                # 对cursum迭代的策略
                if cursum > target:
                    right -= 1
                    while left < right == right - 1:  # 避免遍历重复元素
                        right -= 1
                else:
                    left += 1
                    while right > left == left + 1:
                        left += 1
            while n - 2 > i == i + 1:
                i += 1
            i += 1

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().threeSumClosest([0, 2, 1, -3], 1))
    pass
