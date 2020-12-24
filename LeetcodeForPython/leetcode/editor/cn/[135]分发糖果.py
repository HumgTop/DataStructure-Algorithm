from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        left = [1] * n  # 先给所有学生一颗糖
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]: left[i] = left[i - 1] + 1  # 先计算满足左规则的结果

        right = res = 0
        for i in range(n - 1, -1, -1):
            if i < n - 1 and ratings[i] > ratings[i + 1]:
                right += 1
            else:
                right = 1
            res += max(left[i], right)  # left和right中的较大值既满足左规则也满足右规则

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
