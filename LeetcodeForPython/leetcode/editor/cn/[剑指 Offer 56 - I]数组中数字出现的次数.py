from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def singleNumbers(self, nums: List[int]) -> List[int]:
        # 设2个只出现一次的数为a,b。对nums中所有元素进行异或运算，得到a^b的值
        res = 0
        for num in nums:
            res ^= num

        div = 1  # 找到res二进制数中为1的最低位（a和b在该位上的值不同，可以利用此特点进行分组）
        while not res & div:
            div <<= 1

        # nums中所有元素与div进行与运算分组
        a = b = 0
        for num in nums:
            if num & div:
                a ^= num
            else:
                b ^= num

        return [a, b]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
