package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class A_42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new A_42TrappingRainWater().new Solution();
        // TO TEST
        int[] input = LeetCodeUtils.get1dArr("[4,2,0,3,2,5]");
        System.out.println(solution.trap(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int res = 0;
            //单调递减栈
            Deque<Integer> stack = new LinkedList<>();  //存放是height[]的索引
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                    //如果遇到了高于栈顶的height值，说明可以栈顶高度为底部进行接水
                    int cur = stack.removeLast();   //底部高度
                    if (stack.isEmpty()) break;

                    int l = stack.peekLast();   //接水区域左边界高度下标（l不出栈，接完水后作为新的底部高度：作为下次的cur出栈）
                    int r = i;  //接水区域右边界高度下标
                    //高度为左右边界较低的值减去底部高度
                    int h = Math.min(height[r], height[l]) - height[cur];
                    res += (r - l - 1) * h;
                }
                //保持栈单调递减性质的前提下，入栈
                stack.addLast(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}