from typing import *
import heapq


# 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
# 
#  如果不能形成任何面积不为零的三角形，返回 0。 
# 
#  
# 
#  
#  
# 
#  示例 1： 
# 
#  输入：[2,1,2]
# 输出：5
#  
# 
#  示例 2： 
# 
#  输入：[1,2,1]
# 输出：0
#  
# 
#  示例 3： 
# 
#  输入：[3,2,3,4]
# 输出：10
#  
# 
#  示例 4： 
# 
#  输入：[3,6,2,3]
# 输出：8
#  
# 
#  
# 
#  提示： 
# 
#  
#  3 <= A.length <= 10000 
#  1 <= A[i] <= 10^6 
#  
#  Related Topics 排序 数学 
#  👍 81 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestPerimeter(self, A: List[int]) -> int:
        """
        思路：找出符合三角形组成规则的三角形最大周长
        :param A: a_i表示第i个元素的长度
        """
        A.sort()
        n = len(A)
        c = A[n - 1]
        b = A[n - 2]
        a = A[n - 3]

        for i in range(n - 4, -1, -1):
            if a + b > c: return a + b + c
            a, b, c = A[i], a, b  # a,b,c从右向左移动

        return a + b + c if a + b > c else 0


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    a = [3, 4, 5, 2, 1]
    heapq.heapify(a)
    print(heapq.nlargest(2, a))
    print(a)

    pass
