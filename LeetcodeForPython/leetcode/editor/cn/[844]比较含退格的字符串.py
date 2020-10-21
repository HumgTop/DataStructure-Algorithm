from typing import *

# 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
# 
#  注意：如果对空文本输入退格字符，文本继续为空。 
# 
#  
# 
#  示例 1： 
# 
#  输入：S = "ab#c", T = "ad#c"
# 输出：true
# 解释：S 和 T 都会变成 “ac”。
#  
# 
#  示例 2： 
# 
#  输入：S = "ab##", T = "c#d#"
# 输出：true
# 解释：S 和 T 都会变成 “”。
#  
# 
#  示例 3： 
# 
#  输入：S = "a##c", T = "#a#c"
# 输出：true
# 解释：S 和 T 都会变成 “c”。
#  
# 
#  示例 4： 
# 
#  输入：S = "a#c", T = "b"
# 输出：false
# 解释：S 会变成 “c”，但 T 仍然是 “b”。 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= S.length <= 200 
#  1 <= T.length <= 200 
#  S 和 T 只含有小写字母以及字符 '#'。 
#  
# 
#  
# 
#  进阶： 
# 
#  
#  你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
#  
# 
#  
#  Related Topics 栈 双指针 
#  👍 154 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import itertools


class Solution:
    # delete = '#'

    def backspaceCompare(self, S: str, T: str) -> bool:
        sPtr = len(S) - 1
        tPtr = len(T) - 1

        skipS = 0
        skipT = 0
        delete = '#'

        while sPtr >= 0 or tPtr >= 0:
            while sPtr >= 0:
                if S[sPtr] == delete:
                    skipS += 1
                    sPtr -= 1
                elif skipS > 0:
                    skipS -= 1
                    sPtr -= 1
                else:
                    break

            while tPtr >= 0:
                if T[tPtr] == delete:
                    skipT += 1
                    tPtr -= 1
                elif skipT > 0:
                    skipT -= 1
                    tPtr -= 1
                else:  # 当前字符不为'#'，且skipT==0时
                    break
            if sPtr >= 0 and tPtr >= 0:
                # 如果字符不匹配
                if S[sPtr] != T[tPtr]: return False
            # 如果有一个指针已经越界(<0)
            elif sPtr >= 0 or tPtr >= 0:
                return False
            sPtr -= 1
            tPtr -= 1

        return True

    # # 定义一个生成器函数来来处理字符串
    # def fun(string):
    #     skip = 0
    #     # 相当于从右往左遍历字符
    #     for ch in reversed(string):
    #         # 如果遍历到 # skip++
    #         if ch == self.delete:
    #             skip += 1
    #         # 如果skip不为0，说明当前字符被删除（跳过此字符）且skip--
    #         elif skip:
    #             skip -= 1
    #         else:  # skip==0时，该字符保留
    #             yield ch
    #
    # # 此处应用最长的迭代器来作为返回值的长度
    # for ch1, ch2 in itertools.zip_longest(fun(S), fun(T)):
    #     if ch1 != ch2: return False
    #
    # return True


# class Solution:
#     delete = '#'
#
#     def backspaceCompare(self, S: str, T: str) -> bool:
#         stack1 = []
#         stack2 = []
#         for ch in S:
#             if ch == self.delete:
#                 if len(stack1) == 0:
#                     continue
#                 stack1.pop()
#             else:
#                 stack1.append(ch)
#
#         for ch in T:
#             if ch == self.delete:
#                 if len(stack2) == 0:
#                     continue
#                 stack2.pop()
#             else:
#                 stack2.append(ch)
#
#         return stack1 == stack2


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    print(Solution().backspaceCompare("bbbextm", "bbb#extm"))
    pass
