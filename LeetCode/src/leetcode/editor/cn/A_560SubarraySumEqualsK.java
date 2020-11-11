package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class A_560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new A_560SubarraySumEqualsK().new Solution();
        // TO TEST
        System.out.println(solution.subarraySum(new int[]{1, 1, 1, 1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            HashMap<Integer, Integer> mp = new HashMap<>(); //记录preSum值出现的次数
            mp.put(0, 1);

            int preSum = 0;
            int res = 0;
            for (int num : nums) {
                preSum += num;
                // 先判断，再存入map
                if (mp.containsKey(preSum - k)) res += mp.get(preSum - k);
                //更新preSum出现的次数
                mp.put(preSum, mp.getOrDefault(preSum, 0) + 1);

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}