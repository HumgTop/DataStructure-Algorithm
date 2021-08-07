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
            Arrays.sort(nums);
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            if ((sum & 1) == 1) {
                return false;
            }
            if (nums[n - 1] > sum / 2) return false;
            int target = sum / 2;
            boolean[][] dp = new boolean[n][target + 1];
            //dp[i][0]为true
            //dp[0][nums[0]]为true
            dp[0][nums[0]] = true;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < target + 1; j++) {
                    if (j == 0) dp[i][j] = true;
                    else if (j >= nums[i]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    } else {
                        //不能选取当前元素
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n - 1][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}