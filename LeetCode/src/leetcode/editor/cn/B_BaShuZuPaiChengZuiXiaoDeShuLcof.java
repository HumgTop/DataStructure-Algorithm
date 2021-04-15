package leetcode.editor.cn;


import java.util.Arrays;

public class B_BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            String[] strings = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strings[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strings, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
            return String.join("", strings);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}