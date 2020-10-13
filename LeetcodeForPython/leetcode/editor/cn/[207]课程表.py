from typing import *

# 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
# 
#  在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 
# 
#  给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？ 
# 
#  
# 
#  示例 1: 
# 
#  输入: 2, [[1,0]] 
# 输出: true
# 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
# 
#  示例 2: 
# 
#  输入: 2, [[1,0],[0,1]]
# 输出: false
# 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
# 
#  
# 
#  提示： 
# 
#  
#  输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 
#  你可以假定输入的先决条件中没有重复的边。 
#  1 <= numCourses <= 10^5 
#  
#  Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
#  👍 600 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # 拓扑排序 | bfs
        # 入度表
        indeg = [0] * numCourses
        # 邻接表：存放后继节点
        des = collections.defaultdict(list)

        # 构建邻接表和入度表
        for i, j in prerequisites:
            des[j].append(i)
            indeg[i] += 1

        visited = 0

        # 初始化队列：遍历入度为0的节点，将其存入队列中
        queue = collections.deque([x for x in range(numCourses) if indeg[x] == 0])
        while queue:
            visited += 1
            cur = queue.popleft()  # 因为不需要记录层数，所以不需要 for _ in range(len(queue))
            # 将cur所有的后继节点入度-1
            for desNode in des[cur]:
                indeg[desNode] -= 1
                # 将入度为0的节点继续加入队列
                if indeg[desNode] == 0: queue.append(desNode)

        return visited == numCourses

        # 拓扑排序 | dfs
        # white, gray, black = 0, 1, 2  # 分别表示未访问，访问中（搜索中，如果搜索结束还是灰色说明该节点在环中），表示不在环中
        # color = collections.defaultdict(int)  # 返回默认值0，表示该节点未访问
        # # 邻接表
        # des = [set() for _ in range(numCourses)]
        # for i, j in prerequisites:
        #     des[j].add(i)  # j的后继节点为i
        #
        # # 判断是不是一个有向无环图
        # # 返回值表示该节点是否在环中
        # def dfs(node: int) -> bool:
        #     if color[node] == gray: return False
        #     if color[node] == black: return True
        #
        #     color[node] = gray
        #     for desNode in des[node]:
        #         if color[desNode] == gray or not dfs(desNode): return False
        #
        #     # 如果后继节点都不在环中，则node也不在环中，将node染成黑色
        #     color[node] = black
        #     return True
        #
        # for i in range(numCourses):
        #     # 如果该节点没有被访问过，且该节点不在环中
        #     if color[i] == white and not dfs(i): return False
        #
        # return True

        # dfs
        # # 邻接表
        # des = [set() for _ in range(numCourses)]
        # for i, j in prerequisites:
        #     des[j].add(i)  # j的后继节点为i
        #
        # visited = [False] * numCourses
        #
        # # 对每个节点进行深搜，如果构成环，返回false
        # def dfs(node: int) -> bool:
        #     if visited[node]: return False
        #     visited[node] = True
        #
        #     for desNode in des[node]:
        #         # 如果后继节点已经被访问过，或者子节点构成环，返回False
        #         if visited[desNode] or not dfs(desNode): return False
        #
        #     visited[node] = False
        #     return True
        #
        # for i in range(numCourses):
        #     if not dfs(i): return False
        #
        # return True


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().canFinish(2, [[1, 0]]))
    pass
