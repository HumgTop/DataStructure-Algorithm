package leetcode.editor.cn;

import org.junit.Test;


public class B_DiameterOfBinaryTree {
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
        int res = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return res;
        }

        //返回该节点的深度
        int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftDepth = dfs(node.left);
            int rightDepth = dfs(node.right);
            res = Math.max((leftDepth + rightDepth), res);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}