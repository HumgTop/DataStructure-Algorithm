from typing import *

# 在有向图中, 我们从某个节点和每个转向处开始, 沿着图的有向边走。 如果我们到达的节点是终点 (即它没有连出的有向边), 我们停止。
# 
#  现在, 如果我们最后能走到终点，那么我们的起始节点是最终安全的。 更具体地说, 存在一个自然数 K, 无论选择从哪里开始行走, 我们走了不到 K 步后必能
# 停止在一个终点。 
# 
#  哪些节点最终是安全的？ 结果返回一个有序的数组。 
# 
#  该有向图有 N 个节点，标签为 0, 1, ..., N-1, 其中 N 是 graph 的节点数. 图以以下的形式给出: graph[i] 是节点 j 
# 的一个列表，满足 (i, j) 是图的一条有向边。 
# 
#  
# 示例：
# 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
# 输出：[2,4,5,6]
# 这里是上图的示意图。
# 
#  
# 
#  
# 
#  提示： 
# 
#  
#  graph 节点数不超过 10000. 
#  图的边数不会超过 32000. 
#  每个 graph[i] 被排序为不同的整数列表， 在区间 [0, graph.length - 1] 中选取。 
#  
#  Related Topics 深度优先搜索 图 
#  👍 80 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        # 官方解：深度优先搜索
        """
        白色表示该节点还没有被访问过；
        灰色表示该节点已经被访问过且在环中；
        黑色表示该节点后继节点都被访问过，且该节点不在环中。
        """
        white, gray, black = 0, 1, 2
        color = collections.defaultdict(int)  # 当字典中不存在键时，返回默认值0

        def dfs(node: int) -> bool:
            if color[node] != white:
                # 如果该节点为灰色，表示该节点已经被访问过且在环中，返回false。
                return color[node] == black

            color[node] = gray  # 先假定其在环中

            for nei in graph[node]:
                if color[nei] == black: continue  # 如果nei是安全的跳过本次循环
                # 如果经过dfs判断nei是不安全的，则node也不安全，返回false
                if not dfs(nei): return False

            # 如果的node的后继节点都是安全的，则node也是安全的，给node染色
            color[node] = black  # 染成黑色，表示不在环中，是安全的
            return True

        return [i for i in range(len(graph)) if dfs(i)]

        # n = len(graph)
        # # graph[i][j]表示节点i的一条有向边
        # visited = [False] * n  # 定义节点是否被访问过
        #
        # # 对节点node进行深搜，如果node的终点全是出度为0的点，则其是安全的
        # def dfs(node: int) -> bool:
        #     # 如果曾经被访问过，说明node会成环，不是安全的
        #     if visited[node]: return False
        #
        #     # 如果graph[node]为空，说明此节点安全
        #     if not graph[node]: return True
        #
        #     visited[node] = True
        #     for dest in graph[node]:
        #         # 任何一条子路径构成环路则返回false
        #         if not dfs(dest):
        #             # 撤销访问
        #             visited[node] = False
        #             return False
        #
        #     visited[node] = False
        #     return True
        #
        # return [i for i in range(n) if dfs(i)]


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    graph = [[1, 2], [2, 3], [5], [0], [5], [], []]
    n = len(graph)
    # graph[i][j]表示节点i的一条有向边
    visited = [False] * n  # 定义节点是否被访问过


    # 对节点node进行深搜，如果node的终点全是出度为0的点，则其是安全的
    def dfs(node: int) -> bool:
        # 如果曾经被访问过，说明node会成环，不是安全的
        if visited[node]: return False

        # 如果graph[node]为空，说明此节点安全
        if not graph[node]: return True

        visited[node] = True
        for dest in graph[node]:
            # 任何一条子路径构成环路则返回false
            if not dfs(dest):
                # 撤销访问
                visited[node] = False
                return False

        visited[node] = False
        return True


    for i in range(n):
        flag = dfs(i)
        if flag:
            print(i)
    pass
