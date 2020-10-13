from typing import *


# 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。 
# 
#  示例1: 
# 
#   输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
#  输出：true
#  
# 
#  示例2: 
# 
#   输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
# 1, 3], [2, 3], [3, 4]], start = 0, target = 4
#  输出 true
#  
# 
#  提示： 
# 
#  
#  节点数量n在[0, 1e5]范围内。 
#  节点编号大于等于 0 小于 n。 
#  图中可能存在自环和平行边。 
#  
#  Related Topics 图 
#  👍 16 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findWhetherExistsPath(self, n: int, graph: List[List[int]], start: int, target: int) -> bool:
        # 先转邻接表
        neighbors = [set() for _ in range(n)]
        for i, j in graph:
            neighbors[i].add(j)

        visited = [False] * n

        # 对start进行深搜，判断是否能到达target
        def dfs(node: int = start) -> bool:
            if node == target: return True  # 如果找到target，返回True
            if not neighbors[node]: return False  # 如果没有后继节点且不是target，返回false

            visited[node] = True  # 标记已访问

            for des in neighbors[node]:
                if not visited[des] and dfs(des):
                    return True  # 如果后继节点未访问（如果已访问说明构成环），则递归进行深搜
            # 如果本层节点的所有后继节点都无法到达target，标记未访问并返回false
            visited[node] = False
            return False

        return dfs()


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
