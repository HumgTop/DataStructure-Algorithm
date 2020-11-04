package leetcode.editor.cn;

public class A_79WordSearch {
    public static void main(String[] args) {
        Solution solution = new A_79WordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] board;
        String word;
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.word = word;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0) && dfs(i, j, 0)) return true;
                }
            }
            return false;
        }

        /**
         * @param r
         * @param c
         * @param index 当前匹配到的word的下标
         * @return
         */
        boolean dfs(int r, int c, int index) {
            //如果网格坐标越界，返回false
            if (!(0 <= r && r < board.length && 0 <= c && c < board[0].length)) return false;

            //如果本网格没有被选择，而且匹配，进行下一层递归匹配
            if (board[r][c] == word.charAt(index)) {
                //如果匹配，标记该网格被选择
                char temp = board[r][c];
                board[r][c] = 1;
                //终止条件：完成word的所有匹配
                if (index == word.length() - 1) return true;

                for (int[] move : moves) {
                    //如果下层返回true，向上传递
                    if (dfs(r + move[0], c + move[1], index + 1)) return true;
                }
                //取消标记
                board[r][c] = temp;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}