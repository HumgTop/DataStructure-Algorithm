from typing import *

# leetcode submit region begin(Prohibit modification and deletion)
from collections import deque as dq


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid: return 0

        m = len(grid)
        n = len(grid[0])
        move = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        queue = dq()

        cnt = 0  # 记录新鲜橘子的个数
        for r in range(m):
            for c in range(n):
                if grid[r][c] == 1:
                    cnt += 1
                if grid[r][c] == 2:
                    queue.append([r, c])  # 将腐烂橘子的坐标入列
                    grid[r][c] = 3  # 标记已访问

        # 如果开始时网格中已经没有新鲜橘子，返回0
        if not cnt: return 0

        res = 0
        while queue:
            size = len(queue)
            # 将本层所有节点弹出
            for i in range(size):
                curGrid = queue.popleft()
                for d in move:

                    nextR = curGrid[0] + d[0]
                    nextC = curGrid[1] + d[1]
                    # 如果下一个坐标不越界，未访问过
                    if 0 <= nextR < m and 0 <= nextC < n and grid[nextR][nextC] != 3:
                        # 如果该网格没有橘子
                        if grid[nextR][nextC] == 0:
                            grid[nextR][nextC] = 3
                            continue
                        # 该网格有橘子，则入列
                        if grid[nextR][nextC] == 1:
                            cnt -= 1  # 该橘子被感染，新鲜橘子数-1
                            queue.append([nextR, nextC])
                            grid[nextR][nextC] = 3
            res += 1

        return res - 1 if not cnt else -1


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]]))
    pass
