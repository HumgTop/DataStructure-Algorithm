from typing import *

import math


class Solution:
    def find(self, arr: List[int]) -> List[int]:
        res = []
        for i in arr:
            if self.isPrime(i): res.append(i)

        return res

    def isPrime(self, num: int) -> bool:
        if num < 2: return False
        for i in range(2, int(math.sqrt(num)) + 1):
            if num % i == 0: return False

        return True


if __name__ == '__main__':
    print(Solution().find([1, 2, 3, 5, 11, 12]))
    pass
