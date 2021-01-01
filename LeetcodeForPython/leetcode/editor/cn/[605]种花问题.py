from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        length = len(flowerbed)
        flowerbed.append(0)  # 加入哨兵避免特判

        i = 0
        while i < length:
            if n <= 0: return True
            if not flowerbed[i] and not flowerbed[i + 1]:
                n -= 1  # 该位置可以种花
                i += 2
                continue
            i += 2 if flowerbed[i] == 1 else 1

        return n <= 0


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().canPlaceFlowers([1, 0, 0, 0, 1, 0, 0], 2))
    pass
