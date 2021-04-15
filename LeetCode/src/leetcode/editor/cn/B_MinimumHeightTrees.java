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
            if (n == 1) return Arrays.stream(new int[]{0}).boxed().collect(Collectors.toList());

            //建立邻接表和节点的出度数组
            int[] degrees = new int[n];
            HashMap<Integer, Set<Integer>> neis = new HashMap<>();
            //初始化邻接表和出度数组
            for (int[] edge : edges) {
                neis.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
                neis.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
                degrees[edge[0]]++;
                degrees[edge[1]]++;
            }
            int[] nodeIdx = new int[n];
            for (int i = 0; i < nodeIdx.length; i++) {
                nodeIdx[i] = i;
            }
            //初始化队列，加入所有度为1的节点索引到度列中
            List<Integer> list = new ArrayList<>();
            for (int idx : nodeIdx) {
                if (degrees[idx] == 1) {
                    list.add(idx);
                }
            }
            Queue<Integer> queue = new LinkedList<>(list);

            ArrayList<Integer> level = new ArrayList<>();   //记录每层元素
            while (!queue.isEmpty()) {
                int size = queue.size();
                level.clear();
                for (int i = 0; i < size; i++) {
                    Integer curIdx = queue.remove();
                    level.add(curIdx);
                    for (Integer neiIdx : neis.get(curIdx)) {
                        degrees[neiIdx]--;
                        if (degrees[neiIdx] == 1) queue.add(neiIdx);    //添加下一层度为1的节点元素
                    }
                }
            }

            return level;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}