package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


public class B_TrappingRainWater {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] arr = LeetCodeUtils.get1dArr("[0,1,0,2,1,0,1,3,2,1,2,1]");
        System.out.println(solution.trap(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            Deque<Integer> stack = new LinkedList<>();
            int res = 0;

            for (int i = 0; i < height.length; i++) {
                //不满足单调递减栈定义时进行结算
                while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                    int hIdx = stack.removeLast();  //height[hIdx]为底部高度
                    if (stack.isEmpty()) break;

                    int left = stack.peekLast();
                    int right = i;
                    int width = right - left - 1;
                    int h = Math.min(height[left], height[right]) - height[hIdx];
                    res += width * h;
                }
                stack.addLast(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}