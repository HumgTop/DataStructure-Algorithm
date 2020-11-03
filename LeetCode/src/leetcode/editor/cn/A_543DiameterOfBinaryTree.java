package leetcode.editor.cn;

public class A_543DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new A_543DiameterOfBinaryTree().new Solution();
        // TO TEST
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
        int res = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return res;
        }

        /**
         * @param node
         * @return 该节点的高度
         */
        int dfs(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = dfs(node.left);    //左子树高度
            int rightHeight = dfs(node.right);  //右子树高度

            //维护res为已遍历节点的左右子树最大高度和
            res = Math.max(res, leftHeight + rightHeight);
            //返回本节点的高度=下层节点的最大高度+1
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}