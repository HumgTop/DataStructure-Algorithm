from typing import *


# 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
# 判断数组中是否含有该整数。 
# 
#  
# 
#  示例: 
# 
#  现有矩阵 matrix 如下： 
# 
#  [
#   [1,   4,  7, 11, 15],
#   [2,   5,  8, 12, 19],
#   [3,   6,  9, 16, 22],
#   [10, 13, 14, 17, 24],
#   [18, 21, 23, 26, 30]
# ]
#  
# 
#  给定 target = 5，返回 true。 
# 
#  给定 target = 20，返回 false。 
# 
#  
# 
#  限制： 
# 
#  0 <= n <= 1000 
# 
#  0 <= m <= 1000 
# 
#  
# 
#  注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
#  Related Topics 数组 双指针 
#  👍 153 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix: return False
        if not matrix[0]: return False

        n = len(matrix)
        m = len(matrix[0])
        # 从左下角元素，如果target>cur，则y++；否则则x--
        x = n - 1
        y = 0
        while x >= 0 and y <= m - 1:
            cur = matrix[x][y]
            if target > cur:
                y += 1
            elif target < cur:
                x -= 1
            else:
                return True

        return False


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    print(Solution().findNumberIn2DArray([[1, 1]], 2))
    pass
