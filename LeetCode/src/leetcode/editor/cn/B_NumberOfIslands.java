package leetcode.editor.cn;

import org.junit.Test;


public class B_NumberOfIslands {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.numIslands(new char[][]{{'1'}, {'1'}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] moves = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;

        public int numIslands(char[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }

            return res;
        }

        //由起点出发，将可到达的1区域染色为2
        void dfs(char[][] grid, int r, int c) {
            //越界返回
            if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || grid[r][c] != '1') return;

            //染色
            grid[r][c] = '2';
            for (int[] move : moves) {
                dfs(grid, r + move[0], c + move[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}