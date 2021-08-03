package leetcode.editor.cn;


public class B_PingHengErChaShuLcof {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        Solution solution = new B_PingHengErChaShuLcof().new Solution();
        System.out.println(solution.isBalanced(root));

    }

    public static class TreeNode {
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
        public boolean isBalanced(TreeNode root) {
            return dfs(root) < 0 ? false : true;
        }

        /**
         * @param cur
         * @return 返回当前节点的高度，如果该节点确定非平衡树则返回-9
         */
        int dfs(TreeNode cur) {
            if (cur == null) return 0;
            int leftHeight = dfs(cur.left) + 1;
            if (leftHeight < 0) return -9;  //剪枝
            int rightHeight = dfs(cur.right) + 1;
            if (rightHeight < 0) return -9; //剪枝

            if (Math.abs(leftHeight - rightHeight) > 1) return -9;  //非平衡树

            return Math.max(leftHeight, rightHeight);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}