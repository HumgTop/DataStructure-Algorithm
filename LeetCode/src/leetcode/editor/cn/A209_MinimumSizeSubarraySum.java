package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class A209_MinimumSizeSubarraySum {
    public static void main(String[] args) {

        Solution solution = new A209_MinimumSizeSubarraySum().new Solution();
        int[] inputArr = LeetCodeUtils.get1dArr("[2,3,1,2,4,3]");
        System.out.println(solution.minSubArrayLen(7, inputArr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int res = Integer.MAX_VALUE;

            int[] sums = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }

            for (int i = 1; i < n + 1; i++) {
                int target = s + sums[i - 1];
                int bound = Arrays.binarySearch(sums, target);  //满足条件的target值索引
                if (bound < 0) bound = -bound - 1;  //如果target值不存在数组中，会返回其应在的：-(索引+1)
                if (bound < n + 1) res = Math.min(res, bound - i + 1);
            }

            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}