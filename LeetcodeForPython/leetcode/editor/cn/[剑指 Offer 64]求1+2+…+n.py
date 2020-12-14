from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumNums(self, n: int) -> int:
        Sum = 0

        # 构造递归，使用短路特性决定是否继续递归
        def recur(num: int):
            flag = (num == n or recur(num + 1))  # 在num==n时，短路原则不再进行递归（终止条件）
            nonlocal Sum
            Sum += num

        recur(0)
        return Sum


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().sumNums(5))
    pass
