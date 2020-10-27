from typing import *

# 给出一个区间的集合，请合并所有重叠的区间。
# 
#  
# 
#  示例 1: 
# 
#  输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
# 输出: [[1,6],[8,10],[15,18]]
# 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
#  
# 
#  示例 2: 
# 
#  输入: intervals = [[1,4],[4,5]]
# 输出: [[1,5]]
# 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
# 
#  注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
# 
#  
# 
#  提示： 
# 
#  
#  intervals[i][0] <= intervals[i][1] 
#  
#  Related Topics 排序 数组 
#  👍 667 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals: return []

        intervals.sort(key=lambda x: x[0])  # 按一维数组的第1个元素升序排列
        n = len(intervals)
        res = []

        for i in range(1, n):
            if intervals[i][0] > intervals[i - 1][1]:
                res.append(intervals[i - 1])  # 如果和上个区间不重叠，添加上个区间到res中
            # 如果有重叠，且右区间较大
            elif intervals[i][1] > intervals[i - 1][1]:
                intervals[i][0] = intervals[i - 1][0]  # 合并区间
            # 如果本区间覆盖范围比上个区间还小，则改写本区间
            else:
                intervals[i] = intervals[i - 1]

        res.append(intervals[n - 1])

        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
