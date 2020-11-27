from typing import *
from math import floor


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 1 or x == 0: return x

        def binarySearch(lower: int = 0, upper: int = x):
            if upper - lower <= 1:
                res = floor(upper)
                return res if res ** 2 <= x else res - 1

            mid = (lower + upper) / 2
            if mid ** 2 == x:
                return int(mid)
            elif mid ** 2 > x:
                return binarySearch(lower, mid)
            else:
                return binarySearch(mid, upper)

        return binarySearch()
    # leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().mySqrt(61))
    pass
