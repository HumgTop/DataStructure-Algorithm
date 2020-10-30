package leetcode.editor.cn;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 833 👎 0

public class A200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new A200NumberOfIslands().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m;
        int n;

        public int numIslands(char[][] grid) {
            int res = 0;
            m = grid.length;
            n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);    //每染色一次岛屿，res++
                        res++;
                    }
                }
            }
            return res;
        }

        //给定一个值为1的网格，将与其相邻的值为1的网格全部染色为2
        private void dfs(char[][] grid, int r, int c) {
            //越界返回
            if (!(0 <= r && r < m && 0 <= c && c < n)) return;
            //网格值不为1返回
            if (grid[r][c] != '1') return;

            //染色为2
            grid[r][c] = '2';
            //进行递归染色
            for (int[] d : move) {
                dfs(grid, r + d[0], c + d[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}