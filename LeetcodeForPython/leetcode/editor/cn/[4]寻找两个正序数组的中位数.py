from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)

        # 要在2个数组中找到第k小的数res，排除k-1个比res小的数后，就可以找到res
        def getKthVal(k):
            p1, p2 = 0, 0
            while True:
                # 如果p1越界，p2后移k-1，找到res
                if p1 == m: return nums2[p2 + k - 1]
                if p2 == n: return nums1[p1 + k - 1]
                if k == 1: return min(nums1[p1], nums2[p2])

                newP1 = min(p1 + k // 2 - 1, m - 1)
                newP2 = min(p2 + k // 2 - 1, n - 1)
                pivot1, pivot2 = nums1[newP1], nums2[newP2]

                if pivot1 <= pivot2:  # 排除元素nums1[p1...newP1]
                    # 更新k（减去已排除的元素数）
                    k -= newP1 - p1 + 1
                    # 更新p1
                    p1 = newP1 + 1
                else:
                    k -= newP2 - p2 + 1
                    p2 = newP2 + 1

        totalLen = m + n
        if totalLen & 1:
            return getKthVal((totalLen + 1) // 2)
        else:
            return (getKthVal(totalLen // 2) + getKthVal(totalLen // 2 + 1)) / 2

            # leetcode submit region end(Prohibit modification and deletion)
