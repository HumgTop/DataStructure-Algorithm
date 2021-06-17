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
            //递归过程中，完成树的翻转
            TreeNode right = invertTree(root.left);
            TreeNode left = invertTree(root.right);
            //回溯过程中，完成根节点到左右节点的重新连接
            root.left = left;
            root.right = right;

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}