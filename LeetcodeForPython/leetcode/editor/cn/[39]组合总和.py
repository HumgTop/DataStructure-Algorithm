from typing import *


# 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
# 
#  candidates 中的数字可以无限制重复被选取。 
# 
#  说明： 
# 
#  
#  所有数字（包括 target）都是正整数。 
#  解集不能包含重复的组合。 
#  
# 
#  示例 1： 
# 
#  输入：candidates = [2,3,6,7], target = 7,
# 所求解集为：
# [
#   [7],
#   [2,2,3]
# ]
#  
# 
#  示例 2： 
# 
#  输入：candidates = [2,3,5], target = 8,
# 所求解集为：
# [
#   [2,2,2,2],
#   [2,3,3],
#   [3,5]
# ] 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= candidates.length <= 30 
#  1 <= candidates[i] <= 200 
#  candidate 中的每个元素都是独一无二的。 
#  1 <= target <= 500 
#  
#  Related Topics 数组 回溯算法 
#  👍 998 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        n = len(candidates)

        # 回溯算法
        def recur(selected: List[int], start: int = 0, total: int = 0):
            """
            :param start: 加入start从排列剪枝到组合（去重）
            :param total:
            :param selected: selected[i]表示元素candidates[i]被选了selected[i]次
            """
            if total == target:
                temp = []
                for i in range(n):
                    if selected[i]: temp.extend([candidates[i]] * selected[i])
                res.append(temp)
                return

            # !!从每一层的第2个元素开始，往下不能再使用同层已经使用过的元素
            for i in range(start, n):
                # 对于>target的部分剪枝
                if total + candidates[i] <= target:
                    selected[i] += 1
                    recur(selected, i, total + candidates[i])
                    selected[i] -= 1
                else:
                    break

        recur([0] * n)
        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().combinationSum([2, 3, 6, 7], 7))
    pass
