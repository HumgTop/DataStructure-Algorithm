from typing import *


# 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
# 
#  
# 
#  示例 1： 
# 
#  输入： A = "ab", B = "ba"
# 输出： true
#  
# 
#  示例 2： 
# 
#  输入： A = "ab", B = "ab"
# 输出： false
#  
# 
#  示例 3: 
# 
#  输入： A = "aa", B = "aa"
# 输出： true
#  
# 
#  示例 4： 
# 
#  输入： A = "aaaaaaabc", B = "aaaaaaacb"
# 输出： true
#  
# 
#  示例 5： 
# 
#  输入： A = "", B = "aa"
# 输出： false
#  
# 
#  
# 
#  提示： 
# 
#  
#  0 <= A.length <= 20000 
#  0 <= B.length <= 20000 
#  A 和 B 仅由小写字母构成。 
#  
#  Related Topics 字符串 
#  👍 111 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        """
        首先A和B的构成字符要相同
        只有2个字符的顺序不同
        :param A:
        :param B:
        :return:
        """
        if len(A) != len(B): return False
        # 如果A和B相同，且A中有重复的元素，返回true
        if A == B and len(set(A)) < len(A): return True

        diffCount = 0  # 记录不同的位置数
        diff = []  # 记录不相同的元素
        for chA, chB in zip(A, B):
            # 元素不同的位置超过2个返回false
            if diffCount > 2: return False
            if chA != chB:
                diff.append(chA)
                diff.append(chB)
                diffCount += 1

        if diffCount == 2 and diff[0] == diff[3] and diff[1] == diff[2]:
            return True
        else:
            return False
        pass


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    a = 1
    b = 0
    if a > b and a / b == 2:
        print('hi')
    else:
        print('no')
    pass
