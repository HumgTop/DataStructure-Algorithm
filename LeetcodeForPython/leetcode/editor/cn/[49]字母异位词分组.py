from typing import *

# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = collections.defaultdict(list)
        for s in strs:
            count = [0] * 26  # 一个记录s的各字符出现次数的数组
            for ch in s:
                count[ord(ch) - ord('a')] += 1

            res[tuple(count)].append(s)

        return list(res.values())


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    a = [1, 2, 3, 4]
    b = [1, 2, 3, 4]
    print(a == b)
    pass
