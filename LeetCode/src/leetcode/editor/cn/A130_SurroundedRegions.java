package leetcode.editor.cn;


public class A130_SurroundedRegions {
    public static void main(String[] args) {

        Solution solution = new A130_SurroundedRegions().new Solution();
        char[][] board = {{'X'}};
        solution.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int rows;
        int cols;
        char[][] board;
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public void solve(char[][] board) {
            if (board.length == 0) return;
            //搜索边界上的o，凡是与其相连的o全部染色，没有被染色的o可用X填充
            rows = board.length;
            cols = board[0].length;
            this.board = board;

            //遍历第一列和最后一列
            for (int r = 0; r < rows; r++) {
                if (board[r][0] == 'O') dfs(r, 0);
                if (board[r][cols - 1] == 'O') dfs(r, cols - 1);
            }
            //遍历第一行和最后一行
            for (int c = 1; c < cols - 1; c++) {
                if (board[0][c] == 'O') dfs(0, c);
                if (board[rows - 1][c] == 'O') dfs(rows - 1, c);
            }

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (board[r][c] == '+') board[r][c] = 'O';
                    else if (board[r][c] == 'O') board[r][c] = 'X';
                }
            }
        }

        //对边界上的o深搜染色
        void dfs(int r, int c) {
            //终止条件
            if (!(0 <= r && r <= rows - 1 && 0 <= c && c <= cols - 1)) return;
            if (board[r][c] != 'O') return;

            board[r][c] = '+';  //染色

            //递归染色
            for (int[] move : moves) {
                dfs(r + move[0], c + move[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}