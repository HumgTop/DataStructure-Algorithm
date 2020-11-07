from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        preSum = [0] * (len(nums) + 1)  # 前缀和数组

        for i in range(1, len(preSum)):
            preSum[i] = preSum[i - 1] + nums[i - 1]

        # 返回preSum[left]到preSum[right]内，区间和合法的个数
        def helper(left: int, right: int) -> int:
            if left == right: return 0

            mid = (left + right) // 2
            n1 = helper(left, mid)
            n2 = helper(mid + 1, right)
            res = n1 + n2

            # 现在[left,mid][mid+1,right]都是升序数列，记录区间和
            i = left
            l = mid + 1
            r = mid + 1
            while i <= mid:
                # 找到preSum[l]-preSum[i]>=lower的下标
                while l <= right and preSum[l] < preSum[i] + lower: l += 1
                while r <= right and preSum[r] <= preSum[i] + upper: r += 1
                res += r - l  # 记录合法的区间
                i += 1

            # 对preSum的[left,mid]和[mid+1,right]区间合并成[left,right]的升序数列
            mergeArr = [0] * (right - left + 1)
            p1, p2 = left, mid + 1
            p = 0
            while p1 <= mid or p2 <= right:
                if p1 > mid:
                    mergeArr[p] = preSum[p2]
                    p += 1
                    p2 += 1
                elif p2 > right:
                    mergeArr[p] = preSum[p1]
                    p += 1
                    p1 += 1
                else:
                    if preSum[p1] < preSum[p2]:
                        mergeArr[p] = preSum[p1]
                        p += 1
                        p1 += 1
                    else:
                        mergeArr[p] = preSum[p2]
                        p += 1
                        p2 += 1

            # 将preSum的[left,right]区间修改为mergerArr
            for i in range(len(mergeArr)):
                preSum[left + i] = mergeArr[i]

            return res

        return helper(0, len(preSum) - 1)
        # leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().countRangeSum([2147483647, -2147483648, -1, 0], -1, 0))
    pass
