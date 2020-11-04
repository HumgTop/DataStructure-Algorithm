from typing import *

# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for ch in s:
            # 在遇到']'之前将所有字符入栈
            if ch != ']':
                stack.append(ch)
            else:
                # 遇到']'后，将栈中的重复次数和子串出栈后重新组装再入栈
                temp = collections.deque()
                while stack and stack[-1] != '[':
                    temp.appendleft(stack.pop())
                temp = ''.join(temp)  # []中的字符串
                stack.pop()  # 弹出'['

                repeatCnt = collections.deque()
                while stack and stack[-1].isdigit():
                    repeatCnt.appendleft(stack.pop())  # 弹出重复次数

                repeatCnt = ''.join(repeatCnt)

                stack.append(int(repeatCnt) * temp)  # 将temp重复repeat次后入栈
                continue
        return ''.join(stack)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().decodeString("3[a2[c]]"))
    pass
