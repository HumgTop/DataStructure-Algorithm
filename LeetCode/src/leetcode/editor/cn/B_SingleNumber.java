package leetcode.editor.cn;

import org.junit.Test;


public class B_SingleNumber {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(4 ^ 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}