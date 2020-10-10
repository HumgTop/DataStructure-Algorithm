from typing import *


# 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序） 
# 
#  二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没
# 有下一个结点了。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  输入：graph = [[1,2],[3],[3],[]]
# 输出：[[0,1,3],[0,2,3]]
# 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
#  
# 
#  示例 2： 
# 
#  
# 
#  输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
# 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
#  
# 
#  示例 3： 
# 
#  输入：graph = [[1],[]]
# 输出：[[0,1]]
#  
# 
#  示例 4： 
# 
#  输入：graph = [[1,2,3],[2],[3],[]]
# 输出：[[0,1,2,3],[0,2,3],[0,3]]
#  
# 
#  示例 5： 
# 
#  输入：graph = [[1,3],[2],[3],[]]
# 输出：[[0,1,2,3],[0,3]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  结点的数量会在范围 [2, 15] 内。 
#  你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。 
#  
#  Related Topics 深度优先搜索 图 回溯算法 
#  👍 74 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        self.res = []
        self.path = [0]

        # 深度优先搜索
        def dfs(node: List[int]):
            # 对邻接节点进行递归，判断当前节点的邻接节点是否有n-1，有的话直接返回
            for neighbor in node:
                # 递归头
                # 如果是终点
                if neighbor == len(graph) - 1:
                    self.path.append(neighbor)
                    # 添加的是path的副本，这样对原path操作，不会影响res
                    self.res.append(self.path.copy())
                    self.path.pop()

                # 如果没有邻接节点
                elif not graph[neighbor]:
                    continue  # 跳过这个节点，处理下个邻接节点
                else:
                    self.path.append(neighbor)  # 做出选择，假定通过该点可以到达终点
                    dfs(graph[neighbor])
                    self.path.pop()  # 撤销选择

        dfs(graph[0])
        return self.res


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().allPathsSourceTarget([[4, 3, 1], [3, 2, 4], [], [4], []]))
    pass
