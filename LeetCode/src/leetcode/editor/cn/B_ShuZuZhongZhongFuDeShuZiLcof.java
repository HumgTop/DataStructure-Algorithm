package leetcode.editor.cn;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class B_ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i) {
                    //为下标i找到正确的元素，可能有多次交换
                    if (nums[i] == nums[nums[i]]) return nums[i];
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}