from typing import *


# 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 表示一条从
# 点 fromi 到点 toi 的有向边。 
# 
#  找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。 
# 
#  你可以以任意顺序返回这些节点编号。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
# 输出：[0,3]
# 解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。从 3 出发我们可以到达 [3,4,2,5] 。所以我们输出 [0,3
# ] 。 
# 
#  示例 2： 
# 
#  
# 
#  输入：n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
# 输出：[0,2,3]
# 解释：注意到节点 0，3 和 2 无法从其他节点到达，所以我们必须将它们包含在结果点集中，这些点都能到达节点 1 和 4 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  2 <= n <= 10^5 
#  1 <= edges.length <= min(10^5, n * (n - 1) / 2) 
#  edges[i].length == 2 
#  0 <= fromi, toi < n 
#  所有点对 (fromi, toi) 互不相同。 
#  
#  Related Topics 图 
#  👍 9 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        # 寻找入度为0的节点。（因为所有入度不为0的
        ends = set(end for start, end in edges)  # 入度不为0的节点
        ans = [node for node in range(n) if node not in ends]  # 所有节点-入度不为0的节点=入度为0的节点
        return ans

        # 贪心算法
        # # 声明邻接表  graph[i]中的元素，表示节点i可以1步到达的节点
        # graph = [[] for _ in range(n)]
        # # 构建图
        # for i, j in edges:
        #     graph[i].append(j)
        #
        # self.cover = set()
        #
        # # 表示节点i可以直接、间接到达的所有节点
        # def dfs(node: int):
        #     for arrive in graph[node]:
        #         self.cover.add(arrive)
        #         dfs(arrive)
        #
        # uncover = {i for i in range(n)}
        # while uncover:
        #     maxKey=None
        #     for j in range(n):
        #         self.cover.add(j)
        #         dfs(j)  # 此时的cover里包括了所有j可以到达的节点
        #         realCover=self.cover & uncover
        #         if realCover and not maxKey or


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    pass
