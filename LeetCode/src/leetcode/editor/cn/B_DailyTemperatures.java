package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


public class B_DailyTemperatures {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] res = new int[n];
            //单调递减栈
            Deque<Integer> stack = new LinkedList<>();  //存放的是温度数组索引
            for (int i = 0; i < temperatures.length; i++) {
                if (!stack.isEmpty()) {
                    //当前元素大于栈顶元素
                    while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                        int curIdx = stack.removeLast();
                        res[curIdx] = i - curIdx;
                    }
                }
                stack.addLast(i);
            }
            //此时栈中如还存在索引元素，说明此后温度不会升高，res中置0
            while (!stack.isEmpty()) {
                res[stack.removeLast()] = 0;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}