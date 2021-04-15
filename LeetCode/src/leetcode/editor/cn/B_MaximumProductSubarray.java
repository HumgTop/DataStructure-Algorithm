package leetcode.editor.cn;


import java.util.Arrays;

public class B_MaximumProductSubarray {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            Dp[] dp = new Dp[nums.length];  //dp[i]表示以nums[i]结尾的子数组对象（保存了子数组最大乘积和最小乘积）
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new Dp();
            }

            int res = nums[0];
            dp[0].max = nums[0];
            dp[0].min = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    //当前元素为负数，则最大值应从dp[i-1]的子数组最小乘积转移
                    dp[i].max = Math.max(nums[i], dp[i - 1].min * nums[i]);
                    dp[i].min = Math.min(nums[i], dp[i - 1].max * nums[i]);
                } else {
                    dp[i].max = Math.max(nums[i], dp[i - 1].max * nums[i]);
                    dp[i].min = Math.min(nums[i], dp[i - 1].min * nums[i]);
                }
                res = Math.max(res, dp[i].max);
            }

            return res;
        }
    }

    class Dp {
        int min;    //当前子数组对象的最小乘积
        int max;    //当前子数组对象的最大乘积
    }
//leetcode submit region end(Prohibit modification and deletion)


}