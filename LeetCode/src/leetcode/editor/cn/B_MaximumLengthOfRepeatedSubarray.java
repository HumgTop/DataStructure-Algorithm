package leetcode.editor.cn;

import org.junit.Test;


public class B_MaximumLengthOfRepeatedSubarray {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            //dp[i][j]表示以nums1[i-1]和nums2[j-1]结尾的公共子数组的最大长度
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int res = 0;

            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        res = Math.max(dp[i][j], res);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}