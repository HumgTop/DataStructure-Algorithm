package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class B_Permutations {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;
        List<Integer> level;

        public List<List<Integer>> permute(int[] nums) {
            //排列：每次向下递归过程中，可选择范围不会变小
            res = new ArrayList<>();
            boolean[] seen = new boolean[nums.length];  //标记在当前递归栈中，本元素是否被选择
            this.level = new ArrayList<>();

            dfs(nums, seen);
            return res;
        }

        void dfs(int[] nums, boolean[] seen) {
            if (level.size() == nums.length) {
                res.add(new ArrayList<>(level));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                //本次递归栈中已选择的元素则跳过
                if (seen[i]) continue;
                //做出选择
                seen[i] = true;
                level.add(nums[i]);
                dfs(nums, seen);
                //撤销选择
                seen[i] = false;
                level.remove(level.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}