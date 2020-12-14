from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def translateNum(self, num: int) -> int:
        numStr = str(num)
        n = len(numStr)

        # 青蛙跳台阶，一次可以选取1个或2个字符，如果选取编号不合法则不计入结果
        pre2 = 1
        pre1 = 2 if numStr[0] != '0' and int(numStr[0:2]) < 26 else 1

        if n == 1: return 1
        if n == 2: return pre1
        cur = 0
        for i in range(2, n):
            cur = pre1
            # 从per2转移选取的编号可能非法
            select = numStr[i - 1:i + 1]
            if select[0] != '0' and int(select) < 26:
                cur += pre2

            # 状态转移
            pre2 = pre1
            pre1 = cur

        return cur


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
