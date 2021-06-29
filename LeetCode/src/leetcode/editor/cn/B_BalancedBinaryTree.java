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
            int leftHeight = dfs(node.left);
            if (leftHeight == -1) return -1;    //非平衡树则返回（剪枝）

            int rightHeight = dfs(node.right);
            if (rightHeight == -1) return -1;   //非平衡树则返回（剪枝）

            if (Math.abs(leftHeight - rightHeight) > 1) return -1;

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}