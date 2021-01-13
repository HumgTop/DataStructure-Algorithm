package leetcode.editor.cn;

public class A684_RedundantConnection {
    public static void main(String[] args) {
        Solution solution = new A684_RedundantConnection().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] parent;

        public int[] findRedundantConnection(int[][] edges) {
            int nodesCount = edges.length;  //节点的个数
            int[] parent = new int[nodesCount + 1]; //记录节点的根
            this.parent = parent;
            //初始化父节点
            for (int i = 1; i <= nodesCount; i++) {
                parent[i] = i;
            }

            for (int[] edge : edges) {
                int node1 = edge[0];
                int node2 = edge[1];
                //如果两个节点没有同一个根节点（说明之前没有连通）
                if (find(node1) != find(node2)) {
                    union(node1, node2);
                } else return edge;
            }

            return new int[0];
        }

        //查询节点idx的根节点
        int find(int idx) {
            if (parent[idx] != idx) {
                parent[idx] = find(parent[idx]);  //继续向上递归查找父节点（根节点的父节点就是自身）
            }
            return parent[idx];
        }

        //将idx1和idx2所在的两棵树合并
        void union(int idx1, int idx2) {
            parent[find(idx1)] = find(idx2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}