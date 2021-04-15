package leetcode.editor.cn;


public class B_JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] moves = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;    //记录总共多少个格子可以走
        boolean[][] visited;
        int m;
        int n;

        public int movingCount(int m, int n, int k) {
            visited = new boolean[m][n];
            this.m = m;
            this.n = n;

            dfs(0, 0, k);
            return count;
        }

        void dfs(int r, int c, int k) {
            if (r < 0 || r >= m || c < 0 || c >= n) return;   //越界返回
            if (visited[r][c]) return;

            visited[r][c] = true;

            int curK = getCurK(r) + getCurK(c);
            if (curK > k) {
                return;
            }
            count++;
            for (int[] move : moves) {
                dfs(r + move[0], c + move[1], k);
            }
        }

        //获得当前坐标的数位之和
        int getCurK(int x) {
            if (x >= 10) return x / 10 + x % 10;
            return x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}