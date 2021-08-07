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
            Deque<Integer> stack = new LinkedList<>();  //单调递减栈
            int res = 0;
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                    int cur = stack.removeLast();   //当前底部高度（cur是栈中的最小值）
                    if (stack.isEmpty()) break;
                    int left = stack.peekLast();    //左边界高度
                    int right = i;  //右边界高度
                    int curWidth = right - left - 1;    //接水区域宽度
                    int curHeight = Math.min(height[left], height[right]) - height[cur];    //接水区域高度
                    res += curHeight * curWidth;
                }
                stack.addLast(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}