package leetcode.editor.cn;

import java.util.*;

public class A_402RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new A_402RemoveKDigits().new Solution();
        // TO TEST
        System.out.println(solution.removeKdigits("100", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new LinkedList<>();
            int len = num.length();
            for (int i = 0; i < len; i++) {
                char digit = num.charAt(i);
                while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                    deque.removeLast();
                    k--;
                }
                deque.addLast(digit);
            }

            //继续删除元素，直至k==0
            for (int i = 0; i < k; i++) {
                deque.removeLast();
            }

            StringBuilder res = new StringBuilder();
            boolean leadingZero = true;
            while (!deque.isEmpty()) {
                char digit = deque.removeFirst();
                if (leadingZero && digit == '0') continue;
                leadingZero = false;
                res.append(digit);
            }
            return res.length() == 0 ? "0" : res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}