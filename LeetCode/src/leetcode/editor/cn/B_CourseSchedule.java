package leetcode.editor.cn;


import java.util.*;

public class B_CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new B_CourseSchedule().new Solution();
        solution.canFinish(2, new int[][]{{1, 0}});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] degrees = new int[numCourses];    //记录课程i的入度
            HashMap<Integer, Set<Integer>> map = new HashMap<>();   //key为课程i的索引，value为i指出的节点表
            for (int[] p : prerequisites) {
                map.computeIfAbsent(p[1], k -> new HashSet<>()).add(p[0]);
                degrees[p[0]]++;    //p[0]的入度+1
            }
            Queue<Integer> queue = new LinkedList<>();  //队列存入节点索引（入列条件：节点的入度为0）
            for (int i = 0; i < degrees.length; i++) {
                if (degrees[i] == 0) queue.add(i);
            }

            int cnt = 0;    //记录符合拓扑排序规则的节点总数
            while (!queue.isEmpty()) {
                int idx = queue.remove();
                cnt++;
                if (!map.containsKey(idx)) continue;    //如果该节点的邻接表为空，则跳过

                //节点idx指向的节点入度-1
                Set<Integer> neighbors = map.get(idx);
                for (Integer nIdx : neighbors) {
                    degrees[nIdx]--;
                    if (degrees[nIdx] == 0) queue.add(nIdx);    //如果满足入列条件则入列
                }
            }

            //满足拓扑排序的节点总数是否等于节点总数
            return cnt == numCourses;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}