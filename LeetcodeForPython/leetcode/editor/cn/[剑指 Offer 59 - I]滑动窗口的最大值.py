from typing import *
from queue import Queue
import collections
import itertools


# 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
# 
#  示例: 
# 
#  输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
# 输出: [3,3,5,5,6,7] 
# 解释: 
# 
#   滑动窗口的位置                最大值
# ---------------               -----
# [1  3  -1] -3  5  3  6  7       3
#  1 [3  -1  -3] 5  3  6  7       3
#  1  3 [-1  -3  5] 3  6  7       5
#  1  3  -1 [-3  5  3] 6  7       5
#  1  3  -1  -3 [5  3  6] 7       6
#  1  3  -1  -3  5 [3  6  7]      7 
# 
#  
# 
#  提示： 
# 
#  你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
# 
#  注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
#  Related Topics 队列 Sliding Window 
#  👍 115 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        deque = collections.deque()
        res = []
        n = len(nums)

        # 滑动窗口的移动和队列的操作同时进行，滑动窗口操作n-k+1次，队列操作n次
        for i, j in zip(range(1 - k, n - k + 1), range(n)):
            # 如果左端出列元素刚好是当前窗口的最大值，则队首出列
            if i > 0 and deque[0] == nums[i - 1]: deque.popleft()
            # 添加当前j指针到队尾前，先将队列中小于j指针的元素移除
            while deque and deque[-1] < nums[j]:
                # 当前j指针入列前，从队尾移除队列中所有比它小的元素（保持队列单调非递减）
                deque.pop()
            deque.append(nums[j])
            # 当i==0时，第一个滑动窗口最大值已经在deque队首，将其添加到res中
            if i >= 0: res.append(deque[0])

        return res


# class Solution:
#     def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
#         n = len(nums)
#         if n == 0: return []
#
#         res = []
#         # 共有n-k个滑动窗口
#         for i in range(0, n - k + 1):
#             res.append(max(nums[i:i + k]))
#         return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    print(Solution().maxSlidingWindow(nums, k))
    pass
