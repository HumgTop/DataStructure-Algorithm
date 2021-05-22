package leetcode.editor.cn;

import org.junit.Test;


public class B_AddStrings {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int add = 0;    //进位数
            StringBuilder res = new StringBuilder();
            while (i >= 0 || j >= 0 || add != 0) {
                //下标指向负数时，返回0
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int temp = x + y + add;
                res.append(temp % 10);
                add = temp / 10;    //是否进位
                i--;
                j--;
            }

            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}