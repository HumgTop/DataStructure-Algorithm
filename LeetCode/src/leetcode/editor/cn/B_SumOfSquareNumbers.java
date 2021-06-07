package leetcode.editor.cn;

import org.junit.Test;


public class B_SumOfSquareNumbers {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            if (Math.sqrt(c) % 1 == 0) return true;

            int k = (int) Math.ceil(Math.sqrt(c));
            int i = 0;
            int j = k;
            while (i <= j) {
                int curSum = i * i + j * j;
                if (curSum < c) {
                    //i指针右移
                    i++;
                } else if (curSum > c) {
                    j--;
                } else {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}