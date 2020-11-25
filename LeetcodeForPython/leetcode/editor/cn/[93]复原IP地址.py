from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        n = len(s)
        res = []

        def recur(temp: List[str], begin: int = 0, step: int = 4, ):
            # 终止条件：4格的组合已全部完成
            if not step:
                res.append(''.join(temp))
                return

            end = n - step  # 保证后面的格子至少有1个数字
            # 将s[begin:i+1]添加到1格
            for i in range(begin, min(begin + 3, end + 1)):
                # 如果当前选择导致后面的格子的数字总数越界则跳过
                if n - 1 - i > (step - 1) * 3: continue

                cur = s[begin:i + 1]
                # 该选择不合法则跳过
                if begin != i and (cur[0] == "0" or int(cur) > 255): continue
                # 做出选择
                temp.append(cur)
                if step != 1: temp.append(".")

                recur(temp, i + 1, step - 1)
                # 撤销选择
                temp.pop()
                if step != 1:
                    temp.pop()

        recur([])
        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().restoreIpAddresses("010010"))
    pass
