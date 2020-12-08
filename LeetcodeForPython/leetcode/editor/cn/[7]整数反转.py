from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverse(self, x: int) -> int:
        maxVal = (1 << 31) - 1
        minVal = -(maxVal + 1)

        temp = []
        flag = False
        for ch in str(x):
            if ch == '-':
                flag = True
                continue
            temp.append(ch)

        temp.reverse()
        res = int("".join(temp))
        if flag: res = -res
        return res if minVal <= res <= maxVal else 0
        pass


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
