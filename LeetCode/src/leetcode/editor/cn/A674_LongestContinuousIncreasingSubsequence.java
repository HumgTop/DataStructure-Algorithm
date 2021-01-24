package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class A674_LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new A674_LongestContinuousIncreasingSubsequence().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            //滑动窗口
            if (nums.length == 0) return 0;
            int res = 0;
            int last = nums[0];
            int curLength = 1;

            for (int i = 1; i < nums.length; i++) {
                if (last < nums[i]) {
                    curLength++;
                } else res = Math.max(res, curLength);

                last = nums[i];
            }

            return res == 0 ? curLength : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}