package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class A621_TaskScheduler {
    public static void main(String[] args) {

        Solution solution = new A621_TaskScheduler().new Solution();
        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            //贪心思想：每次执行剩余次数最多的任务（维护一个最大堆来实现）
            //遍历tasks，记录每个task的个数
            HashMap<Character, Integer> cnt = new HashMap<>();
            for (char task : tasks) {
                cnt.put(task, cnt.getOrDefault(task, 0) + 1);
            }
            PriorityQueue<Integer> taskCnt = new PriorityQueue<>(((o1, o2) -> o2 - o1));
            taskCnt.addAll(cnt.values());   //将记录的任务次数加入最大堆

            int res = 0;

            ArrayList<Integer> restTasks;
            while (!taskCnt.isEmpty()) {
                restTasks = new ArrayList<>(); //记录本轮执行后的剩余任务数
                //每轮任务执行n+1次
                for (int i = 0; i < n + 1; i++) {
                    if (!taskCnt.isEmpty()) {
                        int cur = taskCnt.remove() - 1;
                        if (cur > 0) restTasks.add(cur);    //记录剩余任务数
                        res++;
                        continue;
                    }
                    if (restTasks.isEmpty()) return res;    //如果任务执行完毕返回res
                    res++;  //否则冷却期记录1秒
                }
                taskCnt.addAll(restTasks);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}