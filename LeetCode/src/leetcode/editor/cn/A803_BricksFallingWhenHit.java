package leetcode.editor.cn;

import java.util.Arrays;

public class A803_BricksFallingWhenHit {
    public static void main(String[] args) {
        Solution solution = new A803_BricksFallingWhenHit().new Solution();
        int[][] input = LeetCodeUtils.get2dArr("[[1,0,0,0],[1,1,1,0]]");
        int[][] hits = {{1, 0}};
        System.out.println(Arrays.toString(solution.hitBricks(input, hits)));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] grid;
        int[][] copy;
        int[] res;
        int rows;
        int cols;
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int disappear = 0;  //本轮击碎砖块后，消失的砖块数（不包括击碎的砖块本身）

        public int[] hitBricks(int[][] grid, int[][] hits) {
            this.rows = grid.length;
            this.cols = grid[0].length;
            this.grid = grid;

            this.copy = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    copy[i][j] = grid[i][j];
                }
            }
            //将copy置为砖块击碎后的状态
            for (int[] hit : hits) {
                copy[hit[0]][hit[1]] = 0;
            }
            for (int c = 0; c < cols; c++) {
                init(0, c);
            }

            res = new int[hits.length];
            //逆序恢复状态
            for (int i = hits.length - 1; i >= 0; i--) {
                int r = hits[i][0];
                int c = hits[i][1];
                if (grid[r][c] == 0) continue;  //如果击碎的是空区域，跳过
                copy[r][c] = 1; //恢复状态
                //如果可以连接到天花板，扫描周围有无值为1的节点
                if (linkedTo2(r, c)) {
                    disappear = 0;  //置0
                    dfs(r, c);
                    disappear--; //击碎的砖块不算入
                    res[i] = Math.max(0, disappear);
                }
            }

            return res;
        }

        //从第一行出发，将能到达的节点标记为2
        void init(int r, int c) {
            if (!(0 <= r && r < rows && 0 <= c && c < cols) || copy[r][c] != 1) return;    //如果越界或者没有砖块则终止
            copy[r][c] = 2;
            //分别向左、右、下深搜
            init(r, c + 1);
            init(r, c - 1);
            init(r + 1, c);
        }

        //判断击碎的砖块能否连接到天花板
        boolean linkedTo2(int r, int c) {
            if (r == 0) return true;
            for (int[] move : moves) {
                int newR = r + move[0];
                int newC = c + move[1];
                if (0 <= newR && newR < rows && 0 <= newC && newC < cols && copy[newR][newC] == 2) return true;
            }
            return false;
        }

        void dfs(int r, int c) {
            if (!(0 <= r && r < rows && 0 <= c && c < cols) || copy[r][c] != 1) return;
            copy[r][c] = 2;
            disappear++;
            for (int[] move : moves) {
                dfs(r + move[0], c + move[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}