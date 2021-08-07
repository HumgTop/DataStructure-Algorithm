package leetcode.editor.cn;

import org.junit.Test;


public class B_InvertBinaryTree {
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}