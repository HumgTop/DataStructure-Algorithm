package leetcode.editor.cn;


import java.util.HashSet;
import java.util.Set;

public class B_HeWeiSdeLiangGeShuZiLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int l = 0, r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] < target) {
                    l++;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else return new int[]{nums[l], nums[r]};
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}