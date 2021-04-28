package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.BiFunction;

public class B_PathWithMinimumEffort {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int rows = heights.length;
            int cols = heights[0].length;
            int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
            boolean[][] visited = new boolean[rows][cols];  //标记已对该点进行中转优化，且到该点最短路径已确定
            int[][] dist = new int[rows][cols]; //起点到该点的最小消耗值
            //初始化dist：默认值为最大整形
            for (int i = 0; i < dist.length; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));  //最小堆
            pq.add(new int[]{0, 0, 0}); //初始化：添加起点

            int res = 0;
            while (!pq.isEmpty()) {
                int[] cur = pq.remove();
                if (cur[0] == rows - 1 && cur[1] == cols - 1) {
                    //到终点的最短路径已确定，其余点无须再遍历
                    res = cur[2];
                    break;
                }
                if (visited[cur[0]][cur[1]]) continue;

                visited[cur[0]][cur[1]] = true;   //标记已对此节点进行中转优化
                //添加cur的邻接点到队列
                for (int[] move : moves) {
                    int nr = cur[0] + move[0];
                    int nc = cur[1] + move[1];
                    //如果该点越界，或者到该点的最短路径已确定，则跳过
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                        continue;

                    //优化(0,0)->(nr,nc)的最短路径：直达或者通过(cur[0],cur[1])中转
                    dist[nr][nc] = Math.min(dist[nr][nc], Math.max(cur[2], Math.abs(heights[cur[0]][cur[1]] - heights[nr][nc])));
                    pq.add(new int[]{nr, nc, dist[nr][nc]});    //将已确定最短路径的节点入列
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}