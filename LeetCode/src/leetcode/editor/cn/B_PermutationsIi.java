package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;


public class B_PermutationsIi {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> results;
        Deque<Integer> level;

        public List<List<Integer>> permuteUnique(int[] nums) {
            results = new ArrayList<>();
            level = new LinkedList<>();
            Arrays.sort(nums);
            dfs(nums, new boolean[nums.length]);

            return results;
        }

        void dfs(int[] nums, boolean[] seen) {
            if (level.size() == nums.length) {
                results.add(new ArrayList<>(level));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                //level栈中该元素已选择，则跳过
                if (seen[i]) continue;
                seen[i] = true;
                level.addLast(nums[i]);
                dfs(nums, seen);
                //撤销选择
                seen[i] = false;
                level.removeLast();
                //跳过后续值相等的索引（同层值相等的元素只选择一次）
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}