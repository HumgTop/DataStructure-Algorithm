from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        hashmap = {5: 0, 10: 0}
        for bill in bills:
            if bill == 5:
                hashmap[5] += 1
            elif bill == 10:
                if not hashmap[5]: return False
                hashmap[5] -= 1
                hashmap[10] += 1
            else:
                if hashmap[5] >= 3 and not hashmap[10]:
                    hashmap[5] -= 3
                elif hashmap[5] and hashmap[10]:
                    hashmap[5] -= 1
                    hashmap[10] -= 1
                else:
                    return False
        return True


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().lemonadeChange([5,5,5,20,5,5,5,20,5,5,5,10,5,20,10,20,10,20,5,5]))
    pass
