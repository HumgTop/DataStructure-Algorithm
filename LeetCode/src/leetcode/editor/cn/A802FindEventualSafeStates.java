package leetcode.editor.cn;
//在有向图中, 我们从某个节点和每个转向处开始, 沿着图的有向边走。 如果我们到达的节点是终点 (即它没有连出的有向边), 我们停止。 
//
// 现在, 如果我们最后能走到终点，那么我们的起始节点是最终安全的。 更具体地说, 存在一个自然数 K, 无论选择从哪里开始行走, 我们走了不到 K 步后必能
//停止在一个终点。 
//
// 哪些节点最终是安全的？ 结果返回一个有序的数组。 
//
// 该有向图有 N 个节点，标签为 0, 1, ..., N-1, 其中 N 是 graph 的节点数. 图以以下的形式给出: graph[i] 是节点 j 
//的一个列表，满足 (i, j) 是图的一条有向边。 
//
// 
//示例：
//输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//输出：[2,4,5,6]
//这里是上图的示意图。
//
// 
//
// 
//
// 提示： 
//
// 
// graph 节点数不超过 10000. 
// 图的边数不会超过 32000. 
// 每个 graph[i] 被排序为不同的整数列表， 在区间 [0, graph.length - 1] 中选取。 
// 
// Related Topics 深度优先搜索 图 
// 👍 80 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A802FindEventualSafeStates {
    public static void main(String[] args) {
        Solution solution = new A802FindEventualSafeStates().new Solution();
        int[][] graph = new int[7][];
        graph[0] = new int[]{1, 2};
        graph[1] = new int[]{2, 3};
        graph[2] = new int[]{5};
        graph[3] = new int[]{0};
        graph[4] = new int[]{5};
        graph[5] = new int[]{};
        graph[6] = new int[]{};
        // TO TEST

        solution.graph = graph;
        solution.visited = new boolean[7];
        System.out.println(solution.dfs(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] visited;
        int[][] graph;

        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            this.visited = new boolean[n];
            this.graph = graph;

            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (dfs(i)) res.add(i);
            }
            return res;
        }

        public boolean dfs(int node) {
            if (visited[node]) return false;
            if (graph[node].length == 0) return true;

            visited[node] = true;


            for (int dest : graph[node]) {
                if (!dfs(dest)) {
                    visited[node] = false;
                    return false;
                }
            }

            visited[node] = false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}