package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A842_SplitArrayIntoFibonacciSequence {
    public static void main(String[] args) {

        Solution solution = new A842_SplitArrayIntoFibonacciSequence().new Solution();
        System.out.println(solution.splitIntoFibonacci("214748364721474836422147483641"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 第1位和第2位元素可以任意选取
     */
    class Solution {
        char[] origin;
        int n;
        Stack<Integer> res = new Stack<>();
        int f1;
        int f2;

        public List<Integer> splitIntoFibonacci(String S) {
            n = S.length();
            origin = S.toCharArray();

            for (int selectLen1 = 1; selectLen1 <= (n - 1) / 2; selectLen1++) {
                for (int selectLen2 = 1; selectLen2 <= n - 2 * selectLen1; selectLen2++) {
                    String s1 = S.substring(0, selectLen1);
                    if (s1.length() > 1 && s1.charAt(0) == '0') continue;   //多位数不能以0开头
                    try {
                        f1 = Integer.parseInt(s1);
                    } catch (Exception e) {
                        continue;
                    }
                    String s2 = S.substring(selectLen1, selectLen1 + selectLen2);
                    if (s2.length() > 1 && s2.charAt(0) == '0') continue;
                    try {
                        f2 = Integer.parseInt(s2);
                    } catch (Exception e) {
                        continue;
                    }
                    res.add((int) f1);
                    res.add((int) f2);
                    if (dfs(selectLen1 + selectLen2, f1, f2)) return res;
                    res.clear();
                }
            }

            return new ArrayList<>();
        }

        /**
         * @param begin 本次选取开始的索引
         * @param
         */
        boolean dfs(int begin, int f1, int f2) {
            long cur = f1 + f2;
            char[] chars = String.valueOf(cur).toCharArray();
            for (char ch : chars) {
                if (begin >= n || origin[begin++] != ch) return false;
            }
            res.add((int) cur);

            //终止条件
            if (begin == n) return true;

            return dfs(begin, f2, (int) cur);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}