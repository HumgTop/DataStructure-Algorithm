from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a = int(a, 2)
        b = int(b, 2)
        return bin(a + b)[2:]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
