package leetcode.editor.cn;

import org.junit.Test;


public class B_BalancedBinaryTree {
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
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return dfs(root) != -1;
        }

        int dfs(TreeNode node) {
            if (node == null) return 0;

            int left = dfs(node.left);
            if (left == -1) return -1;
            int right = dfs(node.right);
            if (right == -1) return -1;

            if (Math.abs(left - right) > 1) return -1;
            return Math.max(left, right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}