package leetcode.editor.cn;


public class A695_MaxAreaOfIsland {
    public static void main(String[] args) {

        Solution solution = new A695_MaxAreaOfIsland().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;
        int m;
        int n;
        int[][] grid;
        int curArea = 0;

        public int maxAreaOfIsland(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            this.grid = grid;

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == 1) {
                        dfs(r, c);
                        curArea = 0;
                    }
                }
            }

            return res;
        }

        void dfs(int r, int c) {
            if (!(0 <= r && r <= m - 1 && 0 <= c && c <= n - 1) || grid[r][c] != 1) {
                res = Math.max(curArea, res);
                return;
            }  //终止条件：坐标越界，或者该网格已经被访问

            grid[r][c] = -1;    //标记该网格已被访问
            curArea++;

            for (int[] move : moves) {
                dfs(r + move[0], c + move[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}