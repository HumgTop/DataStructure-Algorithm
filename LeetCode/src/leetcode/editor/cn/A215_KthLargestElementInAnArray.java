package leetcode.editor.cn;


//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 761 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class A215_KthLargestElementInAnArray {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            //int[]转最大堆队列
            PriorityQueue<Integer> maxQueue = Arrays.stream(nums).boxed()
                    .collect(Collectors.toCollection(() -> new PriorityQueue<>((o1, o2) -> o2 - o1)));

            for (int i = 0; i < k - 1; i++) {
                maxQueue.remove();
            }

            return maxQueue.remove();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}