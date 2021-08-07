package leetcode.editor.cn;


import java.util.*;

public class B_CombinationSum {
    public static void main(String[] args) {
        Solution solution = new B_CombinationSum().new Solution();
        for (List<Integer> list : solution.combinationSum(new int[]{2, 3, 5}, 8)) {
            System.out.println(list);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;
        int target;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            res = new ArrayList<>();
            this.target = target;
            dfs(candidates, 0, 0, new LinkedList<>());
            return res;
        }

        void dfs(int[] candidates, int curSum, int start, Deque<Integer> subRes) {
            if (curSum == target) {
                res.add(new ArrayList<>(subRes));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (curSum + candidates[i] <= target) {
                    //作出选择
                    subRes.add(candidates[i]);
                    dfs(candidates, curSum + candidates[i], i, subRes);  //i之前的元素在下一层不再选择
                    //撤销选择
                    subRes.removeLast();
                } else {
                    return;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}