from typing import *


class Queen:
    def __init__(self):
        self.queen_num = 8  # 皇后的数量有8个
        self.chess_board = [0] * self.queen_num  # 用一维列表定义棋盘，第i个皇后在第i行，chess_board[i]列
        self.count = 0  # 解法计数器

    def s_print(self):
        """
        每找出一种解法就打印
        """
        self.count += 1
        print('第%d种解法' % self.count, end='')
        for i in range(self.queen_num):
            print('第%d行第%d列\t' % (i + 1, self.chess_board[i]), end='')
        print()
        print('----------------')

    def judge(self, n: int) -> bool:
        """
        判断第n个皇后与之前n-1个皇后是否有规则冲突
        注：第n个皇后与之前所有皇后肯定不在同一行，只需要判断是否在同一列和同一斜线
        :param n:
        """
        for i in range(n):
            # 如果两皇后所在行数的差等于所在列数的差（绝对值），说明在同一斜线上（正反斜线）
            if self.chess_board[i] == self.chess_board[n] or n - i == abs(self.chess_board[n] - self.chess_board[i]):
                return False

        return True

    def check(self, n: int):
        """
        依次将第n+1个皇后到第8个皇后放置到棋盘
        :param n:
        """
        # 设置递归头。此时chess_board数组已经写满
        if n == self.queen_num:
            self.s_print()
            return

        # 可放置位置：试着第n个皇后放置第0到7列（因为每个皇后是在不同的行放置，所以不需要设置start值）
        for i in range(self.queen_num):
            # 做出选择
            self.chess_board[n] = i
            # 剪枝处理：如果与之前的皇后无规则冲突，继续放置下一个皇后。否则将该皇后放置到下一列进行尝试
            if self.judge(n):
                self.check(n + 1)
            # 不需要撤销选择，因为下次循环此层皇后状态自动更新


if __name__ == '__main__':
    Queen().check(0)
    pass
