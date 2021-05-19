package leetcode.editor.cn;

import org.junit.Test;


public class B_LowestCommonAncestorOfABinarySearchTree {
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
            //如果p和q都在root的左子树
            if (root.val > q.val && root.val > p.val) {
                //递归root.left，并返回
                return lowestCommonAncestor(root.left, p, q);
            }
            if (root.val < q.val && root.val < p.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            //若p和q在root的不同子树（或者p本身就是祖先），则返回root（此时即为最近的公共祖先）
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}