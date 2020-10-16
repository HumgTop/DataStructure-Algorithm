from typing import *

# 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
# 
#  
# 
#  示例 1： 
# 
#  输入：[-4,-1,0,3,10]
# 输出：[0,1,9,16,100]
#  
# 
#  示例 2： 
# 
#  输入：[-7,-3,2,3,11]
# 输出：[4,9,9,49,121]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= A.length <= 10000 
#  -10000 <= A[i] <= 10000 
#  A 已按非递减顺序排序。 
#  
#  Related Topics 数组 双指针 
#  👍 142 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        if A[0] >= 0: return [x ** 2 for x in A]
        n = len(A)
        ptr = 0
        for i in range(n):
            if A[i] >= 0:
                ptr = i  # 记录第一个非负数索引
                break

        res = []
        lPtr, rPtr = ptr - 1, ptr
        while lPtr >= 0 and rPtr <= n - 1:
            if A[lPtr] + A[rPtr] >= 0:  # 说明rPtr的绝对值较大
                res.append(A[lPtr] ** 2)
                lPtr -= 1
            else:
                res.append(A[rPtr] ** 2)
                rPtr += 1

        while lPtr >= 0:
            res.append(A[lPtr] ** 2)
            lPtr -= 1
        while rPtr <= n - 1:
            res.append(A[rPtr] ** 2)
            rPtr += 1

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().sortedSquares([-4, -1, 0, 3, 10]))
    pass
