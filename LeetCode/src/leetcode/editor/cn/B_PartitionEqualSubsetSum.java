package leetcode.editor.cn;


import java.util.Arrays;
import java.util.stream.IntStream;

public class B_PartitionEqualSubsetSum {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    class Solution {
        public boolean canPartition(int[] nums) {
            //dp[i][j]表示索引(0,i)之间的元素能否组成和为j的子集
            int sum = Arrays.stream(nums).sum();
            //如果sum是奇数
            if ((sum & 1) == 1)
                return false;
            int maxNum = Arrays.stream(nums).max().getAsInt();
            int target = sum / 2;
            if (target < maxNum) return false;

            boolean[][] dp = new boolean[nums.length][target + 1];
            //处理第1行、第1列
            dp[0][nums[0]] = true;
            for (int i = 0; i < nums.length; i++) {
                dp[i][0] = true;
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j < target + 1; j++) {
                    if (j >= nums[i]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    } else
                        dp[i][j] = dp[i - 1][j];
                }
            }

            return dp[nums.length - 1][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}