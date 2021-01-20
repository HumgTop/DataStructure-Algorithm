package leetcode.editor.cn;

import jdk.nashorn.internal.ir.CallNode;

import java.util.*;

public class A1584_MinCostToConnectAllPoints {
    public static void main(String[] args) {
        Solution solution = new A1584_MinCostToConnectAllPoints().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> parent = new HashMap<>();
        int res = 0;
        int[] rank; //记录节点的秩
        int edgeCount = 0;  //记录当前最小生成树的边数

        public int minCostConnectPoints(int[][] points) {
            this.rank = new int[points.length];
            //按权值升序排列边
            PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            for (int i = 0; i < points.length - 1; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    int[] edge = new int[3];
                    edge[0] = distance;
                    edge[1] = i;
                    edge[2] = j;
                    edges.add(edge);
                }
            }


            //最小生成树构建完成时，退出循环
            while (edgeCount < points.length - 1) {
                int[] edge = edges.remove();
                merge(edge[1], edge[2], edge[0]);
            }
            return res;
        }

        int find(int p) {
            if (!parent.containsKey(p)) parent.put(p, p);   //初始化父节点
            if (parent.get(p) != p) {
                parent.put(p, find(parent.get(p))); //路径压缩
            }
            return parent.get(p);
        }

        void merge(int p1, int p2, int distance) {
            int root1 = find(p1);
            int root2 = find(p2);
            //如果不构成回路，更新最小生成树
            if (root1 != root2) {
                //按秩合并
                if (root2 > root1) parent.put(root1, root2);
                else parent.put(root2, root1);

                if (rank[root1] == rank[root2]) rank[root1]++;
                res += distance;
                edgeCount++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}