from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)
        # 按区间的start值升序排列
        intervals.sort(key=lambda x: x[0])
        res = []

        for interval in intervals:
            # 如果没有交集，将interval添加到res中
            if not res or interval[0] > res[-1][1]:
                res.append(interval)
            # 如果有交集，修改res中的尾部元素
            res[-1][1] = max(res[-1][1], interval[1])

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
