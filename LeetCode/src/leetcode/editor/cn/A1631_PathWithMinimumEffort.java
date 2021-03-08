package leetcode.editor.cn;

import java.util.*;

public class A1631_PathWithMinimumEffort {
    public static void main(String[] args) {
        Solution solution = new A1631_PathWithMinimumEffort().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Integer> parent = new HashMap<>(); //节点i的父节点为parent[i]

        public int minimumEffortPath(int[][] heights) {
            //克鲁斯卡尔算法
            int m = heights.length;
            int n = heights[0].length;


            //初始化所有的边集合
            PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));  //按边的权值升序排列
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int id = r * n + c;
                    //构建与当前点右侧点的边
                    if (c + 1 < n) {
                        edges.add(new int[]{id, id + 1, Math.abs(heights[r][c] - heights[r][c + 1])});
                    }
                    //构建与当前点下侧点的边
                    if (r + 1 < m) {
                        edges.add(new int[]{id, id + n, Math.abs(heights[r][c] - heights[r + 1][c])});
                    }
                }
            }

            parent.put(0, 0);
            parent.put(m * n - 1, m * n - 1);
            int res = 0;
            while (!edges.isEmpty() && find(0) != find(m * n - 1)) {    //此处不能用parent.get，必须是find()比较根节点
                int[] edge = edges.remove();
                merge(edge[0], edge[1]);
                res = edge[2];
            }
            return res;
        }

        int find(int id) {
            if (!parent.containsKey(id)) parent.put(id, id);    //初始化父节点
            if (parent.get(id) != id) {
                parent.put(id, find(parent.get(id)));   //路径压缩
            }
            return parent.get(id);
        }

        void merge(int id1, int id2) {
            int root1 = find(id1);
            int root2 = find(id2);
            if (root1 != root2) {
                parent.put(root1, root2);   //将root1合并到root2中
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}