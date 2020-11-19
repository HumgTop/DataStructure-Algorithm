package leetcode.editor.cn;


import java.util.*;

public class A399_EvaluateDivision {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private Map<String, HashMap<String, Double>> graph = null;

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            graph = new HashMap<>();
            int cur = 0;

            for (List<String> equation : equations) {
                String x = equation.get(0);
                String y = equation.get(1);
                //构建x和y的邻接表（x->y和y->x的权值互为倒数）
                graph.computeIfAbsent(x, k -> new HashMap<>()).put(y, values[cur]);
                graph.computeIfAbsent(y, k -> new HashMap<>()).put(x, 1.0 / values[cur]);
                cur++;
            }

            double[] res = new double[queries.size()];
            int i = 0;

            for (List<String> query : queries) {
                Set<String> visted = new HashSet<>();
                res[i++] = dfs(query.get(0), query.get(1), visted);
            }
            return res;
        }

        //深搜查询x能否到达y
        private double dfs(String x, String y, Set<String> visited) {
            if (!graph.containsKey(x)) return -1.0;
            if (x.equals(y)) return 1.0;

            //遍历x所有能到达的节点
            for (String key : graph.get(x).keySet()) {
                if (key.equals(y)) {
                    return graph.get(x).get(y);
                } else if (!visited.contains(key)) {
                    //如果key没有被访问过，标记已访问
                    visited.add(key);
                    //对key进行深搜，判断能否到达y
                    double val = dfs(key, y, visited);
                    //如果key可以到达y
                    if (val != -1.0) {
                        //将val乘以x->key的权值
                        return graph.get(x).get(key) * val;
                    }
                }

            }
            return -1.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}