package leetcode.editor.cn;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2422 👎 0

import java.math.BigInteger;

public class No53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new No53_MaximumSubarray().new Solution();

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int max = nums[0];    //记录最大值
            for (int num : nums) {
                sum = Math.max(sum + num, num); //动态规划：设长度为n的数组的最大子数组和为f(n)，f(n)=Math.max(f(n-1),nums[n-1])。
                max = Math.max(max, sum);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//    时间复杂度 O(N^3)
//    class Solution {
//        public int maxSubArray(int[] nums) {
//            int max = nums[0];
//
//            if (nums.length == 1) {
//                return nums[0];
//            }
//
//            for (int x = 0; x < nums.length; x++) {
//                for (int y = 1; y <= nums.length - x; y++) {
//                    int index = x;
//                    int sum = 0;
//                    //每个单元格累加y次
//                    for (int i = 0; i < y; i++) {
//                        sum += nums[index++];
//                    }
//                    if (max < sum) max = sum;
//                }
//            }
//
//            return max;
//        }
//    }
}