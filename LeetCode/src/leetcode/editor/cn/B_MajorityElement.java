package leetcode.editor.cn;

import org.junit.Test;


public class B_MajorityElement {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            //摩尔投票法
            int candidate = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == candidate) {
                    count++;
                } else if (--count == 0) {
                    //count为0，则更换侯选数
                    candidate = nums[i];
                    count = 1;
                }
            }

            return candidate;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}