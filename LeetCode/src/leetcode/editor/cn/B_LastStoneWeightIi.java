package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;


public class B_LastStoneWeightIi {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int n = stones.length;
            if (n == 1) return stones[0];

            int sum = Arrays.stream(stones).sum();
            int capacity = sum / 2;
            boolean[][] dp = new boolean[n][capacity + 1];  //dp[i][j]表示容量为j的背包能否被装满

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= capacity; j++) {
                    //初始化：i为0时，只有容量为0和stones[0]的背包可以被装满
                    if (i == 0) {
                        dp[i][stones[i]] = true;
                        dp[i][0] = true;
                    } else {
                        if (j - stones[i] >= 0) {
                            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i]];
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }

            for (int j = capacity; j >= 0; j--) {
                if (dp[n - 1][j]) {
                    return sum - 2 * j;
                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}