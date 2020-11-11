from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        n = len(ring)
        m = len(key)
        pos = [[] for _ in range(26)]  # pos[i][j]表示字母i在ring中的索引

        for i in range(n):
            pos[ord(ring[i]) - ord('a')].append(i)

        dp = [[float('inf')] * n] * m  # dp[i][j]表示ring中第j个字符（等于key中第i个字符）走到12点的最小步数

        # 遍历key中首字符在ring中出现的下标
        for i in pos[ord(key[0]) - ord('a')]:
            dp[0][i] = min(i, n - i) + 1

        for i in range(1, m):
            # 遍历key中每个字符在ring中出现的下标
            for j in pos[ord(key[i]) - ord('a')]:
                for k in pos[ord(key[i - 1]) - ord('a')]:
                    dp[i][j] = min(dp[i][j], dp[i - 1][k] + min(abs(j - k), n - abs(j - k)) + 1)

        return int(min(dp[m - 1]))

    # leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pos = [[] for _ in range(26)]
    a = [1.2, 2.3, 3.5]
    print(min(a))
    print(pos)
    pass
