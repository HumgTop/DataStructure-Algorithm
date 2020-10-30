from typing import *


# 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。 
# 
#  网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
# 
#  岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
# 的周长。 
# 
#  
# 
#  示例 : 
# 
#  输入:
# [[0,1,0,0],
#  [1,1,1,0],
#  [0,1,0,0],
#  [1,1,0,0]]
# 
# 输出: 16
# 
# 解释: 它的周长是下面图片中的 16 个黄色的边：
# 
# 
#  
#  Related Topics 哈希表 
#  👍 271 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        move = [[0, 1], [1, 0], [-1, 0], [0, -1]]  # 位移量

        # 返回一个网格各方向深搜后累加的周长和
        def dfs(r: int, c: int) -> int:
            # 如果从岛屿到越界
            if not (0 <= r < m) or not (0 <= c < n): return 1
            # 如果从岛屿到湖泊，周长加一
            if not grid[r][c]: return 1
            # 如果已经被访问，返回0
            if grid[r][c] == 2: return 0

            # 标记该网格已访问
            grid[r][c] = 2
            # 返回一个网格各方向深搜后累加的周长和
            return sum([dfs(r + i, c + j) for i, j in move])

        # 从第一个网格值为1处开始深搜
        for i in range(m):
            for j in range(n):
                if grid[i][j]: return dfs(i, j)


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().islandPerimeter([[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]))
    pass
