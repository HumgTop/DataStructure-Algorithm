package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class B_Permutations {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;

        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];   //标记是否被访问过
            dfs(nums, visited, new ArrayList<>());
            return res;
        }

        void dfs(int[] nums, boolean[] visited, List<Integer> level) {
            if (level.size() == nums.length) {
                //一次全排列完成，返回结果
                res.add(new ArrayList<>(level));
                //最后一次没有添加元素，所以不需移除元素
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                //如果栈中没有被访问过
                if (!visited[i]) {
                    visited[i] = true;
                    level.add(nums[i]);
                    dfs(nums, visited, level);
                    //出栈前，还原状态
                    visited[i] = false;
                    level.remove(level.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}