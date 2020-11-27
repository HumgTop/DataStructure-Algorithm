package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class A_621TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new A_621TaskScheduler().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c : tasks)
                map[c - 'A']++;
            PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
            for (int f : map) {
                if (f > 0)
                    queue.add(f);
            }
            int time = 0;
            while (!queue.isEmpty()) {
                int i = 0;

                List<Integer> temp = new ArrayList<>();

                //一轮执行n+1次
                while (i <= n) {
                    if (!queue.isEmpty()) {
                        //将剩余任务数大于0的将入temp
                        if (queue.peek() > 1)
                            temp.add(queue.remove() - 1);
                        else
                            queue.remove();
                    }
                    time++;
                    //如果任务执行完毕
                    if (queue.isEmpty() && temp.size() == 0)
                        break;
                    i++;
                }
                //将temp加入queue
                for (int l : temp)
                    queue.add(l);
            }
            return time;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}