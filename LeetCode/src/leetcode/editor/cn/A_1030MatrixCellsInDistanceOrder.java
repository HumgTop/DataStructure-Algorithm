package leetcode.editor.cn;

import com.sun.tools.javac.code.Lint;

import java.util.*;

public class A_1030MatrixCellsInDistanceOrder {
    public static void main(String[] args) {
        Solution solution = new A_1030MatrixCellsInDistanceOrder().new Solution();
        // TO TEST
        solution.allCellsDistOrder(2, 2, 0, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int R;
        int C;
        int[][] used;
        Map<int[], Integer> map;

        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            used = new int[R][C];
            this.R = R;
            this.C = C;
            map = new HashMap<>();

            dfs(r0, c0, 0);
            int[][] res = map.keySet().toArray(new int[0][0]);
            Arrays.sort(res, (Comparator.comparingInt(k -> map.get(k))));
            for (int[] key : res) {
                System.out.println(map.get(key));
            }

            return res;
        }

        void dfs(int r, int c, int step) {
            //终止条件：如果该坐标被访问过或者坐标越界
            if (!(0 <= r && r < R && 0 <= c && c < C)) return;
            if (used[r][c] == 1) return;
            used[r][c] = 1; //标记已访问

            map.put(new int[]{r, c}, step);
            for (int i = 0; i < move.length; i++) {
                dfs(r + move[i][0], c + move[i][1], step + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}