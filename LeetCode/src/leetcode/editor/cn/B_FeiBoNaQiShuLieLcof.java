package leetcode.editor.cn;


import java.util.HashMap;

public class B_FeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new B_FeiBoNaQiShuLieLcof().new Solution();
        System.out.println((int) 10E5);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Integer> map;

        public int fib(int n) {
            //动态规划
            int fib1 = 0;
            int fib2 = 1;
            if (n == 0 || n == 1) return n;

            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                res = (fib1 + fib2) % 1000000007;
                fib1 = fib2;
                fib2 = res;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}