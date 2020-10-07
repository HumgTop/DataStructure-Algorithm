from typing import *


# 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。 
# 
#  如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况
# 下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。 
# 
#  现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？ 
# 
#  
# 
#  示例： 
# 
#  输入: 10
# 输出: 4
# 解释: 
# 在[1, 10]中有四个好数： 2, 5, 6, 9。
# 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
#  
# 
#  
# 
#  提示： 
# 
#  
#  N 的取值范围是 [1, 10000]。 
#  
#  Related Topics 字符串 
#  👍 81 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rotatedDigits(self, N: int) -> int:
        # 官方解：暴力解
        res = 0
        mirror = {'2', '5', '6', '9'}
        invalid = {'3', '4', '7'}
        for num in range(1, N + 1):
            numStr = str(num)
            res += (all((x not in invalid for x in numStr))
                    and any((x in mirror for x in numStr)))

        return res

        # 自解：
        # mirror = {'2', '5', '6', '9'}
        # invalid = {'3', '4', '7'}
        # res = 0
        # for i in range(1, N + 1):
        #     iStr = str(i)
        #     mirrorFlag = False  # 默认没有出现镜像数
        #     for ch in iStr:
        #         # 出现旋转无效数字，结束循环
        #         if ch in invalid:
        #             break
        #         if ch in mirror: mirrorFlag = True
        #     else:
        #         if mirrorFlag: res += 1
        #
        # return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    print(1 + True)
    pass
