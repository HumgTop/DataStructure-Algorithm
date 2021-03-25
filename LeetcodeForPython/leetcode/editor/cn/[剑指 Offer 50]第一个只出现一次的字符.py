from typing import *
from collections import OrderedDict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def firstUniqChar(self, s: str) -> str:
        cnt = OrderedDict()
        for ch in s:
            cnt[ch] = cnt.get(ch, 0) + 1

        for ch in cnt:
            if cnt[ch] == 1: return ch

        return ' '
        pass


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(ord('a'))
    mp = OrderedDict()
    mp[3] = 3
    mp[2] = 2
    mp[5] = 5
    print(mp)
    pass
