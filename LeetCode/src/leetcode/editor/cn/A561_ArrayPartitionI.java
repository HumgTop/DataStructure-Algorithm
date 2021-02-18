package leetcode.editor.cn;

import java.util.Arrays;

public class A561_ArrayPartitionI {
    public static void main(String[] args) {
        Solution solution = new A561_ArrayPartitionI().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length; i += 2) {
                res += nums[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}