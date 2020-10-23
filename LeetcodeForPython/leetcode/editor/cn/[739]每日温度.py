from typing import *


# 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
#  
# 
#  例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
# , 1, 1, 0, 0]。 
# 
#  提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
#  Related Topics 栈 哈希表 
#  👍 545 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        res = [0] * len(T)
        # 单调栈（递减）：存储的是索引
        stack = []

        for i, t in enumerate(T):
            # 当栈不为空，且当前温度高于栈顶（维护栈的单调性）
            while stack and t > T[stack[-1]]:
                res[stack[-1]] = i - stack[-1]
                stack.pop()

            stack.append(i)

        return res

# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
