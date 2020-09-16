package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划 
// 👍 372 👎 0

import java.util.Arrays;

public class A213_HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new A213_HouseRobberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];

            return Math.max(myRob(Arrays.copyOfRange(nums, 1, nums.length)), myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)));
        }

        private int myRob(int[] nums) {
            int pre = 0, cur = 0, temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp = cur;
                cur = Math.max(pre + nums[i], cur); //等同于Math.max(dp[i-2]+nums[i],dp[i-1])
                pre = temp;
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}