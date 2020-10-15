from typing import *


# 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
# 
#  candidates 中的每个数字在每个组合中只能使用一次。 
# 
#  说明： 
# 
#  
#  所有数字（包括目标数）都是正整数。 
#  解集不能包含重复的组合。 
#  
# 
#  示例 1: 
# 
#  输入: candidates = [10,1,2,7,6,1,5], target = 8,
# 所求解集为:
# [
#   [1, 7],
#   [1, 2, 5],
#   [2, 6],
#   [1, 1, 6]
# ]
#  
# 
#  示例 2: 
# 
#  输入: candidates = [2,5,2,1,2], target = 5,
# 所求解集为:
# [
#   [1,2,2],
#   [5]
# ] 
#  Related Topics 数组 回溯算法 
#  👍 423 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        n = len(candidates)
        visited = [0] * n
        res = []

        def recur(visited: List[int], total: int = 0, start: int = 0):
            if total == target:
                # 将选择的元素添加到res中
                res.append([candidates[x] for x in range(n) if visited[x]])

            for i in range(start, n):
                # ！！剪枝：在同一层不应选择重复的元素
                if i > start and candidates[i] == candidates[i - 1]: continue
                # 剪枝
                if total + candidates[i] <= target:
                    visited[i] = 1
                    recur(visited, total + candidates[i], i + 1)
                    visited[i] = 0
                else:
                    break

        recur(visited)
        return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
    pass
