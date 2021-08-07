package leetcode.editor.cn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


public class B_ValidParentheses {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] chs = s.toCharArray();
            Deque<Character> stack = new LinkedList<>();

            for (char ch : chs) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.addLast(ch);
                } else if (stack.isEmpty()) {
                    return false;
                } else if (ch == ')' && stack.peekLast() == '(') {
                    stack.removeLast();
                } else if (ch == ']' && stack.peekLast() == '[') {
                    stack.removeLast();
                } else if (ch == '}' && stack.peekLast() == '{') {
                    stack.removeLast();
                } else return false;
            }

            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}