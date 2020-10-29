from typing import *


# 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
# 
#  示例 1: 
# 
#  输入: [3,2,1,5,6,4] 和 k = 2
# 输出: 5
#  
# 
#  示例 2: 
# 
#  输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
# 输出: 4 
# 
#  说明: 
# 
#  你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
#  Related Topics 堆 分治算法 
#  👍 761 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# noinspection PyShadowingNames
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        leftChild = lambda x: 2 * x + 1

        # 将nums初始化为最大堆
        def buildMaxHead(heapSize: int):
            # 从最后一个非叶节点开始调整
            for i in range(heapSize // 2 - 1, -1, -1):
                heapify(i, heapSize)

        # 将下标为cur的元素调整到堆中正确的位置
        def heapify(cur: int, heapSize: int):
            temp = nums[cur]
            while leftChild(cur) < heapSize:
                childIndex = leftChild(cur)
                # 将childIndex置为较大的那个子节点
                if childIndex + 1 < heapSize and nums[childIndex + 1] > nums[childIndex]: childIndex += 1

                if temp < nums[childIndex]:
                    nums[cur] = nums[childIndex]
                else:
                    break
                cur = childIndex
            # 此时nums[cur]>nums[childIndex]
            nums[cur] = temp

        buildMaxHead(len(nums))
        # 将头部元素交换到尾部，交换k-1次后的头部元素为第k大值
        for i in range(1, k):
            nums[0], nums[-i] = nums[-i], nums[0]
            heapify(0, len(nums) - i)

        return nums[0]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().findKthLargest([3, 2, 1, 5, 6, 4], 2))
    pass
