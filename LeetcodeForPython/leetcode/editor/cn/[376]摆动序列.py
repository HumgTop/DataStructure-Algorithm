from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2:
            return n

        flag = 0
        up = 1
        down = 2
        res = 1

        i = 1
        while i < n:
            if flag == 0:
                # 如果nums[i]==nums[i-1]，则不构成摆动序列
                if nums[i - 1] < nums[i]:
                    flag = up  # 当前元素为峰
                    res += 1
                elif nums[i - 1] > nums[i]:
                    flag = down  # 当前元素为谷
                    res += 1
            elif flag == up:  # 如果上个元素为峰
                if nums[i] < nums[i - 1]:
                    flag = down
                    res += 1
            elif flag == down:  # 如果上个元素为谷
                if nums[i] > nums[i - 1]:
                    flag = up
                    res += 1
            i += 1

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().wiggleMaxLength([1, 1]))
    pass
