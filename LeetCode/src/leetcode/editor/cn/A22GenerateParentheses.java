package leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1371 👎 0

import java.util.*;

public class A22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new A22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res;

        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            Deque<String> stack = new LinkedList<>();
            stack.add("(");

            recur(n - 1, n, 1, stack);
            return res;
        }

        /**
         * @param restL 剩余左括号的数目
         * @param restR 剩余右括号的数目
         * @param lSubR 当前栈中左括号数减去右括号数的值，如果此值<0，说明此时的括号组合非法
         * @param stack 存放当前括号的组合
         */
        public void recur(int restL, int restR, int lSubR, Deque<String> stack) {
            //递归头
            if (lSubR == 0 && restR == 0 && restL == 0) {
                StringBuilder sb = new StringBuilder();
                for (String s : stack) {
                    sb.append(s);
                }
                res.add(sb.toString());
            }
            //当还有左括号时
            if (restL > 0) {
                stack.add("(");
                recur(restL - 1, restR, lSubR + 1, stack);
                stack.removeLast();
            }
            //当还有右括号，且添加后括号组合合法
            if (restR > 0 && lSubR - 1 >= 0) {
                stack.add(")");
                recur(restL, restR - 1, lSubR - 1, stack);
                stack.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}