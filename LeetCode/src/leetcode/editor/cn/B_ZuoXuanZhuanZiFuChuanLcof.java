package leetcode.editor.cn;

import org.junit.Test;


public class B_ZuoXuanZhuanZiFuChuanLcof {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            int len = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = n; i < len; i++) {
                sb.append(s.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                sb.append(s.charAt(i));
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}