from typing import *


# 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
# 
#  
# 
#  示例： 
# 
#  输入：n = 3
# 输出：[
#        "((()))",
#        "(()())",
#        "(())()",
#        "()(())",
#        "()()()"
#      ]
#  
#  Related Topics 字符串 回溯算法 
#  👍 1371 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # 回溯算法
        left = '('
        right = ')'
        res = []

        def recur(restL, restR, lSubR: int = 1, s: str = left):
            """

            :param restL: 剩余的左括号数
            :param restR: 剩余的右括号数
            :param lSubR: 当前组合中，左括号数-右括号数的值
            :param s: 当前的括号组合
            :return: 合法的括号组合，添加到res中
            """
            if lSubR == 0 and restR == 0 and restL == 0:
                res.append(s)
                return

            if restL > 0:
                # 如果还有左括号添加左括号
                recur(restL - 1, restR, lSubR + 1, s + left)
                # 因为str是基本类型，所以传递的是s的一份拷贝，不需要撤销选择

            # ！！对于lSubR-1<0的进行剪枝：违背了配对规则
            if restR > 0 and lSubR - 1 >= 0:
                recur(restL, restR - 1, lSubR - 1, s + right)

        recur(n - 1, n)
        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    s = '1'
    print(s)
    pass
