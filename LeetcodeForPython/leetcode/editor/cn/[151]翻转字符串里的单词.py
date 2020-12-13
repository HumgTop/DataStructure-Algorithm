from typing import *

# leetcode submit region begin(Prohibit modification and deletion)
import re


class Solution:
    def reverseWords(self, s: str) -> str:
        words = re.findall(r'(\w+!?)', s)
        res = []
        for i in range(len(words) - 1, 0, -1):
            res.append(words[i] + ' ')

        res.append(words[0])
        return ''.join(res)
        pass


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
