from typing import *

# 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函
# 数找到所有的最小高度树并返回他们的根节点。 
# 
#  格式 
# 
#  该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。 
# 
#  你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。 
# 
#  示例 1: 
# 
#  输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
# 
#         0
#         |
#         1
#        / \
#       2   3 
# 
# 输出: [1]
#  
# 
#  示例 2: 
# 
#  输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
# 
#      0  1  2
#       \ | /
#         3
#         |
#         4
#         |
#         5 
# 
# 输出: [3, 4] 
# 
#  说明: 
# 
#  
#  根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。 
#  树的高度是指根节点和叶子节点之间最长向下路径上边的数量。 
#  
#  Related Topics 广度优先搜索 图 
#  👍 218 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        # 拓扑排序
        # 邻接表
        if n == 1: return [0]

        neigh = [set() for _ in range(n)]
        degree = [0] * n  # 记录每个节点的度数
        for i, j in edges:
            neigh[i].add(j)
            neigh[j].add(i)
            degree[i] += 1
            degree[j] += 1

        # 初始化队列：将度为1的节点入列
        queue = collections.deque([x for x in range(n) if degree[x] == 1])
        res = []
        while queue:
            res.clear()
            for _ in range(len(queue)):
                cur = queue.popleft()
                res.append(cur)  # 记录度为1的节点
                for node in neigh[cur]:
                    degree[node] -= 1  # 与cur相邻的节点度-1
                    if degree[node] == 1: queue.append(node)

        return res  # 最后一层的节点为根节点时，即为最小高度树

        # 自解
        # 邻接表
        # neighbors = [set() for _ in range(n)]
        # for i, j in edges:
        #     neighbors[i].add(j)
        #     neighbors[j].add(i)
        #
        # heights = {}
        # # 依次对节点进行bfs，将高度记录到heights中
        #
        # queue = collections.deque()
        #
        # def bfs(node: int):
        #     visited = [False] * n
        #     queue.append(node)
        #     visited[node] = True
        #     level = 1
        #     while queue:
        #         # 遍历一层的节点，并添加下一层节点
        #         for _ in range(len(queue)):
        #             cur = queue.popleft()
        #             for neigh in neighbors[cur]:
        #                 if not visited[neigh]:
        #                     queue.append(neigh)  # 如果没有被访问过，将其添加到队列中
        #                     visited[neigh] = True
        #         level += 1
        #
        #     heights[node] = level
        #
        # for i in range(n):
        #     bfs(i)
        #
        # # 对heights按value排序
        # sortedHeights = sorted(heights.items(), key=lambda x: x[1])
        # res = []
        # for i, j in sortedHeights:
        #     if j == sortedHeights[0][1]:
        #         res.append(i)
        #     else:
        #         break
        # return res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    a = {1, 2, 3, 4}
    for i in a:
        print(i)
    pass
