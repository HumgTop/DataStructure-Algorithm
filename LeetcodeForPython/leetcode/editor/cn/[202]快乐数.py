from typing import *


# 编写一个算法来判断一个数 n 是不是快乐数。
# 
#  「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
# 如果 可以变为 1，那么这个数就是快乐数。 
# 
#  如果 n 是快乐数就返回 True ；不是，则返回 False 。 
# 
#  
# 
#  示例： 
# 
#  输入：19
# 输出：true
# 解释：
# 12 + 92 = 82
# 82 + 22 = 68
# 62 + 82 = 100
# 12 + 02 + 02 = 1
#  
#  Related Topics 哈希表 数学 
#  👍 447 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
def fun(n):
    return sum(int(num) ** 2 for num in str(n))


class Solution:
    def isHappy(self, n: int) -> bool:
        slow = n
        fast = fun(n)

        while fast != 1 and fast != slow:
            # 快慢指针：slow计算1次，fast计算2次。如果n的计算结果是循环，那么fast总会追上slow
            slow = fun(slow)
            fast = fun(fun(fast))

        # 此时fast==1或者fast==slow
        return fast == 1


# class Solution:
#     count = 0  # 类属性
#
#     def isHappy(self, n: int) -> bool:
#         if Solution.count > 10: return False
#         res = sum(int(num) ** 2 for num in str(n))
#         if res == 1: return True
#         Solution.count += 1
#         return self.isHappy(res)
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    print(fun(49))
    pass
