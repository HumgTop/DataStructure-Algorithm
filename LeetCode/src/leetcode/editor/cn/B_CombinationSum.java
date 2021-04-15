package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_CombinationSum {
    public static void main(String[] args) {
        Solution solution = new B_CombinationSum().new Solution();
        for (List<Integer> list : solution.combinationSum(new int[]{2, 3, 6, 7}, 7)) {
            System.out.println(list);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;
        int target;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.target = target;
            res = new ArrayList<>();
            dfs(candidates, 0, 0, new ArrayList<>());
            return res;
        }

        void dfs(int[] candidates, int curSum, int start, List<Integer> subRes) {
            if (curSum == target) {
                res.add(new ArrayList<>(subRes));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (curSum + candidates[i] <= target) {
                    subRes.add(candidates[i]);
                    dfs(candidates, curSum + candidates[i], i, subRes); //i之前的元素在下一层不再组合
                    subRes.remove(subRes.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}