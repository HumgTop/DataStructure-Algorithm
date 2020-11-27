from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(n: int):
            # 终止条件
            if n == 0: return 1

            if n & 1:   # 如果n为奇数
                temp = helper((n - 1) // 2)
                return temp * temp * x
            else:
                temp = helper(n // 2)
                return temp * temp

        return helper(n) if n > 0 else 1 / helper(-n)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().myPow(2.0, -1))
    pass
