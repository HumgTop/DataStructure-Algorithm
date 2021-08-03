package leetcode.editor.cn;


import com.sun.org.apache.xerces.internal.impl.xs.util.XInt;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class B_MinimumHeightTrees {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> level = new ArrayList<>();
            if (n == 1) {
                level.add(0);
                return level;
            }

            //拓扑排序：定义A节点的度为连接A节点的边的条数
            int[] degrees = new int[n]; //degrees[i]表示节点i的度
            Map<Integer, Set<Integer>> neighbors = new HashMap<>(); //邻接表

            //初始化degrees和邻接表
            for (int[] edge : edges) {
                degrees[edge[0]]++;
                degrees[edge[1]]++;
                neighbors.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
                neighbors.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
            }

            //添加度为1的节点到队列中，开始剥洋葱
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < degrees.length; i++) {
                if (degrees[i] == 1) queue.add(i);
            }


            while (!queue.isEmpty()) {
                int size = queue.size();
                level.clear();
                for (int i = 0; i < size; i++) {
                    Integer cur = queue.remove();
                    level.add(cur); //记录本层所有度为1的节点
                    //剥洋葱：邻接点的度-1
                    for (Integer neighborNode : neighbors.get(cur)) {
                        degrees[neighborNode]--;
                        if (degrees[neighborNode] == 1) queue.add(neighborNode);    //度为1的节点入列
                    }
                }
            }

            //次一层的结果
            return level;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}