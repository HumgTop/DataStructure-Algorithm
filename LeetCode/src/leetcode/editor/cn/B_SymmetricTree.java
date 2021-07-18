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

        private boolean dfs(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;

            if (left == null || right == null || left.val != right.val) return false;
            //本层判断无问题，递归下一层进行判断
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}