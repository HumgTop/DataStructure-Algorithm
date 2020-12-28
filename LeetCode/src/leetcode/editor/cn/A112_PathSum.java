package leetcode.editor.cn;


public class A112_PathSum {
    public static void main(String[] args) {

        Solution solution = new A112_PathSum().new Solution();

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
        int sum;

        public boolean hasPathSum(TreeNode root, int sum) {
            this.sum = sum;
            return dfs(root, 0);
        }

        boolean dfs(TreeNode node, int curSum) {
            if (node == null) return false;
            //终止条件：遍历到叶子节点
            if (node.left == null && node.right == null) {
                if (node.val + curSum == sum) return true;
                return false;
            }

            return dfs(node.left, curSum + node.val) || dfs(node.right, curSum + node.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}