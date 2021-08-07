package leetcode.editor.cn;

import org.junit.Test;


public class B_ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int cnt = 1;
            int candidate = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == candidate) {
                    cnt++;
                } else if (--cnt == 0) {
                    candidate = nums[i];
                    cnt = 1;
                }
            }

            return candidate;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}