package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class A659_SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {

        Solution solution = new A659_SplitArrayIntoConsecutiveSubsequences().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
            for (int x : nums) {
                if (!map.containsKey(x)) {
                    map.put(x, new PriorityQueue<Integer>());
                }
                if (map.containsKey(x - 1)) {
                    int prevLength = map.get(x - 1).poll();
                    if (map.get(x - 1).isEmpty()) {
                        map.remove(x - 1);
                    }
                    map.get(x).offer(prevLength + 1);
                } else {
                    map.get(x).offer(1);
                }
            }
            Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
            for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
                PriorityQueue<Integer> queue = entry.getValue();
                if (queue.peek() < 3) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}