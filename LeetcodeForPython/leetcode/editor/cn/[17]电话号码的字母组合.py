from typing import *


# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
# 
#  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
# 
#  
# 
#  示例: 
# 
#  输入："23"
# 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
#  
# 
#  说明: 
# 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
#  Related Topics 字符串 回溯算法 
#  👍 970 👎 0


# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        Map = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
               '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}

        res = []
        n = len(digits)

        def recur(index: int, temp: List[str]):
            """
            回溯算法
            :param index: 遍历digits的指针
            :param temp:  存放此时的组合结果
            :return:
            """
            # 终止递归
            if index == n:
                res.append(''.join(temp))  # 将temp转为字符串添加到res中
                return

            for ch in Map[digits[index]]:
                temp.append(ch)  # 做出选择
                recur(index + 1, temp)
                temp.pop()  # 撤销选择

        if not digits: return []
        recur(0, [])
        return res
    # leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
