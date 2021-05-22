package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class B_ThreeSum {
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(LeetCodeUtils.get1dArr("[0,0,0]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) return new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n - 2; i++) {
                if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) continue;

                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        level.clear();
                        Collections.addAll(level, nums[i], nums[j], nums[k]);
                        res.add(new ArrayList<>(level));
                        //移动j和k，避免重复解
                        int temp1 = nums[j];
                        int temp2 = nums[k];
                        while (j < k && nums[++j] == temp1) ;
                        while (j < k && nums[--k] == temp2) ;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        //移动j指针，使和变大
                        j++;
                    } else k--;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}