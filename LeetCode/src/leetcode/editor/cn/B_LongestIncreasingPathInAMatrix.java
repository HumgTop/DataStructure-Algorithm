package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;


public class B_LongestIncreasingPathInAMatrix {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] arr = LeetCodeUtils.get2dArr("[[9,9,4],[6,6,8],[2,1,1]]");
        System.out.println(solution.longestIncreasingPath(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] moves = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m;
        int n;

        public int longestIncreasingPath(int[][] matrix) {
            //出度：一个单元格的值比其相邻单元格的值都要大，则其出度为0。dp值为1
            m = matrix.length;
            n = matrix[0].length;
            int[][] outDegrees = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] move : moves) {
                        int nr = i + move[0];
                        int nc = j + move[1];
                        if (isLegal(nr, nc) && matrix[nr][nc] > matrix[i][j]) {
                            outDegrees[i][j]++;
                        }
                    }
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (outDegrees[i][j] == 0) {
                        queue.add(new int[]{i, j});
                    }
                }
            }
            int res = 0;
            while (!queue.isEmpty()) {
                res++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.remove();
                    for (int[] move : moves) {
                        int nr = cur[0] + move[0];
                        int nc = cur[1] + move[1];
                        if (isLegal(nr, nc) && matrix[cur[0]][cur[1]] > matrix[nr][nc]) {
                            outDegrees[nr][nc]--;
                            if (outDegrees[nr][nc] == 0) {
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }

            return res;
        }

        boolean isLegal(int r, int c) {
            return 0 <= r && r < m && 0 <= c && c < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}