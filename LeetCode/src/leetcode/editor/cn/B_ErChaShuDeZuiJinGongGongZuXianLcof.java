package leetcode.editor.cn;

import org.junit.Test;


public class B_ErChaShuDeZuiJinGongGongZuXianLcof {
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
            //越过叶子节点或者遍历到p和q节点直接返回
            if (root == null || root == p || root == q) {
                return root;
            }
            //如果为null，说明p或q不在此子树中
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            //1.left和right同时为空，说明p和q不在此root子树中（其中一种情况：此节点为叶子节点）
            if (left == null && right == null) return null;
            //2.left和right同时不为空，说明root为最近公共祖先
            if (left != null && right != null) return root;
            //3.left和right一者为空，一者不为空
            //不为空的节点，要不是公共祖先节点，要不就是p或q节点本身，直接向上返回
            return left == null ? right : left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}