from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sortArrayByParityII(self, A: List[int]) -> List[int]:
        oddID = 1

        for evenID in range(0, len(A), 2):
            if A[evenID] & 1:
                while A[oddID] & 1:
                    oddID += 2
                # 当A[oddID]为偶数时
                A[evenID], A[oddID] = A[oddID], A[evenID]
                oddID += 2
        return A


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
