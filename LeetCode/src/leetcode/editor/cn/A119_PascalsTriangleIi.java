package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class A119_PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new A119_PascalsTriangleIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            rowIndex += 1;
            int[] dp = new int[rowIndex];
            dp[0] = 1;

            for (int k = 1; k <= rowIndex; k++) {
                //每次对数组索引的[1,k-1]进行更新（从右往左）
                for (int i = k - 1; i >= 1; i--) {
                    dp[i] = dp[i - 1] + dp[i];
                }
            }

            return Arrays.stream(dp).boxed().collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}