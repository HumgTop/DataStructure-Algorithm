package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class B_DailyTemperatures {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            //单调递减栈
            Deque<Integer> stack = new LinkedList<>();  //存入temp数组下标
            int[] res = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                //结算
                while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                    Integer idx = stack.removeLast();
                    res[idx] = i - idx;
                }
                stack.addLast(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}