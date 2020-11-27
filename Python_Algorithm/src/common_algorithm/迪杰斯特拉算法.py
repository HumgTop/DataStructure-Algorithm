if __name__ == '__main__':
    matrix = [
        [0, 12, 10e9, 10e9, 16, 14],
        [12, 0, 20, 10e9, 10e9, 7, 10e9],
        [10e9, 20, 0, 3, 5, 6, 10e9],
        [10e9, 10e9, 3, 0, 4, 10e9, 10e9],
        [10e9, 10e9, 5, 4, 0, 2, 8],
        [16, 7, 6, 10e9, 2, 0, 9],
        [14, 10e9, 10e9, 10e9, 8, 9, 0]
    ]

    minDistance = matrix[3]
    visited = [0] * 7  # visited[i]为1表示D到该点的最小路径已确定
    visited[3] = 1

    cnt = 1  # 记录已经确定最小路径的个数
    while cnt < 7:
        minTemp = 10e9
        minID = -1
        for i, isVisited in enumerate(visited):
            if not isVisited:
                # 找到未访问点中，与D距离最近的点（贪心思想）
                if minDistance[i] < minTemp:
                    minTemp = minDistance[i]
                    minID = i
        # 标记该点已访问（已确定最短路径）
        visited[minID] = 1
        cnt += 1
        # 以该点为中转，对minDistance中未确定最短路径的点进行优化
        for i, isVisited in enumerate(visited):
            if not isVisited:
                minDistance[i] = min(minDistance[i], minDistance[minID] + matrix[minID][i])

    print(minDistance)
