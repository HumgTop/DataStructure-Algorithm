package leetcode.editor.cn;

import java.util.*;

public class A_347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new A_347TopKFrequentElements().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> cnt = new HashMap<>();    //key为nums[i]，value为该元素出现次数

            //构建cnt
            for (int num : nums) {
                cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }

            //队列中元素int[]长度为2，下标0为num，下标1为count（按count升序排列）
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            //维护长度为k的最小堆
            cnt.forEach((num, count) -> {
                if (minHeap.size() < k) minHeap.add(new int[]{num, count});
                else {
                    //实时维护一个count值前大的最小堆，如果num大于堆顶将其插入队列中
                    if (count > minHeap.peek()[1]) {
                        minHeap.remove();
                        minHeap.add(new int[]{num, count});
                    }
                }
            });

            int[] res = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                res[i] = minHeap.remove()[0];
            }

            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}