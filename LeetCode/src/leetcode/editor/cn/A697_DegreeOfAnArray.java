package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class A697_DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new A697_DegreeOfAnArray().new Solution();
        int[] input = LeetCodeUtils.get1dArr("[1,2,2,3,1,4,2]");
        System.out.println(solution.findShortestSubArray(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestSubArray(int[] nums) {
            //key表示出现的值，val[0]表示第一次出现的位置,val[1]表示最后出现的位置，val[2]表示总共出现的次数
            HashMap<Integer, int[]> map = new HashMap<>();
            int maxFq = 0;
            int res = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], new int[]{i, i, 1});
                    continue;
                }
                //更新value
                int[] value = map.get(nums[i]);
                value[1] = i;
                value[2]++;
                map.put(nums[i], value);
            }


            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] value = entry.getValue();
                if (value[2] > maxFq) {
                    maxFq = value[2];
                    res = value[1] - value[0] + 1;
                } else if (value[2] == maxFq) {
                    res = Math.min(res, value[1] - value[0] + 1);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}