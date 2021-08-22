package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


public class B_TrappingRainWater {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            Deque<Integer> stack = new LinkedList<>();
            int res = 0;

            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                    int bottom = stack.removeLast();
                    if (stack.isEmpty()) break;

                    int left = stack.peekLast();    //左边界下标
                    int right = i;  //右边界下标
                    int width = right - left - 1;
                    int h = Math.min(height[left], height[right]) - height[bottom];
                    res += width * h;
                }

                stack.addLast(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}