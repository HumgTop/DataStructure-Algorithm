package leetcode.editor.cn;


import java.util.Arrays;

public class B_FourXy4Wx {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int purchasePlans(int[] nums, int target) {
            Arrays.sort(nums);
            int j = nums.length - 1;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                while (i < j && nums[i] + nums[j] > target) {
                    j--;
                }
                if (i == j) break;
                res = (res + j - i) % 1000000007;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}