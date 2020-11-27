if __name__ == '__main__':
    matrix = [[0, 7, 10e9, 10e9, 1, 6],
              [7, 0, 2, 4, 10e9, 10e9],
              [10e9, 2, 0, 9, 3, 10e9],
              [10e9, 4, 9, 0, 10e9, 10e9],
              [1, 10e9, 3, 10e9, 0, 3],
              [6, 10e9, 10e9, 10e9, 3, 0]]


    def floyd(matrix):
        n = len(matrix[0])
        # 遍历中间点
        for i in range(n):
            # 遍历出发点
            for j in range(n):
                # 遍历终点
                for k in range(n):
                    if k == j or k == i or j == i: continue
                    # 取直达和走中间点中，路径较短的那个
                    matrix[j][k] = min(matrix[j][k], matrix[j][i] + matrix[i][k])


    floyd(matrix)
    for arr in matrix:
        print(arr)
