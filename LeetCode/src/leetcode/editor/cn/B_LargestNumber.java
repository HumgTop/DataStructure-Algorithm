package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;


public class B_LargestNumber {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{10, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            //定义拼接字符串后的大小规则
            PriorityQueue<String> maxHeap = new PriorityQueue<>((o1, o2) ->
                    (o2 + o1).compareTo(o1 + o2));
            for (int num : nums) {
                maxHeap.add(String.valueOf(num));
            }
            //对前导0的情况特殊判断
            if (maxHeap.peek().equals("0")) {
                return "0";
            }
            StringBuilder res = new StringBuilder();
            while (!maxHeap.isEmpty()) {
                res.append(maxHeap.remove());
            }

            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}