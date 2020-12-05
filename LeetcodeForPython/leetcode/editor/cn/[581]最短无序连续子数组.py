from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        stack = []  # 单调栈（记录索引）
        left = len(nums) - 1
        right = 0
        # 找到无序数组的左边界
        for i, num in enumerate(nums):
            # 保持栈的单调性质
            while stack and nums[stack[-1]] > num:
                # 出栈的索引说明此位置元素需要重排，其中最小的索引就是无序数组的左边界
                left = min(left, stack.pop())
            stack.append(i)

        for i in range(len(nums) - 1, -1, -1):
            # 保持栈的单调性质
            while stack and nums[stack[-1]] < nums[i]:
                # 出栈的索引说明此位置元素需要重排，其中最大的索引就是无序数组的右边界
                right = max(right, stack.pop())
            stack.append(i)

        return right - left + 1 if right - left > 0 else 0


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    a = (1, 2)
    b = (1, 2)
    mp = {a: 1}
    if b in mp:
        mp[b] = 3
        print(mp[a])

    pass
