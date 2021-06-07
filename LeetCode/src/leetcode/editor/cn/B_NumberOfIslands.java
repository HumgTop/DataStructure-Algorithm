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

        public int numIslands(char[][] grid) {
            //dfs
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (dfs(grid, i, j)) res++;
                }
            }

            return res;
        }

        //如果该点是新岛屿，返回true
        boolean dfs(char[][] grid, int r, int c) {
            if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || grid[r][c] != '1') return false;

            //标记此节点已访问
            grid[r][c] = '2';
            for (int[] move : moves) {
                dfs(grid, r + move[0], c + move[1]);
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}