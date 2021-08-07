package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;


public class B_MinCostToConnectAllPoints {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.minCostConnectPoints(LeetCodeUtils.get2dArr("[[0,0],[2,2],[3,10],[5,2],[7,0]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] parents;
        int[][] points;
        int cnt = 0;
        int res = 0;

        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            this.points = points;
            this.parents = new int[n];
            //初始化parents
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            //构建edges
            PriorityQueue<int[]> edges = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    edges.add(new int[]{i, j, getDis(i, j)});
                }
            }
            //edges出列构建最小生成树，完成n-1次联通操作后结束循环
            while (!edges.isEmpty() && cnt < n) {
                int[] edge = edges.remove();
                merge(edge[0], edge[1], edge[2]);
            }
            return res;
        }

        //返回两点间的曼哈顿距离
        int getDis(int idx1, int idx2) {
            return Math.abs(points[idx1][0] - points[idx2][0]) + Math.abs(points[idx1][1] - points[idx2][1]);
        }

        int find(int idx) {
            if (parents[idx] != idx) {
                parents[idx] = find(parents[idx]);
            }
            return parents[idx];
        }

        void merge(int idx1, int idx2, int dis) {
            int root1 = find(idx1);
            int root2 = find(idx2);
            if (root1 != root2) {
                parents[root1] = root2;
                //完成一次联通，更新res和cnt
                res += dis;
                cnt++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}