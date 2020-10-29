from typing import *


# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
# 
#  有效字符串需满足： 
# 
#  
#  左括号必须用相同类型的右括号闭合。 
#  左括号必须以正确的顺序闭合。 
#  
# 
#  注意空字符串可被认为是有效字符串。 
# 
#  示例 1: 
# 
#  输入: "()"
# 输出: true
#  
# 
#  示例 2: 
# 
#  输入: "()[]{}"
# 输出: true
#  
# 
#  示例 3: 
# 
#  输入: "(]"
# 输出: false
#  
# 
#  示例 4: 
# 
#  输入: "([)]"
# 输出: false
#  
# 
#  示例 5: 
# 
#  输入: "{[]}"
# 输出: true 
#  Related Topics 栈 字符串 
#  👍 1934 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) & 1: return False  # 如果长度为奇数，直接返回false

        a = '('
        b = '{'
        c = '['

        Map = {')': a, '}': b, ']': c}

        stack = []
        for ch in s:
            if ch == a or ch == b or ch == c:
                stack.append(ch)
            # 如果是右括号，且栈中有元素
            elif stack:
                temp = stack.pop()
                # 如果出栈元素不是相匹配的左括号，返回False
                if temp != Map[ch]: return False
            else:
                return False

        # 栈为空说明所有括号匹配成功
        return not stack


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
