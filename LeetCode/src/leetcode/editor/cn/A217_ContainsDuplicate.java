package leetcode.editor.cn;


import java.util.Arrays;
import java.util.stream.Collectors;

public class A217_ContainsDuplicate {
    public static void main(String[] args) {

        Solution solution = new A217_ContainsDuplicate().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
//            return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() < nums.length;
            return Arrays.stream(nums).distinct().count() < nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}