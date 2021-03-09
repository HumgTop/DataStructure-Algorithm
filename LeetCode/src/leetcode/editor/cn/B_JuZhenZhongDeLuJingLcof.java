package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class B_JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int rows;
        int cols;
        char[][] board;

        public boolean exist(char[][] board, String word) {
            rows = board.length;
            cols = board[0].length;
            visited = new boolean[rows][cols];
            this.board = board;
            if (word.length() > rows * cols) return false;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (dfs(i, j, word, 0)) return true;
                }
            }

            return false;
        }

        boolean dfs(int r, int c, String word, int idx) {
            //越界返回false
            if (r < 0 || r > rows - 1 || c < 0 || c > cols - 1) return false;

            if (!visited[r][c] && word.charAt(idx) == board[r][c]) {
                if (idx == word.length() - 1) return true;
                visited[r][c] = true;

                for (int[] move : moves) {
                    if (dfs(r + move[0], c + move[1], word, idx + 1)) return true;
                }
                visited[r][c] = false;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}