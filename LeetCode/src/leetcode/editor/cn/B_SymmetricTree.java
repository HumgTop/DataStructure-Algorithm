package leetcode.editor.cn;

import org.junit.Test;


public class B_SymmetricTree {
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return dfs(root.left, root.right);
        }

        boolean dfs(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;

            if (left == null || right == null || left.val != right.val) return false;

            //递归判断左子树的右节点，右子树的左节点。以及左子树的左节点，右子树的右节点
            return dfs(left.right, right.left) && dfs(left.left, right.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}