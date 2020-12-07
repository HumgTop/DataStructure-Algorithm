from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if not numRows: return []
        if numRows == 1: return [[1]]
        if numRows == 2: return [[1], [1, 1]]
        res = [[1], [1, 1]]
        row = [1, 1]
        for i in range(3, numRows + 1):
            temp = [1]
            for j in range(1, i - 1):
                temp.append(row[j - 1] + row[j])
            temp.append(1)
            res.append(temp)
            row = temp

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().generate(5))
    pass
