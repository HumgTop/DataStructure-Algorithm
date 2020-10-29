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


import java.util.ArrayList;
import java.util.List;

public class A22_GenerateParentheses {
    public static void main(String[] args) {
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res;

        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            recur(n - 1, n, 1, "(");
            return res;
        }

        /**
         * @param restL 剩余的左括号数量
         * @param restR 剩余的右括号数量
         * @param lSubR 当前temp中，左括号数减去右括号数的值
         * @param temp  当前的括号组合
         */
        public void recur(int restL, int restR, int lSubR, String temp) {
            // 递归头
            if (lSubR == 0 && restR == 0 && restL == 0) {
                res.add(temp);
            }

            if (restL > 0) {
                recur(restL - 1, restR, lSubR + 1, temp + "(");
            }
            if (restR > 0 && lSubR - 1 >= 0) {
                recur(restL, restR - 1, lSubR - 1, temp + ")");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}