package leetcode.editor.cn;


import java.util.HashSet;
import java.util.PriorityQueue;

public class B_ChouShuLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            HashSet<Long> seen = new HashSet<>();   //标记已入堆元素
            minHeap.add(1l);
            seen.add(1l);

            int[] factors = new int[]{2, 3, 5}; //质因子

            long cur;
            for (int i = 0; i < n - 1; i++) {
                cur = minHeap.remove();
                long next;
                for (int factor : factors) {
                    next = cur * factor;
                    //如果未曾入堆，将其入堆
                    if (!seen.contains(next)) {
                        seen.add(next);
                        minHeap.add(next);
                    }
                }
            }

            return minHeap.remove().intValue();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}