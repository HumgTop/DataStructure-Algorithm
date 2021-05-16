package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;


public class B_KthLargestElementInAnArray {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                minHeap.add(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > minHeap.peek()) {
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
            return minHeap.remove();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}