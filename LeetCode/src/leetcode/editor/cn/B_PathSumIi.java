package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;


public class B_PathSumIi {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> subRes = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum, 0);
            return res;
        }

        void dfs(TreeNode node, int targetSum, int curSum) {
            if (node == null) return;

            subRes.add(node.val);
            curSum += node.val;
            if (node.left == null && node.right == null && curSum == targetSum) {
                res.add(new ArrayList<>(subRes));
                subRes.removeLast();
                return;
            }
            dfs(node.left, targetSum, curSum);
            dfs(node.right, targetSum, curSum);
            subRes.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}