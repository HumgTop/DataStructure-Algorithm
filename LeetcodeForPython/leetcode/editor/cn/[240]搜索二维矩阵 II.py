from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix: return False
        m = len(matrix)
        n = len(matrix[0])
        rBegin = m - 1
        cBegin = 0

        def recur(r: int, c: int) -> bool:
            # 如果越界说明不存在此元素
            if r < 0 or c > n - 1: return False

            if target == matrix[r][c]:
                return True
            elif target > matrix[r][c]:
                if recur(r, c + 1): return True
            else:
                if recur(r - 1, c): return True

            return False

        # 以矩阵的左下角作为起点开始扫描
        return recur(rBegin, cBegin)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
