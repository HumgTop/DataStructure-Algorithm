package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class B_ZhanDeYaRuDanChuXuLieLcof {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int idx = 0;
            for (int val : pushed) {
                stack.addLast(val);
                //循环匹配到出栈元素则出栈
                while (!stack.isEmpty() && stack.peekLast() == popped[idx]) {
                    stack.removeLast();
                    idx++;
                }
            }

            return idx == popped.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}