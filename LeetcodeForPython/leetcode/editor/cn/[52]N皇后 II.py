from typing import *


# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
# 
#  
# 
#  上图为 8 皇后问题的一种解法。 
# 
#  给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
# 
#  示例: 
# 
#  输入: 4
# 输出: 2
# 解释: 4 皇后问题存在如下两个不同的解法。
# [
#  [".Q..",  // 解法 1
#   "...Q",
#   "Q...",
#   "..Q."],
# 
#  ["..Q.",  // 解法 2
#   "Q...",
#   "...Q",
#   ".Q.."]
# ]
#  
# 
#  
# 
#  提示： 
# 
#  
#  皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
# -1 步，可进可退。（引用自 百度百科 - 皇后 ） 
#  
#  Related Topics 回溯算法 
#  👍 188 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def totalNQueens(self, n: int) -> int:
        chessBoard = [0] * n  # 表示皇后i在第i行第chessBoard[i]列
        count = 0

        # 保证每一行、每一列、每一斜线都只有1个皇后
        def judge(number: int) -> bool:
            # 判断当前皇后number与皇后0~number-1位置是否有冲突
            for i in range(number):
                # 如果有任意一个皇后与皇后number在同一列或者同一斜线
                if chessBoard[number] == chessBoard[i] or number - i == abs(chessBoard[number] - chessBoard[i]):
                    return False
            return True

        # 放置皇后0~number
        def check(no: int = 0):
            # 所有皇后放置完成，解法+1
            if no == n:
                nonlocal count
                count += 1
                return
            # 可能的位置有0~n-1列
            for i in range(n):
                chessBoard[no] = i
                # 如果放置在该列合法，则向下递归继续放置
                if judge(no):
                    check(no + 1)

        check()
        return count


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == "__main__":
    print(Solution().totalNQueens(8))
    pass
