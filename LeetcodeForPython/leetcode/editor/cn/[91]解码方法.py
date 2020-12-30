from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == '0': return 0

        n = len(s)
        if n == 1: return 1

        pre2 = 1

        pre1 = 0
        if s[1] != '0':
            pre1 = 2 if int(s[: 2]) <= 26 else 1
        else:
            pre1 = 1 if int(s[: 2]) <= 26 else 0

        res = pre1
        for i in range(2, n):
            if int(s[i - 1:i + 1]) > 26 or int(s[i - 1:i + 1]) < 10: pre2 = 0  # 如果从dp[i-2]转移不合法，则dp[i-2]=0
            if s[i] == '0': pre1 = 0
            res = pre1 + pre2
            pre2 = pre1
            pre1 = res

        return res
        # leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
