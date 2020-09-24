import itertools
import time


# 第k大斜率

class Solution:
    # 回溯算法求组合问题
    def maxK(self, points, i) -> int:
        res = []
        n = len(points)
        status = [0] * n

        def traceback(rest=2, start=0):
            if rest == 0:
                # 2个元素已经取完，添加到组合中
                combination = []
                for j in range(n):
                    if status[j] == 1: combination.append(points[j])

                if combination[0][0] - combination[1][0] != 0:
                    res.append((combination[0][1] - combination[1][1]) / (combination[0][0] - combination[1][0]))
                return

            for p in range(start, n):
                status[p] = 1  # 选择该点
                # 向下递推
                traceback(rest - 1, p + 1)
                # 恢复状态
                status[p] = 0

        traceback()
        res.sort(reverse=True)
        print(res)
        return int(res[i])

    # 调用itertools模块求解组合问题
    # def maxK(self, points, i) -> int:
    #     res = []
    #     # 对points随机取2个元素组合
    #     for point1, point2 in itertools.combinations(points, 2):
    #         print(point1, point2)
    #         if point1[0] - point2[1] == 0: continue
    #         res.append((point1[1] - point2[1]) / (point1[0] - point2[0]))
    #     res.sort(reverse=True)
    #     return int(res[i - 1])


if __name__ == '__main__':
    points = [[-1, -1], [2, 1], [3, 3], [1, 4]]
    print(Solution().maxK(points, 1))
