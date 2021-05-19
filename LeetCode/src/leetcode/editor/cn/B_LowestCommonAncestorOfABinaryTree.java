package leetcode.editor.cn;

import org.junit.Test;


public class B_LowestCommonAncestorOfABinaryTree {
    @Test
    public void test() {
        Solution solution = new Solution();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //后序遍历
            if (root == p || root == q || root == null) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            } else if (left != null || right != null) {
                return left == null ? right : left;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}