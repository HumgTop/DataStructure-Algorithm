from typing import *


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def movingCount(self, m: int, n: int, k: int) -> int:
        visited = [[0 for _ in range(n)] for _ in range(m)]  # 标记为1说明已访问
        moves = [[0, 1], [1, 0]]    # 只需要向右和向下搜索
        res = 0

        def dfs(r: int, c: int):
            # 终止条件：越界
            if not (0 <= r < m and 0 <= c < n): return
            # 如果已访问，返回上一层
            if visited[r][c]: return
            visited[r][c] = 1
            # 不合法，返回上层
            if not isLessThanK(r, c): return

            nonlocal res
            res += 1
            # 对该坐标的四个邻接点进行深搜
            for move in moves:
                dfs(r + move[0], c + move[1])

        def isLessThanK(r: int, c: int) -> bool:
            rk = r % 10
            if r > 9: rk += r // 10

            ck = c % 10
            if c > 9: ck += c // 10
            return True if rk + ck <= k else False

        dfs(0, 0)
        return res
    # leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().movingCount(3, 1, 0))
    pass
