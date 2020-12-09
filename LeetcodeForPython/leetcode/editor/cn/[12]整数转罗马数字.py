from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def intToRoman(self, num: int) -> str:
        roman = {1000: 'M', 500: 'D', 100: 'C', 50: 'L', 10: 'X', 5: 'V', 1: 'I'}
        special = {4: 'IV', 9: 'IX', 40: 'XL', 90: 'XC', 400: 'CD', 900: 'CM'}

        digits = len(str(num))

        res = []
        keys = list(roman.keys())
        for i in range(digits, 0, -1):
            cur = num - (num % (10 ** (i - 1)))  # 提取当前位的整数部分
            num -= cur

            if cur in special:
                res.append(special[cur])
                continue
            for j, key in enumerate(keys):
                if cur < key: continue
                cnt = cur // key
                for k in range(cnt):
                    res.append(roman[key])
                cur %= key
                if not cur: break

        return ''.join(res)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().intToRoman(3))
    pass
