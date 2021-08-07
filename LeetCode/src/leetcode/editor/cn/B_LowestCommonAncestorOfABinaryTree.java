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
            //后序遍历：左 右 根
            //终止条件：叶子节点越界或者找p或q返回
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;    //此为最近公共祖先
            } else if (left != null) {
                return left;
            } else return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}